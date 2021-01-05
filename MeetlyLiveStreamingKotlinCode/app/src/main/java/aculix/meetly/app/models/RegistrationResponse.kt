package `in`.co.adroit.kotlinretrofitcode.models

data class RegistrationResponse(val error: Boolean, val message:String,  val otp:String, val user: User)