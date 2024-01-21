package pt.ipt.dam2023.dam_tester.model

import com.google.gson.annotations.SerializedName

data class Utilizadores (
    @SerializedName("users") val utilizador: List<Utilizador>
)