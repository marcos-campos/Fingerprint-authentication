package com.debug.authentication.ui.login

import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Bundle
import android.provider.CalendarContract
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.debug.authentication.HomeActivity
import com.debug.authentication.R
import java.util.*
import java.util.concurrent.Executor


class LoginActivity : AppCompatActivity() {

    private lateinit var executor: Executor
    private lateinit var biometricPrompt: androidx.biometric.BiometricPrompt
    private lateinit var promptInfo: androidx.biometric.BiometricPrompt.PromptInfo
    private lateinit var biometricCallback: androidx.biometric.BiometricPrompt.AuthenticationCallback

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)

        val fingerPrint = findViewById<ImageView>(R.id.login_fingerprint)

        executor = ContextCompat.getMainExecutor(this)
        biometricPrompt = androidx.biometric.BiometricPrompt(this, executor, object: androidx.biometric.BiometricPrompt.AuthenticationCallback(){
            override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
                super.onAuthenticationError(errorCode, errString)
                Toast.makeText(this@LoginActivity, "Erro de autenticação: $errString", Toast.LENGTH_LONG).show()
            }

            override fun onAuthenticationSucceeded(result: androidx.biometric.BiometricPrompt.AuthenticationResult) {
                super.onAuthenticationSucceeded(result)
                Toast.makeText(this@LoginActivity, "Autenticação concluída com sucesso", Toast.LENGTH_LONG).show()
                val intent = Intent(this@LoginActivity, HomeActivity::class.java)
                startActivity(intent)
            }

            override fun onAuthenticationFailed() {
                super.onAuthenticationFailed()
                Toast.makeText(this@LoginActivity, "Falha na autenticação", Toast.LENGTH_LONG).show()
            }
        })

        promptInfo = androidx.biometric.BiometricPrompt.PromptInfo.Builder()
            .setDescription("Posicione o dedo no leitor biométrico do seu celular")
            .setTitle("Acesso com a digital")
            .setNegativeButtonText("Cancelar")
            .build()


        fingerPrint.setOnClickListener {
//            biometricPrompt.authenticate(promptInfo)
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)

        }

    }
}