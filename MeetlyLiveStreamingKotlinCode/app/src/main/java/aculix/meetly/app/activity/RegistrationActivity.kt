package aculix.meetly.app.activity

import `in`.co.adroit.kotlinretrofitcode.api.RetrofitClient
import `in`.co.adroit.kotlinretrofitcode.models.RegistrationResponse
import aculix.meetly.app.R
import aculix.meetly.app.utils.DataStore
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
/*
import androidx.core.widget.addTextChangedListener
import com.android.volley.AuthFailureError
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest*/

import kotlinx.android.synthetic.main.activity_registration.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*
import java.util.regex.Matcher
import java.util.regex.Pattern

class RegistrationActivity : AppCompatActivity() {
    private val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        btn_submit.isEnabled = true


        et_user_name.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (et_user_name.getText().toString().length < 3){
                    et_user_name.setError("least 3 character required")
                }
            }
            override fun afterTextChanged(s: Editable?) {
            }
        })


        et_email.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (android.util.Patterns.EMAIL_ADDRESS.matcher(et_email.text.toString()).matches())
                    else{
                    et_email.setError("Invalid Email")
                    }
            }

            override fun afterTextChanged(s: Editable?) {
            }
        })

        //make strong password
        edt_pwd.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (edt_pwd.getText().toString().isEmpty())
                {
                    edt_pwd.setError("please enter strong password")
                }
                else {
                    if (isValidPassword(edt_pwd.getText().toString())) {
                        /* Toast.makeText(this,
                             "Valid", Toast.LENGTH_SHORT).show()*/
                    } else {
                        edt_pwd.setError("please enter strong password")
                //    Toast.makeText(this@RegistrationActivity,"please enter strong password", Toast.LENGTH_LONG).show();
                    }
                }
            }
            override fun afterTextChanged(s: Editable?) {
            }
        })


        // access the spinner
        // access the items of the list
        val gender = resources.getStringArray(R.array.gender)

        val spinner = findViewById<Spinner>(R.id.spinner)
        if (spinner != null) {
            val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item, gender
            )
            spinner.adapter = adapter

            spinner.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View, position: Int, id: Long
                ) {
                    val selected_gender = gender[position]
                  //  Toast.makeText(this@RegistrationActivity, getString(R.string.selected_item) + " " +"" + languages[position], Toast.LENGTH_SHORT).show()
                   // Toast.makeText(this@RegistrationActivity, selected_gender, Toast.LENGTH_SHORT).show()
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }
        }
    }
    fun isValidPassword(password: String?): Boolean {
           val PASSWORD_REGEX_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[\\\\\\/%§\"&“|`´}{°><:.;#')(@_\$\"!?*=^-]).{8,}\$"
       // val PASSWORD_REGEX_PATTERN = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
        val pattern: Pattern =
            Pattern.compile(PASSWORD_REGEX_PATTERN)
        val matcher: Matcher = pattern.matcher(password)
        return matcher.matches()
    }

    //submit button click
    fun onSubmitClick(view: View) {
        if(et_user_name.editableText.toString().isEmpty()){
            et_user_name.setError("Please enter username")
            return
        }
        if(et_email.editableText.toString().isEmpty()) {
            et_email.setError("Please enter email")
            return
        }
        if(edt_pwd.editableText.toString().isEmpty()){
            edt_pwd.setError("Please enter password")
            return
        }
        if  (edt_pwd.getText().toString() != edt_confirm_pwd.getText().toString()) {
            Toast.makeText(
                    this@RegistrationActivity,
                    "Password does not match", Toast.LENGTH_SHORT
            ).show()
            return
        }

        if(edt_confirm_pwd.editableText.toString().isEmpty()){
            edt_confirm_pwd.setError("Please enter password")
            return
        }
        else{
            DataStore.EmailId = et_email.editableText.toString();
            DataStore.MobileNo = et_mobile.editableText.toString();
            btn_submit.isEnabled = false

            val name = "g@gmail.com"
            val mobile = "g@gmail.com"
            val email = "g@gmail.com"
            val password = "Gunjan"
            val gender = "Female"

            //if everything is fine
            RetrofitClient.instance.userRegistration(name, mobile, email, password, gender)
                    .enqueue(object: Callback<RegistrationResponse> {
                        override fun onFailure(call: Call<RegistrationResponse>, t: Throwable) {
                            Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
                        }

                        override fun onResponse(call: Call<RegistrationResponse>, response: Response<RegistrationResponse>) {

                            Toast.makeText(applicationContext, response.body()?.message, Toast.LENGTH_LONG).show()
                           // Toast.makeText(applicationContext, response.body()?.otp, Toast.LENGTH_LONG).show()
                            btn_submit.isEnabled = true
                            DataStore.verifyMobile = "RegistrationVerify"
                            val intent = Intent(this@RegistrationActivity,VerifyMobileActivity::class.java)
                            startActivity(intent)
                        }
                    })
        }



    /*    //when everything is good
        val stringRequest = object : StringRequest(Request.Method.POST, signup_url,
                Response.Listener { response ->
                    //progressBar.visibility = View.GONE

                    try {
                        //converting response to json object
                        val obj = JSONObject(response)
                        //if no error in response

                            Toast.makeText(applicationContext, obj.getString("message"), Toast.LENGTH_SHORT).show()

                            //getting the user from the response
                            val message = obj.getString("message")

                           *//* //creating a new user object
                            val user = User(
                                    userJson.getInt("id"),
                                    userJson.getString("username"),
                                    userJson.getString("email"),
                                    userJson.getString("gender")
                            )
*//*
                            //storing the user in shared preferences
                            //SharedPrefManager.getInstance(applicationContext).userLogin(user)

                            //starting the MainActivity activity
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
                params["name"] = "Gunjan"
                params["mobile"] = "9156602107"
                params["email"] = "g@gmail.com"
                params["password"] = "Gg@1"
                return params
            }
        }

        VolleySingleton.getInstance(this).addToRequestQueue(stringRequest)*/
    }

  /*  fun onVerifyEmail(view: View) {
        val email = "g@gmail.com"
        //if everything is fine
        RetrofitClient.instance.verifyEmail(email)
                .enqueue(object: Callback<VerifyEmailResponse> {
                    override fun onFailure(call: Call<VerifyEmailResponse>, t: Throwable) {
                        Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
                    }

                    override fun onResponse(call: Call<VerifyEmailResponse>, response: Response<VerifyEmailResponse>) {

                        Toast.makeText(applicationContext, response.body()?.message, Toast.LENGTH_LONG).show()

                        val intent = Intent(this@RegistrationActivity,AuthenticationActivity::class.java)
                        //val intent = Intent(this,RegistrationActivity::class.java)
                        startActivity(intent)

                        *//*  if(!response.body()?.error!!){

                             // SharedPrefManager.getInstance(applicationContext).saveUser(response.body()?.user!!)

                              val intent = Intent(applicationContext, ProfileActivity::class.java)
                              intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK

                              startActivity(intent)
                          }else{
                              Toast.makeText(applicationContext, response.body()?.message, Toast.LENGTH_LONG).show()
                          }*//*

                    }
                })
    }*/

   /* fun onVerifyMobile(view: View) {
        val mobile = "91656603108"
        //if everything is fine
        RetrofitClient.instance.verifyMobile(mobile)
                .enqueue(object: Callback<VerifyMobileResponse> {
                    override fun onFailure(call: Call<VerifyMobileResponse>, t: Throwable) {
                        Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
                    }

                    override fun onResponse(call: Call<VerifyMobileResponse>, response: Response<VerifyMobileResponse>) {

                        Toast.makeText(applicationContext, response.body()?.message, Toast.LENGTH_LONG).show()

                        val intent = Intent(this@RegistrationActivity,AuthenticationActivity::class.java)
                        //val intent = Intent(this,RegistrationActivity::class.java)
                        startActivity(intent)
                    }
                })
    }*/
}
