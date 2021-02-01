package com.RecyclerView6.RecyclerView6.FirebaseActivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.RecyclerView6.R
import com.google.firebase.auth.FirebaseAuth

class ResetActivity : AppCompatActivity() {

    private lateinit var emailEditText: EditText
    private lateinit var sendButton: Button

    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset)

        mAuth = FirebaseAuth.getInstance()

        emailEditText = findViewById(R.id.resetEmailEditText)
        sendButton = findViewById(R.id.resetButton)

        sendButton.setOnClickListener {
            val email = emailEditText.text.toString()
            if(email.isEmpty()){
                Toast.makeText(this,"Error Occurred!", Toast.LENGTH_LONG).show()
            } else {
                mAuth.sendPasswordResetEmail(email).addOnCompleteListener { task->
                    if(task.isSuccessful){
                        Toast.makeText(this,"Reset link has been sent to your Email!", Toast.LENGTH_LONG).show()
                        startActivity(Intent(this, MainActivity2::class.java))
                        finish()
                    } else{
                        Toast.makeText(this,"Error Occurred!", Toast.LENGTH_LONG).show()

                    }
                }
            }
        }
    }
}