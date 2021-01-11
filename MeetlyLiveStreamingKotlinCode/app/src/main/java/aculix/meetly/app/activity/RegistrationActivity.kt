package aculix.meetly.app.activity

/*
import androidx.core.widget.addTextChangedListener
import com.android.volley.AuthFailureError
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest*/

import `in`.co.adroit.kotlinretrofitcode.api.RetrofitClient
import `in`.co.adroit.kotlinretrofitcode.models.RegistrationResponse
import aculix.meetly.app.R
import aculix.meetly.app.utils.DataStore
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.Gravity
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_registration.*
import kotlinx.android.synthetic.main.activity_test.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*
import java.util.regex.Matcher
import java.util.regex.Pattern


class RegistrationActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
    var languages = arrayOf("Select Gender", "Female", "Male", "Other")
    val NEW_SPINNER_ID = 1

    private val pattern = Pattern.compile(emailPattern)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        btn_submit.isEnabled = true
        DataStore.gender = "null"

        //select gender spinner code
        var aa = ArrayAdapter(this, android.R.layout.simple_spinner_item, languages)
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        with(Spinner)
        {
            adapter = aa
            setSelection(0, false)
            onItemSelectedListener = this@RegistrationActivity
            //   prompt = "Select gender"
            gravity = Gravity.CENTER

        }

        val spinner = Spinner(this)
        spinner.id = NEW_SPINNER_ID

        val ll = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )

        ll.setMargins(10, 20, 10, 10)
        linearLayout.addView(spinner)


        //username click listner
        et_user_name.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (et_user_name.getText().toString().length < 3) {
                    et_user_name.setError("least 3 character required")
                }
            }

            override fun afterTextChanged(s: Editable?) {
            }
        })


        /*if (et_email.editableText.toString().trim().matches(emailPattern)
        ) {
        } else {
            et_email.setError("enter valid email")
            return
        }*/

         //email click listner
        et_email.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
               if(isValid(et_email.editableText.toString()))
                   else{
                       et_email.setError("Invalid email")
                   }

            /*  val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\\\.+[a-z]+"

                if (android.util.Patterns.EMAIL_ADDRESS.matcher(et_email.text.toString()).matches())
                else {
                    et_email.setError("Invalid Email")
                }*/
            }

            override fun afterTextChanged(s: Editable?) {
            }
        })

        //mobile no validation
        et_mobile.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (et_mobile.getText().toString().length < 10) {
                    et_mobile.setError("Please enter correct mobile no")
                }
            }

            override fun afterTextChanged(s: Editable?) {
            }
        })


        //make strong password
        edt_pwd.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (edt_pwd.getText().toString().isEmpty()) {
                    edt_pwd.setError("please enter strong password")
                } else {
                    if (isValidPassword(edt_pwd.getText().toString())) {
                        /* Toast.makeText(this,
                             "Valid", Toast.LENGTH_SHORT).show()*/
                    } else {
                        edt_pwd.setError("please enter strong password")
                        //    Toast.makeText(this@RegistrationActivity,"please enter strong password", Toast.LENGTH_LONG).show();
                    }
                }
            }

            //mobile no click event
            override fun afterTextChanged(s: Editable?) {
            }
        })
    }

    fun isValidPassword(password: String?): Boolean {
        val PASSWORD_REGEX_PATTERN =
            "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[\\\\\\/%§\"&“|`´}{°><:.;#')(@_\$\"!?*=^-]).{8,}\$"
        // val PASSWORD_REGEX_PATTERN = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
        val pattern: Pattern =
            Pattern.compile(PASSWORD_REGEX_PATTERN)
        val matcher: Matcher = pattern.matcher(password)
        return matcher.matches()
    }

    //submit button click
    fun onSubmitClick(view: View) {
        if (et_user_name.editableText.toString().isEmpty()) {
            et_user_name.setError("Please enter username")
            return
        }
        if (et_email.editableText.toString().isEmpty()) {
            et_email.setError("Please enter email")
            return
        }
        if (edt_pwd.editableText.toString().isEmpty()) {
            edt_pwd.setError("Please enter password")
            return
        }
        if (et_mobile.getText().toString().length < 10) {
            et_mobile.setError("Please enter correct mobile no")
            return
        }
        if (edt_pwd.getText().toString() != edt_confirm_pwd.getText().toString()) {
            Toast.makeText(
                this@RegistrationActivity,
                "Password does not match", Toast.LENGTH_SHORT
            ).show()
            return
        }

        val spinn = DataStore.gender;
        if (spinn.equals("null")){
            Toast.makeText(getApplicationContext(),"Please select gender",
                Toast.LENGTH_LONG).show();
            return
        }

        if (edt_confirm_pwd.editableText.toString().isEmpty()) {
            edt_confirm_pwd.setError("Please enter password")
            return
        } else {
            btn_submit.isEnabled = false
            DataStore.user_name = et_user_name.editableText.toString();
            DataStore.EmailId = et_email.editableText.toString();
            DataStore.MobileNo = et_mobile.editableText.toString();
            DataStore.password = edt_confirm_pwd.editableText.toString();
            btn_submit.isEnabled = false

            val name = "g@gmail.com"
            val mobile = "g@gmail.com"
            val email = "g@gmail.com"
            val password = "Gunjan"
            val gender = "Female"

            //if everything is fine
            RetrofitClient.instance.userRegistration(name, mobile, email, password, gender)
                .enqueue(object : Callback<RegistrationResponse> {
                    override fun onFailure(call: Call<RegistrationResponse>, t: Throwable) {
                        Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
                    }

                    override fun onResponse(
                        call: Call<RegistrationResponse>,
                        response: Response<RegistrationResponse>
                    ) {
                        btn_submit.isEnabled = true
                        Toast.makeText(
                            applicationContext,
                            response.body()?.message,
                            Toast.LENGTH_LONG
                        ).show()
                        // Toast.makeText(applicationContext, response.body()?.otp, Toast.LENGTH_LONG).show()
                        btn_submit.isEnabled = true
                        DataStore.verifyMobile = "RegistrationVerify"
                        val intent = Intent(
                            this@RegistrationActivity,
                            VerifyMobileActivity::class.java
                        )
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

    override fun onNothingSelected(parent: AdapterView<*>?) {
        showToast(message = "Nothing selected")
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        showToast(message = "${languages[position]}")
        DataStore.gender = "${languages[position]}"

    }

    private fun showToast(context: Context = applicationContext, message: String,duration: Int = Toast.LENGTH_LONG) {
        Toast.makeText(context, message, duration).show()
    }

    fun isValid(email: String?): Boolean {
        val matcher = pattern.matcher(email)
        return matcher.matches()
    }
}