package com.runningcherry.pyrozhock

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import java.text.SimpleDateFormat
import java.util.*

class AddEditEventFragment : Fragment() {
    private lateinit var editName: EditText
    private lateinit var editDate: TextView
    private lateinit var startTime: TextView
    private lateinit var endTime: TextView
    private lateinit var doneBtn: Button

    @SuppressLint("SimpleDateFormat")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        editName = requireView().findViewById(R.id.edit_name)
        editDate = requireView().findViewById(R.id.edit_date)
        startTime = requireView().findViewById(R.id.start_time)
        endTime = requireView().findViewById(R.id.end_time)
        doneBtn = requireView().findViewById(R.id.done_btn)

        val dateFormatter = SimpleDateFormat("dd-MM-yyyy")
        editDate.text = dateFormatter.format(Date())

        editDate.setOnClickListener {
            onDateClick(editDate, dateFormatter)
        }

        startTime.setOnClickListener {
            onTimeClick(startTime)
        }

        endTime.setOnClickListener {
            onTimeClick(endTime)
        }

        doneBtn.setOnClickListener {
            val event = Event(editName.toString(), editDate.toString(), startTime.toString(), endTime.toString())
        }
    }

    private fun onDateClick(date: TextView, dateFormatter: SimpleDateFormat) {
        val datePicker =
            MaterialDatePicker.Builder.datePicker()
                .setTitleText("Select date")
                .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
                .build()

        datePicker.addOnPositiveButtonClickListener {
            date.text = dateFormatter.format(Date(it))
        }

        datePicker.show(requireActivity().supportFragmentManager, "date picker")
    }

    @SuppressLint("SetTextI18n")
    private fun onTimeClick(time: TextView) {
        val timePicker =
            MaterialTimePicker.Builder()
                .setTimeFormat(TimeFormat.CLOCK_24H)
                .setHour(12)
                .setMinute(10)
                .setTitleText("Select time")
                .build()

        timePicker.addOnPositiveButtonClickListener {
            time.text = "${timePicker.hour}:${timePicker.minute}"
        }

        timePicker.show(requireActivity().supportFragmentManager, "time picker")

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_edit_event, container, false)
    }

}