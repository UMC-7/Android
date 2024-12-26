package com.example.androidfloclone

import com.google.gson.annotations.SerializedName

data class AuthResponse (
    @SerializedName(value = "isSuccess") val isSuccess:Boolean,
    @SerializedName(value = "code") val code:String,
    @SerializedName(value = "message") val message:String,
    @SerializedName(value = "result") val result: Result?
)

data class Result(
    @SerializedName(value = "userIdx") var memberId : Int,
    @SerializedName(value = "jwt") var accessToken : String
)