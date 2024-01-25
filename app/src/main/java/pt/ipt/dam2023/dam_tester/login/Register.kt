package pt.ipt.dam2023.dam_tester.login

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import okhttp3.Credentials
import pt.ipt.dam2023.dam_tester.R
import pt.ipt.dam2023.dam_tester.service.RetrofitInitializer
import pt.ipt.dam2023.dam_tester.service.UtilizadorService
import java.security.Provider.Service

class Register: AppCompatActivity() {

    var Nome: EditText = findViewById(R.id.RegisterNome)
    var Email: EditText = findViewById(R.id.RegisterEmail)
    var Password: EditText = findViewById(R.id.RegisterEmail)
    var ConfirmPassword: EditText = findViewById(R.id.RepeatRegisterPass)

    override fun onCreate(saveInstanceStae : Bundle?){
        super.onCreate(saveInstanceStae)
        setContentView(R.layout.registar)

        var btRegister: Button = findViewById(R.id.btRegister)
        btRegister.setOnClickListener { Registar() }

        var btLog: Button = findViewById(R.id.btLog)
        btLog.setOnClickListener { passarParaAutenticacao() }
    }

    // Validação de email retirado da internet
    //https://developermemos.com/posts/validating-email-addresses-kotlin
    val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\$"

    fun isValidEmail(email: String): Boolean {
        return email.matches(emailRegex.toRegex())
    }

    fun Registar(){
        verificar(Nome.text.toString(), Email.text.toString(), Password.text.toString(), ConfirmPassword.text.toString())
    }

    fun verificar(Nome: String, Email: String, Password: String, ConfirmPassword: String){
        if (Password == ConfirmPassword && isValidEmail(Email).equals(true)){
            RetrofitInitializer().utilizadorService().addUser(Nome, Password, Email)
            RetrofitInitializer().utilizadorService().Authentication( Credentials.basic(
                this.Email.toString(),
                this.Password.toString()
            ))
        }
    }

     fun passarParaAutenticacao(){
         setContentView(R.layout.login)
     }

}
