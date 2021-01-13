package com.adroit.letslinkup.activity

import com.adroit.letslinkup.R
import com.adroit.letslinkup.utils.DataStore
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.View.OnTouchListener
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_profile.*
import kotlinx.android.synthetic.main.activity_registration.*


class ProfileActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
   // var topAppBar: MaterialToolbar? = null
   var languages = arrayOf("Select Gender", "Female", "Male", "Other")
    val NEW_SPINNER_ID = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

       //set values in fields
       edt_username.setText(DataStore.user_name)
       prf_edt_email.setText(DataStore.EmailId)
       edt_mobileNo.setText(DataStore.MobileNo)
       edt_password.setText(DataStore.password)

        //select gender spinner code
        var aa = ArrayAdapter(this, android.R.layout.simple_spinner_item, languages)
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        with(profile_spinner)
        {
            adapter = aa
            setSelection(0, false)
            onItemSelectedListener = this@ProfileActivity
            //   prompt = "Select gender"
            gravity = android.view.Gravity.CENTER

        }

        val spinner = Spinner(this)
        spinner.id = NEW_SPINNER_ID

        val ll = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )

        ll.setMargins(10, 20, 10, 10)
        linear_layout.addView(spinner)

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
       prf_edt_email.addTextChangedListener(object : TextWatcher {
           override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
           }

           override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
               if (android.util.Patterns.EMAIL_ADDRESS.matcher(prf_edt_email.text.toString())
                       .matches()
               )
               else {
                   prf_edt_email.setError("Invalid Email")
               }
           }

           override fun afterTextChanged(s: Editable?) {
           }
       })

        //mobile no validation
        edt_mobileNo.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (edt_mobileNo.getText().toString().length < 10) {
                    edt_mobileNo.setError("Please enter correct mobile no")
                }
            }

            override fun afterTextChanged(s: Editable?) {
            }
        })

       edt_password.setOnTouchListener(OnTouchListener { v, event ->
           val DRAWABLE_LEFT = 0
           val DRAWABLE_TOP = 1
           val DRAWABLE_RIGHT = 2
           val DRAWABLE_BOTTOM = 3
           if (event.rawX <= edt_password.getCompoundDrawables().get(DRAWABLE_LEFT).getBounds()
                   .width()
           ) {
               //Toast.makeText(applicationContext, "drawable left clicked", Toast.LENGTH_LONG).show()
               val intent = Intent(this@ProfileActivity, ChangePasswordActivity::class.java)
               startActivity(intent)
               // your action here
               true
           } else false
       })

    }
    //submit button click
    fun onProfileSubmitClick(view: View) {
        //check otp for email and phone no.
        //valid password
        if (edt_password.getText().toString().isEmpty())
        {
            edt_password.setError("enter valid password")
            return
        }
        Toast.makeText(applicationContext, "profile updated successfully", Toast.LENGTH_LONG).show()

        /*val sharedPreference =  getSharedPreferences("PREFERENCE_NAME",Context.MODE_PRIVATE)
        var editor = sharedPreference.edit()
        editor.putString("islogged_in","true")
        editor.commit()*/

        val intent = Intent(this@ProfileActivity, MainActivity::class.java)
        startActivity(intent)
       /* val name = "aA1"
        val email = "aA1"
        val mobile = "aA1"
        val gender = "aA1"
        val password = "aA1"*/
       /* RetrofitClient.instance.updateprofile(name, email, mobile, gender, password)
                .enqueue(object : Callback<ProfileResponse> {
                    override fun onFailure(call: Call<ProfileResponse>, t: Throwable) {
                        Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
                    }

                    override fun onResponse(
                            call: Call<ProfileResponse>,
                            response: Response<ProfileResponse>
                    ) {

                        Toast.makeText(
                                applicationContext,
                                response.body()?.message,
                                Toast.LENGTH_LONG
                        ).show()

                        val intent = Intent(
                                this@ProfileActivity, MainActivity::class.java
                        )
                        startActivity(intent)
                    }
                })
*/


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

    fun onImgChangePwd(view: View) {
        DataStore.verifyMobile = "ProfileVerify"
        val intent = Intent(this@ProfileActivity, VerifyMobileActivity::class.java)
        startActivity(intent)
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        showToast(message = "Nothing selected")
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        showToast(message = "${languages[position]}")
        DataStore.gender = "${languages[position]}"

    }
    private fun showToast(
        context: Context = applicationContext,
        message: String,
        duration: Int = Toast.LENGTH_LONG
    ) {
        Toast.makeText(context, message, duration).show()
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