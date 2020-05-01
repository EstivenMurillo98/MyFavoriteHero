package com.heroes.miheroe

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.heroes.miheroe.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private var validationToast = 0
    val trackOne = "Este héroe es conocido por ser uno de los más fuertes del equipo de los Avengers"
    val trackTwo = "Uno de sus principales enemigos es conocido como Abominación"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.btnValidateNickname.setOnClickListener { validateNickname(it) }
    }

    private fun validateNickname(view: View) {
        binding.apply {
            if ("HULK" == edtNicknameEdit.text.toString().toUpperCase()){
                imgIconHulk.visibility = TextView.VISIBLE
                txtNicknameHero.visibility = TextView.VISIBLE
                txtTestHero.visibility = TextView.GONE
                edtNicknameEdit.visibility = TextView.GONE
                btnValidateNickname.visibility = TextView.GONE
                txtNicknameHero.setBackgroundColor(Color.parseColor("#7cb342"))
            } else {
                if (validationToast == 0){
                    Toast.makeText(applicationContext, trackOne, Toast.LENGTH_SHORT).show()
                    validationToast = 1
                } else {
                    Toast.makeText(applicationContext, trackTwo, Toast.LENGTH_SHORT).show()
                    validationToast = 0;
                }
            }
        }
        val imn = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imn.hideSoftInputFromWindow(view.windowToken,0)
    }
}
