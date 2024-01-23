package pt.ipt.dam2023.dam_tester.service

import pt.ipt.dam2023.dam_tester.model.APIResult
import pt.ipt.dam2023.dam_tester.model.Foto
import pt.ipt.dam2023.dam_tester.model.Fotos
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import java.util.Date

interface ImageService {

    @GET("fotos")
    fun list(): Call<Fotos>

    @GET("fotos")
    fun listBA(@Header("Authorization") authorization: String): Call<Fotos>

    @FormUrlEncoded
    @POST("fotos")
    fun addFoto(@Field("foto") codigo: String?,
                @Field("nome") nome: String?,
                @Field("data") date: Date ): Call<APIResult>
}