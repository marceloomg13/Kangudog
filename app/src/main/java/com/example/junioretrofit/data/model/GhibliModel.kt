package com.example.junioretrofit.data.model

import com.google.gson.annotations.SerializedName

data class GhibliModel(
    @SerializedName("id")val id:String,
    @SerializedName("name")val name:String,
    @SerializedName("gender")val gender:String,
    @SerializedName("age")val age:String,
    @SerializedName("eye_color")val eye_color:String,
    @SerializedName("hair_color")val hair_color:String)
