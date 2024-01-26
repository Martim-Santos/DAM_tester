package pt.ipt.dam2023.dam_tester.login

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import pt.ipt.dam2023.dam_tester.R
import pt.ipt.dam2023.dam_tester.fragmentos.Galeria
import pt.ipt.dam2023.dam_tester.model.Fotos
import pt.ipt.dam2023.dam_tester.model.Utilizador
import pt.ipt.dam2023.dam_tester.model.Utilizadores
import pt.ipt.dam2023.dam_tester.service.RetrofitInitializer
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class Login : AppCompatActivity() {

    var Email: EditText = findViewById(R.id.loginEmail)
    var Password: EditText = findViewById(R.id.loginPassword)

    override fun onCreate(saveInstanceStae : Bundle?){
        super.onCreate(saveInstanceStae)
        setContentView(R.layout.login)

        var btLogin: Button = findViewById(R.id.btLogin)
        btLogin.setOnClickListener { enterLogin() }

        var btReg: Button = findViewById(R.id.btReg)
        btReg.setOnClickListener { passarParaRegistar() }

    }

    fun checkEmailExistenceForLogin(emailToCheck: String, userList: List<Utilizador>): Boolean {
        return userList.any { it.mail == emailToCheck }
    }

    private fun enterLogin() {
        verificarConta(Email, Password) {
            setContentView(R.layout.activity_main)
        }


    }

    fun verificarConta(mail: EditText, pass: EditText, function: () -> Unit){
        var call = RetrofitInitializer().utilizadorService().getmail(mail)
        call.enqueue(object : Callback<Utilizadores> {
            override fun onResponse(call: Call<Utilizadores>, response: Response<Utilizadores>) {
                if (response.isSuccessful) {
                    val post = response.body()
                    // Handle the retrieved post data
                } else {
                    // Handle error
                }
            }

            override fun onFailure(call: Call<Utilizadores>, t: Throwable) {
                Log.e("Erro","Erro ao dar autenticação")
            }
        })
    }

    fun passarParaRegistar(){
        setContentView(R.layout.registar)
    }

}