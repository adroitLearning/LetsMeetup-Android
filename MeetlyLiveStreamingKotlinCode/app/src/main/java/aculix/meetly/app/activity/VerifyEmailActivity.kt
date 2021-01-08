package aculix.meetly.app.activity

import `in`.co.adroit.kotlinretrofitcode.api.RetrofitClient
import `in`.co.adroit.kotlinretrofitcode.models.VerifyEmailResponse
import aculix.meetly.app.R
import aculix.meetly.app.utils.DataStore
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_registration.*
import kotlinx.android.synthetic.main.activity_verify_email.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class VerifyEmailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verify_email)

        otp_text.setText("Please enter an OTP sent to your : "+DataStore.EmailId)

        val timer = object: CountDownTimer(60000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                tv_time.setText("00: " + millisUntilFinished / 1000)
                btn_resend.isEnabled = false;
            }

            override fun onFinish() {
                tv_time.setText("Time's finished!");
                btn_resend.isEnabled = true;
            }
        }
        timer.start()
    }

    fun onResendEmailOTPClick(view: View) {
        val timer = object: CountDownTimer(60000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                tv_time.setText("00: " + millisUntilFinished / 1000)
                btn_resend.isEnabled = false;
            }

            override fun onFinish() {
                tv_time.setText("Time's finished!");
                btn_resend.isEnabled = true;
            }
        }
        timer.start()

    }
    fun onVerifyEmailClick(view: View) {
        if(edt_otp.editableText.toString().isEmpty()){
            edt_otp.setError("Please enter otp")
            return
        }
        else{
            val email = "g@gmail.com"
            //if everything is fine
            RetrofitClient.instance.verifyEmail(email)
                .enqueue(object: Callback<VerifyEmailResponse> {
                    override fun onFailure(call: Call<VerifyEmailResponse>, t: Throwable) {
                        Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
                    }
                    override fun onResponse(call: Call<VerifyEmailResponse>, response: Response<VerifyEmailResponse>) {

                        Toast.makeText(applicationContext, response.body()?.message, Toast.LENGTH_LONG).show()

                        TestActivity.startActivity(this@VerifyEmailActivity)
                     /*   val intent = Intent(this@VerifyEmailActivity,MainActivity::class.java)
                        startActivity(intent)*/
                    }
                })
        }

    }
}