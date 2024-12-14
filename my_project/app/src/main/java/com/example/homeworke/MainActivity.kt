package com.example.homeworke

import android.content.Context
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import com.example.homeworke.databinding.DiceRollBinding
import com.google.android.material.tabs.TabLayout
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


        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "ROLL DICE"

        val viewPager: ViewPager2 = findViewById(R.id.viewPager)
        val tabLayout: TabLayout? = findViewById(R.id.tabLayout)

        val adapter = MyPagerAdapter(this)
        viewPager.adapter = adapter
    }


 fun initlisteners() {
//binding.apply {
//    d4
//}
        binding.d4.setOnClickListener {
            val randomNumber = sumThrowDice(5)
            showAlert(this, historyValue.toString())
            historyValue.clear()
        }
        binding.d6.setOnClickListener {
            val randomNumber = sumThrowDice(7)
            showAlert(this, historyValue.toString())
            historyValue.clear()
        }
        binding.d8.setOnClickListener {
            val randomNumber = sumThrowDice(9)
            showAlert(this, historyValue.toString())
            historyValue.clear()
        }
        binding.d10.setOnClickListener {
            val randomNumber = sumThrowDice(11)
            showAlert(this, historyValue.toString())
            historyValue.clear()
        }
        binding.d12.setOnClickListener {
            val randomNumber = sumThrowDice(13)
            showAlert(this, historyValue.toString())
            historyValue.clear()
        }
        binding.d20.setOnClickListener {
            val randomNumber = sumThrowDice(21)
            showAlert(this, historyValue.toString())
            historyValue.clear()
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
        var result = 0
        for (i in 0..counterDice - 1) {
            sum = Random.nextInt(1, maxDiceValue) + counterMod
            result += sum
            if (sum < 1) {
                sum = 1
            }
            historyValue.add(sum)
//            Log.d("main123123123", "sum: $sum")
        }
        return result
    }

    fun showAlert(context: Context, message: String) {
        val builder = AlertDialog.Builder(context)
        val throwNumbers: Int = historyValue.sum()
        builder.setMessage(message + " " + throwNumbers)
        builder.setPositiveButton("ОК") { dialog, which -> dialog.dismiss() }
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

}

