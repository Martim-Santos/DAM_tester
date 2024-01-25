package pt.ipt.dam2023.dam_tester.model

import com.google.gson.annotations.SerializedName
import java.util.Date

data class APIResultFoto(
    @SerializedName("foto") val codigo: String?,
    @SerializedName("nome") val nome: String?,
    @SerializedName("data") val date: Date
)