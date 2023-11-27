package com.example.geez.model

data class User(val email:String, val name:String, val token:String)

data class UserRespons(val data:User)

data class Register(val email:String,val name:String)
data class RegisterResponse(val data:Register)
