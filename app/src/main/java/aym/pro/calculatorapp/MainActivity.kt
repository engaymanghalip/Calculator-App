package aym.pro.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import aym.pro.calculatorapp.databinding.ActivityMainBinding
import java.lang.ArithmeticException

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var lastNumeric : Boolean = false
    var lastDot : Boolean = false
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
        lastNumeric = true
        lastDot = false


    }

    fun onClear(view : View){
//        tvInput?.text = ""
        binding.tvInput.text = ""
    }

    fun onDecimalPoint(view: View){
        if(lastNumeric && !lastDot){
            binding.tvInput.append(".")
            lastNumeric = false
            lastDot = true
        }
    }

    fun onOperator(view : View){
        binding.tvInput?.text?.let {
            if(lastNumeric && !isOperatorAdded(it.toString())){
                binding.tvInput.append((view as Button ).text)
                lastNumeric = false
                lastDot = false
            }
        }

    }

    fun onEqual(view: View){
        if(lastNumeric){
         var tvValue = binding.tvInput?.text.toString()
            var prefix = ""

            try {
                if (tvValue.startsWith("-")){
                    prefix = "-"
                    tvValue = tvValue.substring(1)
                }
                 if(tvValue.contains("-")){
                     val splitvalue = tvValue.split("-")

                     var one = splitvalue[0]
                     var two = splitvalue[1]

                     if(prefix.isEmpty()){
                         one = prefix + one
                     }
//                var result = one.toDouble() - two.toDouble()
                     binding.tvInput?.text =removeZeroAfteDot((one.toDouble() - two.toDouble()).toString())
                 }
                else if (tvValue.startsWith("+")){
                     prefix = "-"
                     tvValue = tvValue.substring(1)
                 }
                if(tvValue.contains("+")){
                    val splitvalue = tvValue.split("+")

                    var one = splitvalue[0]
                    var two = splitvalue[1]

                    if(prefix.isEmpty()){
                        one = prefix + one
                    }
//                var result = one.toDouble() - two.toDouble()
                    binding.tvInput?.text =removeZeroAfteDot((one.toDouble() + two.toDouble()).toString())
                }
                else if (tvValue.startsWith("*")){
                    prefix = "-"
                    tvValue = tvValue.substring(1)
                }
                if(tvValue.contains("*")){
                    val splitvalue = tvValue.split("*")

                    var one = splitvalue[0]
                    var two = splitvalue[1]

                    if(prefix.isEmpty()){
                        one = prefix + one
                    }
//                var result = one.toDouble() - two.toDouble()
                    binding.tvInput?.text =removeZeroAfteDot((one.toDouble() * two.toDouble()).toString())
                }
                else if (tvValue.startsWith("/")){
                    prefix = "-"
                    tvValue = tvValue.substring(1)
                }
                if(tvValue.contains("/")){
                    val splitvalue = tvValue.split("/")

                    var one = splitvalue[0]
                    var two = splitvalue[1]

                    if(prefix.isEmpty()){
                        one = prefix + one
                    }
//                var result = one.toDouble() - two.toDouble()
                    binding.tvInput?.text = removeZeroAfteDot((one.toDouble() / two.toDouble()).toString())
                }

            }catch (e: ArithmeticException){
                e.printStackTrace()
            }
        }
    }

    private fun removeZeroAfteDot(result : String) : String{
        var value = result
        if(result.contains(".0")){
            value = result.substring(0,result.length - 2)
        }
        return value
    }

    private fun isOperatorAdded(value : String) : Boolean
    {
       return if(value.startsWith("-")){
           false
       }
        else
        {
            value.contains("/")
                    ||value.contains("*")
                    ||value.contains("+")
                    ||value.contains("-")
        }
    }

}