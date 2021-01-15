package aculix.meetly.app.activity

import `in`.co.adroit.kotlinretrofitcode.api.RetrofitClient
import `in`.co.adroit.kotlinretrofitcode.models.VerifyMobileResponse
import aculix.meetly.app.R
import aculix.meetly.app.utils.DataStore
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_verify_email.*
import kotlinx.android.synthetic.main.activity_verify_mobile.*
import kotlinx.android.synthetic.main.activity_verify_mobile.btn_resend
import kotlinx.android.synthetic.main.activity_verify_mobile.edt_otp
import kotlinx.android.synthetic.main.activity_verify_mobile.tv_time
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class VerifyMobileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verify_mobile)

        otp_text_mobile.setText("Please enter an OTP sent to your : "+DataStore.MobileNo)

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

    fun onResendMobileOTPClick(view: View) {
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
    fun onVerifyMobileClick(view: View) {
        if(edt_otp.editableText.toString().isEmpty()){
            edt_otp.setError("Please enter otp")
            return
        }
        else{
            val mobile = "91656603108"
            //if everything is fine
            RetrofitClient.instance.verifyMobile(mobile)
                .enqueue(object: Callback<VerifyMobileResponse> {
                    override fun onFailure(call: Call<VerifyMobileResponse>, t: Throwable) {
                        Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
                    }
                    override fun onResponse(call: Call<VerifyMobileResponse>, response: Response<VerifyMobileResponse>) {

                        Toast.makeText(applicationContext, response.body()?.message, Toast.LENGTH_LONG).show()

                        val data = DataStore.verifyMobile
                        if(data == "ProfileVerify"){
                            val intent = Intent(this@VerifyMobileActivity,ChangePasswordActivity::class.java)
                            startActivity(intent)
                        }
                        else{
                            val intent = Intent(this@VerifyMobileActivity,VerifyEmailActivity::class.java)
                            startActivity(intent)
                        }
                        // Toast.makeText(applicationContext, data, Toast.LENGTH_LONG).show()
                    }
                })
        }

    }
}