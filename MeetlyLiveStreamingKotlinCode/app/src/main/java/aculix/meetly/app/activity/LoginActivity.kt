package com.adroit.letslinkup.activity

import `in`.co.adroit.kotlinretrofitcode.api.RetrofitClient
import `in`.co.adroit.kotlinretrofitcode.models.LoginResponse
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import com.adroit.letslinkup.R
/*
import com.android.volley.AuthFailureError
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley*/
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_registration.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoginActivity : AppCompatActivity() {

    companion object {
        fun startActivity(context: Context) {
            val intent = Intent(context, LoginActivity::class.java)
            context.startActivity(intent)
        }
    }

   // private var requestQueue: RequestQueue? = null
    val TAG = "Handy Opinion Tutorials"

    // var volleyRequestQueue: RequestQueue? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        edt_logindata.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (edt_logindata.getText().toString().length < 1){
                    edt_logindata.setError("please enter required fields")
                }
            }
            override fun afterTextChanged(s: Editable?) {
            }
        })
    }

    fun Login(view: View) {
        if (edt_logindata.getText().toString().length < 1){
            edt_logindata.setError("Please enter number or email id")
            return
        }
        if (edt_password.getText().toString().length < 1){
            edt_password.setError("Please enter password")
            return
        }
        else{
            login.isEnabled = true

            val email = "g@gmail.com"
            val password = "gG@1"

            //if everything is fine
            RetrofitClient.instance.userLogin(email, password)
                .enqueue(object: Callback<LoginResponse> {
                    override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                        Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
                    }

                    override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {

                        login.isEnabled = true
                        Toast.makeText(applicationContext, response.body()?.message, Toast.LENGTH_LONG).show()

                        //shared preference
                        val sharedPreference =  getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)
                        var editor = sharedPreference.edit()
                        editor.putString("islogged_in","true")
                        editor.commit()

                        MainActivity.startActivity(this@LoginActivity)
                    }
                })

      /*      //if everything is fine
            val stringRequest = object : StringRequest(Request.Method.POST, url,
                    Response.Listener { response ->
                        //  progressBar.visibility = View.GONE

                        try {
                            //converting response to json object
                            val obj = JSONObject(response)

                            //if no error in response
                            Toast.makeText(applicationContext, obj.getString("message"), Toast.LENGTH_SHORT).show()

                            val message = obj.getString("message")
                            val data = obj.getJSONObject("data")
                            val user = data.getJSONObject("user")

                            for (i in 0 until user.length()) {
                                //    val employee = user.getJSONObject(i)
                                val firstName = user.getString("uname")
                                val fathersName = user.getString("fathersName")
                                val dob = user.getString("dob")

                                val intent = Intent(this,RegistrationActivity::class.java)
                                startActivity(intent)
                                //  textView.append("$firstName, $age, $mail\n\n")
                            }
                            finish()
                            startActivity(Intent(applicationContext, MainActivity::class.java))

                        } catch (e: JSONException) {
                            e.printStackTrace()
                        }
                    },
                    Response.ErrorListener { error -> Toast.makeText(applicationContext, error.message, Toast.LENGTH_SHORT).show() }) {
                @Throws(AuthFailureError::class)
                override fun getParams(): Map<String, String> {
                    val params = HashMap<String, String>()
                    //params["mobile"] = edt_logindata.getText().toString();
                    params["mobile"] = "9156602107"
                   // params["countrycode"] = "91"
                    return params
                }
            }

            VolleySingleton.getInstance(this).addToRequestQueue(stringRequest)*/
        }
    }

    fun onRegistrationClick(view: View) {
        val intent = Intent(this, RegistrationActivity::class.java)
        startActivity(intent)
    }

    fun OnforgetPasswordClick(view: View) {
        val intent = Intent(this@LoginActivity, ChangePasswordActivity::class.java)
        startActivity(intent)
    }
}
