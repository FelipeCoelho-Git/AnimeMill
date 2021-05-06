package com.felipe.animemill

import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.felipe.animemill.databinding.ActivityLoginScreenFinalBinding
import com.felipe.animemill.databinding.ActivityRegisterScreenBinding
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException

class RegisterScreen : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()

        val bt_register = binding.btRegister

        bt_register.setOnClickListener {

            val email = binding.editEmail.text.toString()
            val password = binding.editPassword.text.toString()

            val logError = binding.logError

            if (email.isEmpty() || password.isEmpty()){

                logError.setText("Preencha todos os campos.")

            }else {
                RegisterUser()
            }
        }
    }

    private fun RegisterUser (){

        val email = binding.editEmail.text.toString()
        val password = binding.editPassword.text.toString()
        val logError = binding.logError

        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password).addOnCompleteListener {

            if (it.isSuccessful){
                Toast.makeText(this, "Usuário cadastrado com sucesso!", Toast.LENGTH_LONG).show()
                binding.editEmail.setText("")
                binding.editPassword.setText("")
                binding.logError.setText("")
            }
        }.addOnFailureListener {

            val error = it

            when{

                error is FirebaseAuthWeakPasswordException -> logError.setText("A senha deve conter no mínimo 6 caracteres")
                error is FirebaseAuthUserCollisionException -> logError.setText("Este email ja esta cadastrado")
                error is FirebaseNetworkException -> logError.setText("Sem conexão com a internet")
                else -> logError.setText("Erro ao criar usuário")

            }
        }
    }
}