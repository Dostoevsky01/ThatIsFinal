package com.RecyclerView6.RecyclerView6.FirebaseActivity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.RecyclerView6.R
import com.google.firebase.auth.FirebaseAuth

class PasswordChangeActivity : AppCompatActivity() {

    private lateinit var changePasswordEditText: EditText
    private lateinit var changePasswordEditText2: EditText
    private lateinit var changePasswordButton: Button
    private lateinit var mAuth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {



        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_password_change)

        mAuth = FirebaseAuth.getInstance()
        changePasswordEditText = findViewById(R.id.changePasswordEditText)
        changePasswordEditText2 = findViewById(R.id.changePasswordEditText2)
        changePasswordButton = findViewById(R.id.changePasswordButton)

        changePasswordButton.setOnClickListener {
            val newPassword = changePasswordEditText.text.toString()
            val newPassword2 = changePasswordEditText2.text.toString()

            if (newPassword.isEmpty() || newPassword2.isEmpty()){
                Toast.makeText(this,"Field(s) are empty!", Toast.LENGTH_LONG).show()
            }else if ( newPassword != newPassword2){
                Toast.makeText(this,"Passwords Don't Match!", Toast.LENGTH_LONG).show()
            }else {


                mAuth.currentUser?.updatePassword(newPassword)
                    ?.addOnCompleteListener{ task->
                        if (task.isSuccessful){
                            mAuth.signOut()
                            startActivity(Intent(this, MainActivity2::class.java))
                            Toast.makeText(this,"Password Change Successful", Toast.LENGTH_LONG).show()
                            finish()

                        }else{
                            Toast.makeText(this,"Error Occurred!",Toast.LENGTH_LONG).show()

                        }

                }

            }
        }
    }
}