package com.example.homeworke

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.homeworke.databinding.DiceRollBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    var counterDice: Int = 1
    var counterMod: Int = 0
    var historyValue = ArrayList<Int>()
    private var _binding: DiceRollBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = DiceRollBinding.inflate(layoutInflater)
        setContentView(binding.root)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.dice)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initlisteners()


    }

    fun initlisteners() {
//binding.apply {
//    d4
//}
        binding.d4.setOnClickListener {
            val randomNumber = sumThrowDice(5)
            Toast.makeText(this, "$randomNumber", Toast.LENGTH_SHORT).show()

        }
        binding.d6.setOnClickListener {
            val randomNumber = sumThrowDice(7)
            Toast.makeText(this, "$randomNumber", Toast.LENGTH_SHORT).show()
        }
        binding.d8.setOnClickListener {
            val randomNumber = sumThrowDice(9)
            Toast.makeText(this, "$randomNumber", Toast.LENGTH_SHORT).show()
        }
        binding.d10.setOnClickListener {
            val randomNumber = sumThrowDice(11)
            Toast.makeText(this, "$randomNumber", Toast.LENGTH_SHORT).show()
        }
        binding.d12.setOnClickListener {
            val randomNumber = sumThrowDice(13)
            Toast.makeText(this, "$randomNumber", Toast.LENGTH_SHORT).show()
        }
        binding.d20.setOnClickListener {
            val randomNumber = sumThrowDice(21)
            Toast.makeText(this, "$randomNumber", Toast.LENGTH_SHORT).show()
        }
        binding.buttonDice.setOnClickListener {

        }
        binding.buttonHisory.setOnClickListener {

        }
        binding.plusMod.setOnClickListener {
            if (counterMod > -2) {
                counterMod++
                binding.counterMod.text = "+" + counterMod.toString()
            } else {
                counterMod++
                binding.counterMod.text = counterMod.toString()
            }
        }
        binding.minusMod.setOnClickListener {
            if (counterMod > 0) {
                counterMod--
                binding.counterMod.text = "+" + counterMod.toString()
            } else {
                counterMod--
                binding.counterMod.text = counterMod.toString()
            }
        }
        binding.plusThrow.setOnClickListener {
            counterDice++
            binding.counterThrow.text = counterDice.toString() + "d"
        }
        binding.minusThrow.setOnClickListener {
            if (counterDice > 1) {
                counterDice--
                binding.counterThrow.text = counterDice.toString() + "d"
            }
        }
    }

    fun sumThrowDice(maxDiceValue: Int): Int {
        var sum = 0
        for (i in 0..counterDice -1){
            sum += Random.nextInt(1, maxDiceValue)
            Log.d("main123123123", "sum: $sum")
        }

        return sum
    }
}