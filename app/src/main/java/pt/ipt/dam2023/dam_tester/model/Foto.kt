package pt.ipt.dam2023.dam_tester.model

import com.google.gson.annotations.SerializedName

data class Foto (
    @SerializedName("nome") val nome: String,
    @SerializedName("foto") val foto: String,
    @SerializedName("data") val data: String,
    @SerializedName("id") val id: Int
)