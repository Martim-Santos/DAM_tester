package pt.ipt.dam2023.dam_tester.model

import com.google.gson.annotations.SerializedName

data class APIResultUser(
    @SerializedName("Nome") val Nome: String?,
    @SerializedName("pass") val pass: String?,
    @SerializedName("mail") val mail: String?
)
