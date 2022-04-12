package aym.pro.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import aym.pro.calculatorapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

//    private var tvInput:TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

//        setContentView(R.layout.activity_main)

//        tvInput = findViewById(R.id.tvInput)

//    binding.btnOne.setOnClickListener { binding.tvInput.append("1") }

    }

    fun onDigit(view : View){
//      tvInput?.append((view as Button).text)
        binding.tvInput.append((view as Button).text)
    }

    fun onClear(view : View){
//        tvInput?.text = ""
        binding.tvInput.text = ""
    }

}