package pt.ipt.dam2023.dam_tester.service

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import pt.ipt.dam2023.dam_tester.service.ImageService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInitializer {

    private val gson: Gson = GsonBuilder().setLenient().create()

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.sheety.co/44999724e36c8f60a4a0444b7f325fbd/project/")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    fun imageService() = retrofit.create(ImageService::class.java)
    fun utilizadorService() = retrofit.create(UtilizadorService::class.java)
}