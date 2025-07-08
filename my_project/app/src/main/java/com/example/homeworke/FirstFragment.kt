package com.example.homeworke

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels

import com.example.homeworke.databinding.FragmentFirstBinding
import kotlin.random.Random

class FirstFragment : Fragment() {

    var counterDice: Int = 1
    var counterMod: Int = 0
    var dataThrow = ArrayList<Int>()
    private val sharedVh: SharedViewModel by activityViewModels()
    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initlisteners()
    }

    fun initlisteners() {

//binding.apply {
//    d4
//}

        binding.d4.setOnClickListener {
            val randomNumber = sumThrowDice(5)
            showAlert(this, dataThrow.toString())
            val newItem = Item(
                throwDise = mutableListOf(randomNumber),
                diseNumber = mutableListOf("D4")
            )
            sharedVh.addItem(newItem)
            dataThrow.clear()
        }
        binding.d6.setOnClickListener {
            val randomNumber = sumThrowDice(7)
            showAlert(this, dataThrow.toString())
            val newItem = Item(
                throwDise = mutableListOf(randomNumber),
                        diseNumber = mutableListOf("D6")
            )
            sharedVh.addItem(newItem)
            dataThrow.clear()
        }
        binding.d8.setOnClickListener {
            val randomNumber = sumThrowDice(9)
            showAlert(this, dataThrow.toString())
            val newItem = Item(
                throwDise = mutableListOf(randomNumber),
                        diseNumber = mutableListOf("D8")
            )
            sharedVh.addItem(newItem)
            dataThrow.clear()

        }
        binding.d10.setOnClickListener {
            val randomNumber = sumThrowDice(11)
            showAlert(this, dataThrow.toString())
            val newItem = Item(
                throwDise = mutableListOf(randomNumber),
                diseNumber = mutableListOf("D10")
            )
            sharedVh.addItem(newItem)
            dataThrow.clear()
        }
        binding.d12.setOnClickListener {
            val randomNumber = sumThrowDice(13)
            showAlert(this, dataThrow.toString())
            val newItem = Item(
                throwDise = mutableListOf(randomNumber),
                diseNumber = mutableListOf("D12")
            )
            sharedVh.addItem(newItem)
            dataThrow.clear()
        }
        binding.d20.setOnClickListener {
            val randomNumber = sumThrowDice(21)
            showAlert(this, dataThrow.toString())
            val newItem = Item(
                throwDise = mutableListOf(randomNumber),
                diseNumber = mutableListOf("D20")
            )
            sharedVh.addItem(newItem)
            dataThrow.clear()
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
            dataThrow.add(sum)
//            Log.d("main123123123", "sum: $sum")
        }
        return result
    }
    fun showAlert(context: FirstFragment, message: String) {
        val builder = AlertDialog.Builder(requireContext())
        val throwNumbers: Int = dataThrow.sum()
        builder.setMessage(message + " " + throwNumbers)
        builder.setPositiveButton("ОК") { dialog, which -> dialog.dismiss() }
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
