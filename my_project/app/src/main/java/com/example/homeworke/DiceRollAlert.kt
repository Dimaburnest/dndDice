package com.example.homeworke

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class DiceRollAlert : DialogFragment() {
    var ma : MainActivity = MainActivity()

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog{
        return activity?.let {
            var throwNumbers :Int = 0
            ma = activity as MainActivity
            for (i in ma.historyValue) throwNumbers = i
            @Suppress
            val builder = AlertDialog.Builder(it)
                builder.setMessage("$throwNumbers")
            resources.getDimension(R.dimen.vertical_margin)
            resources.getDimension(R.dimen.horizontal_margin)
            resources.getDimension(R.dimen.text_size)
            builder.setOnCancelListener() {
                val dialogView = it as AlertDialog
                dialogView.setCanceledOnTouchOutside(true)
            }
                    .create()



            } ?: throw IllegalStateException("Activity cannot be null")


    }
}
