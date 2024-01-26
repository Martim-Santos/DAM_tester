package pt.ipt.dam2023.dam_tester.model

import com.google.gson.annotations.SerializedName

data class Utilizador(
    @SerializedName("nome") val nome: String,
    @SerializedName("pass") val pass: String,
    @SerializedName("mail") val mail: String,
    @SerializedName("id") val id: Int
)
