package pt.ipt.dam2023.dam_tester.login

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import pt.ipt.dam2023.dam_tester.R


class Login : AppCompatActivity() {

    override fun onCreate(saveInstanceStae : Bundle?){
        super.onCreate(saveInstanceStae)
        setContentView(R.layout.login)

        var btLogin: Button = findViewById(R.id.btLogin)
        btLogin.setOnClickListener { enterLogin() }

        var btReg: Button = findViewById(R.id.btReg)
        btReg.setOnClickListener { passarParaRegistar() }

        var Username: EditText = findViewById(R.id.)

    }

    fun enterLogin(){

    }

    fun passarParaRegistar(){

    }

}