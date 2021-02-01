package com.RecyclerView6.RecyclerView6.FirebaseActivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.RecyclerView6.RecyclerView6.MainWork.MainActivity4
import com.example.RecyclerView6.R
import com.google.firebase.auth.FirebaseAuth

class MainActivity2 : AppCompatActivity() {


    private lateinit var inputEmail:EditText
    private lateinit var inputPassword:EditText
    private lateinit var loginButton:Button
    private lateinit var registerButton: Button
    private lateinit var resetButton: Button

    private lateinit var mAuth:FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mAuth = FirebaseAuth.getInstance()

        if (mAuth.currentUser !=null){
            startActivity(Intent(this, PersonActivity::class.java))
            finish()
        }

        setContentView(R.layout.firebase_auth)


        inputEmail = findViewById(R.id.signInEmailEditText)
        inputPassword =findViewById(R.id.signInPasswordEditText)
        loginButton = findViewById(R.id.signInButton)
        registerButton = findViewById(R.id.regButton)
        resetButton = findViewById(R.id.resetPasswordButton)

        loginButton.setOnClickListener {
            val email = inputEmail.text.toString()
            val password = inputPassword.text.toString()


            if (email.isEmpty() || password.isEmpty()){
                Toast.makeText(this,"Empty Field(s)!", Toast.LENGTH_LONG).show()
            } else {
                mAuth.signInWithEmailAndPassword(email,password)
                        .addOnCompleteListener { task->
                            if (task.isSuccessful){
                                Toast.makeText(this,"Login Successful",Toast.LENGTH_SHORT).show()
                                startActivity(Intent(this, MainActivity4::class.java))
                                finish()
                            } else{
                                Toast.makeText(this,"Error Occurred!",Toast.LENGTH_LONG).show()
                            }
                        }

            }



        }

        registerButton.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))

        }

        resetButton.setOnClickListener {

          startActivity(Intent(this, ResetActivity::class.java))

        }


    }
}