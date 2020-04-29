package com.heroes.miheroe

import android.content.Context
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
    val trackOne = "Este héroe es conocido por ser uno de los más fuertes del equipo de los Avengers"
    val trackTwo = "Uno de sus enemigos es conocido como Abominación"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.btnValidateNickname.setOnClickListener { validateNickname(it) }
    }

    private fun validateNickname(view: View) {
        binding.apply {
            if ("HULK" == edtNicknameEdit.text.toString().toUpperCase()){
                txtNicknameHero.visibility = TextView.VISIBLE
                txtTestHero.visibility = TextView.GONE
                edtNicknameEdit.visibility = TextView.GONE
                btnValidateNickname.visibility = TextView.GONE
            } else {
                Toast.makeText(applicationContext, trackOne, Toast.LENGTH_SHORT).show()
                //Toast.makeText(applicationContext, trackOne, Toast.LENGTH_SHORT).show()
            }
        }
        val imn = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imn.hideSoftInputFromWindow(view.windowToken,0)
    }
}
