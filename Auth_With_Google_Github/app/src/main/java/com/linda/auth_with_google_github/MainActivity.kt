package com.linda.auth_with_google_github

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.linda.auth_with_google_github.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var auth : FirebaseAuth
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        val googleSignInClient = GoogleSignIn.getClient(this, gso)

        val email = intent.getStringExtra("email")

        binding.tvEmail.text = email

        binding.btnSignoutGoogle.setOnClickListener {
            auth.signOut()
            googleSignInClient.signOut()
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}