package `in`.co.adroit.kotlinretrofitcode.api

import `in`.co.adroit.kotlinretrofitcode.models.*
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface Api {

    @FormUrlEncoded
    @POST("createuser")
    fun createUser(
            @Field("email") email:String,
            @Field("name") name:String,
            @Field("password") password:String,
            @Field("school") school:String
    ):Call<DefaultResponse>

    @FormUrlEncoded
    @POST("api/login")
    fun userLogin(
            @Field("email") email:String,
            @Field("password") password: String
    ):Call<LoginResponse>

    @FormUrlEncoded
    @POST("api/register?name=gunjan&mobile=9156602107&email=g@gmail.com&password=Gg@1/api/register")
    fun userRegistration(
        @Field("name") name:String,
        @Field("mobile") mobile:String,
        @Field("email") email:String,
        @Field("password") password: String,
        @Field("gender") gender: String
    ):Call<RegistrationResponse>

    @FormUrlEncoded
    @POST("api/verifyemail?email=g@gmail.com")
    fun verifyEmail(
            @Field("email") emailid:String
    ):Call<VerifyEmailResponse>

    @FormUrlEncoded
    @POST("api/verifymobile?mobile=9156602107")
    fun verifyMobile(
            @Field("mobile") mobileno:String
    ):Call<VerifyMobileResponse>

    @FormUrlEncoded
    @POST("api/changepwd?password=g!2")
    fun changepassword(
            @Field("password") password:String
    ):Call<ChangePassword>

    @FormUrlEncoded
    @POST("api/profile?name=gunjan&email=g@gmail.com&mobile=9156602107&gender=Female&password=1234")
    fun updateprofile(
            @Field("name") name:String,
            @Field("email") email:String,
            @Field("mobile") mobile:String,
            @Field("gender") gender:String,
            @Field("password") password:String
    ):Call<ProfileResponse>

}