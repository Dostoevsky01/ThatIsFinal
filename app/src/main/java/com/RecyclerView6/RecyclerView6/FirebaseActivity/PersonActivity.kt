package com.RecyclerView6.RecyclerView6.FirebaseActivity

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.RecyclerView6.R
import com.google.firebase.auth.FirebaseAuth


class PersonActivity : Fragment(R.layout.activity_person) {


    private lateinit var personInfoTextView:TextView
    private lateinit var changePasswordButton: Button
    private lateinit var logOutButton: Button
    private lateinit var mAuth: FirebaseAuth

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        mAuth = FirebaseAuth.getInstance()

        super.onCreate(savedInstanceState)

        personInfoTextView = view.findViewById(R.id.personInfoTextView)
        changePasswordButton = view.findViewById(R.id.passwordChangeButton)
        logOutButton = view.findViewById(R.id.logoutButton)

        personInfoTextView.text = mAuth.currentUser?.email

        logOutButton.setOnClickListener {

            mAuth.signOut()
            startActivity(Intent(context, MainActivity2::class.java))
            Toast.makeText(activity, "Signed Out!", Toast.LENGTH_SHORT).show()
            activity?.finish()

        }

        changePasswordButton.setOnClickListener {
            startActivity(Intent(context, PasswordChangeActivity::class.java))


        }
    }
}