package com.example.pagabus2v


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.ActionProvider
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import java.text.SimpleDateFormat
import java.util.Date
import kotlin.properties.Delegates

class LoginRegisterActivity : AppCompatActivity() {

    companion object {
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
        lyTerminos.visibility = View.INVISIBLE

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

        userEmail = email
        provedorDeSesion = provider

        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)

    }
    private fun register(){

        email= etEmail.text.toString()
        contraseña = etContraseña.text.toString()

        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, contraseña)
            .addOnCompleteListener{
                if (it.isSuccessful){

                    var fechaRegistro = SimpleDateFormat ("dd/mm/yyyy").format(Date())
                    var dbRegister = FirebaseFirestore.getInstance()
                    dbRegister.collection("users").document(email).set(hashMapOf(
                        "Usuarios" to userEmail,
                        "FechaDeRegistro" to fechaRegistro
                    ))

                    irInicio(email, "Correo")
                }
                else Toast.makeText(this, "Error, algo salio mal", Toast.LENGTH_SHORT).show()
            }
    }
        fun irTerminos(v: View){
        val intent = Intent(this,TerminosActivity::class.java)
        startActivity(intent)
    }
    fun olvidaContra(v: View){
        resetContraseña()
    }
    private fun resetContraseña(){
        var e = etEmail.text.toString()
        if(!TextUtils.isEmpty(e)){
            mAuth.sendPasswordResetEmail(e)
                .addOnCompleteListener() { task ->
                    if(task.isSuccessful) Toast.makeText(this, "Correo Enviado a $e", Toast.LENGTH_SHORT).show()
                    else Toast.makeText(this,"No se encontro el usuario con este correo", Toast.LENGTH_SHORT).show()
                }
        }
        else Toast.makeText(this,"Introduzca un Correo", Toast.LENGTH_SHORT).show()
    }
    }

