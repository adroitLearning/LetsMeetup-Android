package aculix.meetly.app.activity

import `in`.co.adroit.kotlinretrofitcode.api.RetrofitClient
import `in`.co.adroit.kotlinretrofitcode.models.ChangePassword
import `in`.co.adroit.kotlinretrofitcode.models.RegistrationResponse
import aculix.meetly.app.R
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_change_password.*
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_registration.*
import kotlinx.android.synthetic.main.activity_registration.edt_confirm_pwd
import kotlinx.android.synthetic.main.activity_registration.edt_pwd
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ChangePasswordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_password)

        //check otp for email and phone no.
        edt_confirmnewPwd.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if  (edt_confirmnewPwd.getText().toString() != edt_confirmnewPwd.getText().toString()) {
                    Toast.makeText(
                        this@ChangePasswordActivity,
                        "Password not correct", Toast.LENGTH_SHORT
                    ).show()
                }
            }
            override fun afterTextChanged(s: Editable?) {
            }
        })
    }

    fun onChangeSubmitClick(view: View) {
        if (edt_oldPwd.getText().toString().length < 1){
            edt_oldPwd.setError("Please enter password")
            return
        }
        if (edt_confirmnewPwd.getText().toString().length < 1){
            edt_confirmnewPwd.setError("Please enter confirm password")
            return
        }
        if  (edt_newPwd.getText().toString() != edt_confirmnewPwd.getText().toString()) {
            Toast.makeText(
                this@ChangePasswordActivity,
                "Password does not match", Toast.LENGTH_SHORT
            ).show()
            return
        }
        else{
            //if everything is fine
            val password = "aA1"
            RetrofitClient.instance.changepassword(password)
                    .enqueue(object: Callback<ChangePassword> {
                        override fun onFailure(call: Call<ChangePassword>, t: Throwable) {
                            Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
                        }

                        override fun onResponse(call: Call<ChangePassword>, response: Response<ChangePassword>) {

                            Toast.makeText(applicationContext, response.body()?.message, Toast.LENGTH_LONG).show()

                            val intent = Intent(this@ChangePasswordActivity,MainActivity::class.java)
                            startActivity(intent)
                        }
                    })
        }
    }
}