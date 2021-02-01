package com.RecyclerView6.RecyclerView6.FirebaseActivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.RecyclerView6.R
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {

    private lateinit var inputEmail: EditText
    private lateinit var inputPassword: EditText
    private lateinit var inputPassword2:EditText
    private lateinit var registerButton: Button
    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)


        mAuth = FirebaseAuth.getInstance()


        inputEmail = findViewById(R.id.signUpEmailEditText)
        inputPassword = findViewById(R.id.signUpPasswordEditText)
        inputPassword2 = findViewById(R.id.signUpPassword2EditText)
        registerButton = findViewById(R.id.signUpButton)

        registerButton.setOnClickListener {
            val email = inputEmail.text.toString()
            val password = inputPassword.text.toString()
            val password2 =inputPassword2.text.toString()
            if( email.isEmpty() || password.isEmpty() || password2.isEmpty()){
                Toast.makeText(this,"Empty Field(s)!", Toast.LENGTH_LONG).show()
            } else if (password!=password2){
                Toast.makeText(this, "Passwords Don't Match", Toast.LENGTH_LONG).show()


            }else{
                mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        if(task.isSuccessful){
                            Toast.makeText(this,"Registration Successful",Toast.LENGTH_LONG).show()
                            ///(DOESNT WORK WITH THIS CODE. WORKS WITHOUT IT)startActivity(Intent(this, MainActivity2::class.java ))
                            finish()
                        }else{
                            Toast.makeText(this,"Error Occurred!", Toast.LENGTH_LONG).show()
                        }

                }
            }
        }
    }
}