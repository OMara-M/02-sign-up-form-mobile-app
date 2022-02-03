package edu.temple.signupform

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class FormActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // get references to user inputs on the Form
        val usrName = findViewById<TextView>(R.id.editTextName)
        val usrEmail = findViewById<TextView>(R.id.editTextEmail)
        val usrPassword = findViewById<TextView>(R.id.editTextPassword)
        val confirmPassword = findViewById<TextView>(R.id.editTextConfirmPassword)
        val empty = ""


        findViewById<Button>(R.id.btnSave).setOnClickListener {

            if (usrName.text.toString() == empty) {
                usrName.error = "Please enter a name"
            }
            if (usrEmail.text.toString() == empty) {
                usrEmail.error = "Please enter an Email"
            }
            if (usrPassword.text.toString() == empty) {
                usrPassword.error = "Please enter a Password"
            }
            if (confirmPassword.text.toString() == empty) {
                confirmPassword.error = "Please enter a Password"
            }

            if (usrPassword.text.equals(confirmPassword.text)) {
                usrPassword.error = "passwords must match"
                confirmPassword.error = "passwords must match"
            }

            if (usrName.error == null && usrEmail.error == null &&
                usrPassword.error == null && confirmPassword.error == null
            ) {
                Toast
                    .makeText(
                        this@FormActivity,
                        "Thank you for signing up ${usrName.text}",
                        Toast.LENGTH_LONG
                    )
                    .show()
            }

        }

    }
}