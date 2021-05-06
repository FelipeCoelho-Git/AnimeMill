package com.felipe.animemill

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.felipe.animemill.databinding.ActivityLoginScreenFinalBinding
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException

class LoginScreenFinal : AppCompatActivity() {

    private lateinit var binding: ActivityLoginScreenFinalBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginScreenFinalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()

        VerifyLoginUser()

        val bt_register = binding.registerScreen
        bt_register.setOnClickListener {
            val intent = Intent(this, RegisterScreen::class.java)
            startActivity(intent)

        }

        val bt_enter = binding.btEnter
        bt_enter.setOnClickListener {

            val LoginEmail = binding.editEmial.text.toString()
            val LoginPassword = binding.editPassword.text.toString()
            val LoginLogError = binding.logError

            if (LoginEmail.isEmpty() || LoginPassword.isEmpty()) {

                LoginLogError.setText("Preencha todos os campos")

            } else {

                AuthUser()
            }
        }
    }

    private fun AuthUser(){

        val LoginEmail = binding.editEmial.text.toString()
        val LoginPassword = binding.editPassword.text.toString()
        val LoginLogError = binding.logError

        FirebaseAuth.getInstance().signInWithEmailAndPassword(LoginEmail, LoginPassword).addOnCompleteListener {

            if(it.isSuccessful ){
                Toast.makeText(this, "Login Efetuado com sucesso!", Toast.LENGTH_LONG).show()
                ToAnimeListScreen()
                LoginLogError.setText("")

            }


        }.addOnFailureListener {

            val erro = it

            when {

                erro is FirebaseAuthInvalidCredentialsException -> LoginLogError.setText("Email ou senha incorretos.")
                erro is FirebaseNetworkException -> LoginLogError.setText("Sem conexão com a internet.")
                else -> LoginLogError.setText("Erro ao logar usuário.")

            }
        }
    }

    private fun ToAnimeListScreen (){
        val intent = Intent(this, AnimeListScreen::class.java)
        startActivity(intent)
        finish()
    }

    private fun VerifyLoginUser () {

        val LogedUser =  FirebaseAuth.getInstance().currentUser

        if (LogedUser != null){
            ToAnimeListScreen()
        }
    }
}