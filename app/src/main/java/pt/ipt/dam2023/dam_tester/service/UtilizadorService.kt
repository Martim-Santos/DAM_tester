package pt.ipt.dam2023.dam_tester.service

import android.widget.EditText
import pt.ipt.dam2023.dam_tester.model.APIResultUser
import pt.ipt.dam2023.dam_tester.model.Utilizadores
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface UtilizadorService {

    @GET("users")
    fun getUser(): Call<Utilizadores>

    @GET("users/{mail}")
    fun getmail(@Path("mail") mail: EditText): Call<Utilizadores>

    @GET("users/{pass}")
    fun getpass(@Path("pass") pass: EditText): Call<Utilizadores>

    @GET("users/{nome}")
    fun getname(@Path("nome") nome: String): Call<Utilizadores>

    @POST("users")
    fun addUser(@Field("Nome") Nome: String?,
                @Field("pass") pass: String?,
                @Field("mail") mail: String?
    ): Call<APIResultUser>

}