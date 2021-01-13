package com.adroit.letslinkup.activity

import `in`.co.adroit.kotlinretrofitcode.api.RetrofitClient
import `in`.co.adroit.kotlinretrofitcode.models.VerifyEmailResponse
import com.adroit.letslinkup.R
import com.adroit.letslinkup.utils.DataStore
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_registration.*
import kotlinx.android.synthetic.main.activity_verify_email.*
import kotlinx.android.synthetic.main.activity_verify_email.btn_resend
import kotlinx.android.synthetic.main.activity_verify_email.edt_otp
import kotlinx.android.synthetic.main.activity_verify_mobile.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class VerifyEmailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verify_email)

        otp_text.setText("Please enter an OTP sent to your "+DataStore.EmailId)


        btn_resend.isEnabled = false;

        val timer = object: CountDownTimer(60000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                tv_emailtime.setText("00: " + String.format("%02d",millisUntilFinished / 1000) )
                btn_resend.isEnabled = false;
            }

            override fun onFinish() {
                btn_resend.isEnabled = true;
            }
        }
        timer.start()
    }

    /*fun timer(Seconds: Int, tv: TextView) {
        object : CountDownTimer((Seconds * 1000 + 1000).toLong(), 1000) {
            override fun onTick(millisUntilFinished: Long) {
                var seconds = (millisUntilFinished / 1000).toInt()
             //   val minutes = "1"
                seconds = seconds % 60
                //tv.text = "" + "00" + ":" + String.format("%02d",seconds)
                tv.text = "" + "00" + ":" + String.format("%02d",seconds)
                return
            }

            override fun onFinish() {
                tv.text = "Completed"
              //  btn_resend.isEnabled = true;
            }
        }.start()
    }*/

    fun onResendEmailOTPClick(view: View) {

        val timer = object: CountDownTimer(60000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                tv_emailtime.setText("00: " + String.format("%02d",millisUntilFinished / 1000) )
                btn_resend.isEnabled = false;
            }

            override fun onFinish() {
                btn_resend.isEnabled = true;
            }
        }
        timer.start()

    }
    fun onVerifyEmailClick(view: View) {
        if(edt_otp.editableText.toString().isEmpty()){
            edt_otp.setError("Please enter correct otp")
            return
        }
        if (!edt_otp.editableText.toString().equals("9999")){
            edt_otp.setError("Please Enter correct otp")
            return
        }
        else{
            verify_email.isEnabled = false
            val email = "g@gmail.com"
            //if everything is fine
            RetrofitClient.instance.verifyEmail(email)
                .enqueue(object: Callback<VerifyEmailResponse> {
                    override fun onFailure(call: Call<VerifyEmailResponse>, t: Throwable) {
                        Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
                    }
                    override fun onResponse(call: Call<VerifyEmailResponse>, response: Response<VerifyEmailResponse>) {
                        verify_email.isEnabled = true
                        Toast.makeText(applicationContext, response.body()?.message, Toast.LENGTH_LONG).show()

                        //shared preference
                        val sharedPreference =  getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)
                        var editor = sharedPreference.edit()
                        editor.putString("islogged_in","true")
                        editor.commit()

                        MainActivity.startActivity(this@VerifyEmailActivity)
                     /*   val intent = Intent(this@VerifyEmailActivity,MainActivity::class.java)
                        startActivity(intent)*/
                    }
                })
        }

    }
    override fun onBackPressed() {
        Toast.makeText(this, "Please verify your email", Toast.LENGTH_SHORT).show()

        /*    super.onBackPressed()
            MainActivity.startActivity(this@VerifyMobileActivity)
            finish()*/
        return
    }
}