package com.example.pagabus2v

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ActionProvider
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.LinearLayout
import com.google.firebase.auth.FirebaseAuth
import kotlin.properties.Delegates

class LoginRegisterActivity : AppCompatActivity() {

    companion object{
        lateinit var userEmail: String
        lateinit var provedorDeSesion: String
    }
    private var email by Delegates.notNull<String>()
    private var contraseña by Delegates.notNull<String>()
    private lateinit var etEmail: EditText
    private lateinit var etContraseña: EditText
    private lateinit var lyTerminos: LinearLayout

    private lateinit var mAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_register)

        lyTerminos = findViewById(R.id.lyTerminos)
        lyTerminos.visibility= View.INVISIBLE

        etEmail = findViewById(R.id.editCorreo)
        etContraseña = findViewById(R.id.editContraseña)
        mAuth = FirebaseAuth.getInstance()
    }
    fun login(view: View){
        loginUser()
    }
    private fun loginUser(){
        email= etEmail.text.toString()
        contraseña = etContraseña.text.toString()

        mAuth.signInWithEmailAndPassword(email, contraseña)
            .addOnCompleteListener(this){task->
                if(task.isSuccessful) irInicio(email, "email")
                else{
                    if(lyTerminos.visibility == View.INVISIBLE) lyTerminos.visibility= View.VISIBLE
                    else{
                       var cbAcept= findViewById<CheckBox>(R.id.cbAcepto)
                        if (cbAcept.isChecked) register()
                    }
                }
            }



    }
    private fun irInicio(email: String, provider: String){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}