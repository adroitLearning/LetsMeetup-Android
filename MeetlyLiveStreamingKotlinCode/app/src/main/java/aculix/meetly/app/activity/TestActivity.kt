package aculix.meetly.app.activity

import aculix.meetly.app.R
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_test.*

class TestActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener{
    var languages = arrayOf("Java", "PHP", "Kotlin", "Javascript", "Python", "Swift")
  //  val NEW_SPINNER_ID = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        var aa = ArrayAdapter(this, android.R.layout.simple_spinner_item, languages)
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        with(mySpinner)
        {
            adapter = aa
            setSelection(0, false)
            onItemSelectedListener = this@TestActivity
            prompt = "Select your favourite language"
            gravity = Gravity.CENTER

        }

        val spinner = Spinner(this)
      //  spinner.id = NEW_SPINNER_ID

        val ll = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)

        ll.setMargins(10, 10, 10, 10)
        linear_Layout.addView(spinner)

       // aa = ArrayAdapter(this, R.layout.spinner_right_aligned, languages)
        //aa.setDropDownViewResource(R.layout.spinner_right_aligned)

      /*  with(spinner)
        {
            adapter = aa
            setSelection(0, false)
            onItemSelectedListener = this@TestActivity
            layoutParams = ll
            prompt = "Select your favourite language"
            setPopupBackgroundResource(R.color.material_grey_600)

        }*/

    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        showToast(message = "Nothing selected")
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        showToast(message = "Spinner 1 Position:${position} and language: ${languages[position]}")


    /*    when (view?.id) {
           *//* 1 -> showToast(message = "Spinner 2 Position:${position} and language: ${languages[position]}")
            else -> {*//*
                showToast(message = "Spinner 1 Position:${position} and language: ${languages[position]}")
            //}
        }*/
    }

    private fun showToast(context: Context = applicationContext, message: String, duration: Int = Toast.LENGTH_LONG) {
        Toast.makeText(context, message, duration).show()
    }
}