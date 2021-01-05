package aculix.meetly.app.activity

import `in`.co.adroit.kotlinretrofitcode.api.RetrofitClient
import `in`.co.adroit.kotlinretrofitcode.models.ProfileResponse
import aculix.meetly.app.R
import aculix.meetly.app.utils.DataStore
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_profile.*
import kotlinx.android.synthetic.main.activity_registration.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        edt_username.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (edt_username.getText().toString().length < 3) {
                    edt_username.setError("least 3 character required")
                }
            }

            override fun afterTextChanged(s: Editable?) {
            }
        })
        //Email verification
        edt_email.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (android.util.Patterns.EMAIL_ADDRESS.matcher(edt_email.text.toString()).matches())
                else {
                    edt_email.setError("Invalid Email")
                }
            }

            override fun afterTextChanged(s: Editable?) {
            }
        })

        //edit password
        edt_password.setOnTouchListener(OnTouchListener { v, event ->
            val DRAWABLE_LEFT = 0
            val DRAWABLE_TOP = 1
            val DRAWABLE_RIGHT = 2
            val DRAWABLE_BOTTOM = 3
            if (event.action == MotionEvent.ACTION_UP) {
                if (event.rawX >= edt_password.getRight() - edt_password.getCompoundDrawables().get(DRAWABLE_RIGHT).getBounds().width()) {
                    Toast.makeText(applicationContext,  "drawable right clicked", Toast.LENGTH_LONG).show()
                  DataStore.verifyMobile = "ProfileVerify"
                    val intent = Intent(this@ProfileActivity,VerifyMobileActivity::class.java)
                    startActivity(intent)
                    return@OnTouchListener true
                }
            }
            false
        })


    }
    //submit button click
    fun onProfileSubmitClick(view: View) {
        //check otp for email and phone no.
        //valid password
        if (edt_password.getText().toString().isEmpty())
        {
            edt_password.setError("enter valid password")
        }

        val name = "aA1"
        val email = "aA1"
        val mobile = "aA1"
        val gender = "aA1"
        val password = "aA1"
        RetrofitClient.instance.updateprofile(name, email, mobile, gender, password)
                .enqueue(object: Callback<ProfileResponse> {
                    override fun onFailure(call: Call<ProfileResponse>, t: Throwable) {
                        Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
                    }

                    override fun onResponse(call: Call<ProfileResponse>, response: Response<ProfileResponse>) {

                        Toast.makeText(applicationContext, response.body()?.message, Toast.LENGTH_LONG).show()

                        val intent = Intent(this@ProfileActivity,AuthenticationActivity::class.java)
                        startActivity(intent)
                    }
                })



        //val signup_url = "https://demo.adroitlearning.org/Api/signup"
        val signup_url = "https://fe6f1e10-d73e-4993-b326-c1663e656c13.mock.pstmn.io/api/profile?name=gunjan&mobile=9156602107&email=g@gmail.com&password=Gg@1/api/profile"
        //when everything is good
      /*  val stringRequest = object : StringRequest(
            Request.Method.POST, signup_url,
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
                params["gender"] = "Female"
                return params
            }
        }

        VolleySingleton.getInstance(this).addToRequestQueue(stringRequest)*/
    }

  /*  fun Onverify_emailClick(view: View) {
        val mobile = "91656603108"
        //if everything is fine
        RetrofitClient.instance.verifyMobile(mobile)
            .enqueue(object: Callback<VerifyMobileResponse> {
                override fun onFailure(call: Call<VerifyMobileResponse>, t: Throwable) {
                    Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
                }

                override fun onResponse(call: Call<VerifyMobileResponse>, response: Response<VerifyMobileResponse>) {

                    Toast.makeText(applicationContext, response.body()?.message, Toast.LENGTH_LONG).show()

                    val intent = Intent(this@ProfileActivity,VerifyMobileActivity::class.java)
                    startActivity(intent)
                }
            })
    }*/

  /*  fun Onverify_mobileClick(view: View) {
        val mobile = "91656603108"
        //if everything is fine
        RetrofitClient.instance.verifyMobile(mobile)
            .enqueue(object: Callback<VerifyMobileResponse> {
                override fun onFailure(call: Call<VerifyMobileResponse>, t: Throwable) {
                    Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
                }
                override fun onResponse(call: Call<VerifyMobileResponse>, response: Response<VerifyMobileResponse>) {

                    Toast.makeText(applicationContext, response.body()?.message, Toast.LENGTH_LONG).show()

                    val intent = Intent(this@ProfileActivity,VerifyMobileActivity::class.java)
                    startActivity(intent)
                }
            })
    }*/
}