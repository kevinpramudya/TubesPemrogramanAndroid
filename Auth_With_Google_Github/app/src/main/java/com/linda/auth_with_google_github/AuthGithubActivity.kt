package com.linda.auth_with_google_github

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.OAuthProvider
import com.linda.auth_with_google_github.databinding.ActivityAuthGithubBinding

class AuthGithubActivity : AppCompatActivity() {
    private lateinit var auth : FirebaseAuth
    private lateinit var binding : ActivityAuthGithubBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthGithubBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLoginGithub.setOnClickListener {
            val email = binding.etEmail.text.toString()
            if (email.isEmpty()) {
                Toast.makeText(this, "harap isi email", Toast.LENGTH_SHORT).show()
            } else {
                val provider = OAuthProvider.newBuilder("github.com")
                provider.addCustomParameter("login", email)

                val scopes: ArrayList<String?> = object : ArrayList<String?>() {
                    init {
                        add("user:email")
                    }
                }
                provider.scopes = scopes
                val pendingResultTask: Task<AuthResult>? = auth.getPendingAuthResult()
                if (pendingResultTask != null) {
                    pendingResultTask
                        .addOnSuccessListener(
                            OnSuccessListener<AuthResult> {

                            })
                        .addOnFailureListener(
                            OnFailureListener {
                                Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                            }
                        )
                } else {
                    auth
                        .startActivityForSignInWithProvider( /* activity */ this, provider.build())
                        .addOnSuccessListener(
                            OnSuccessListener<AuthResult> {
                                openNextActivity()
                            }
                        )
                        .addOnFailureListener(
                            OnFailureListener {
                                Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                            }
                        )
                }
            }
        }
    }

    private fun openNextActivity() {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("email", binding.etEmail.text)
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
        startActivity(intent)
        finish()
    }
}