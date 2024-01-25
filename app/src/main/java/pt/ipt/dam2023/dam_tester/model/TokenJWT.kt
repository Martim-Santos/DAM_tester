package pt.ipt.dam2023.dam_tester.model

import com.google.gson.annotations.SerializedName

data class TokenJWT (
    @SerializedName("token") val token: String?
)