package com.runningcherry.pyrozhock

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.datepicker.MaterialDatePicker
import java.text.SimpleDateFormat
import java.util.*

class AddEditEventFragment : Fragment() {
    private lateinit var editName: EditText
    private lateinit var editDate: TextView
    private lateinit var startTime: TextView
    private lateinit var endTime: TextView

    @SuppressLint("SimpleDateFormat")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        editName = requireView().findViewById(R.id.edit_name)
        editDate = requireView().findViewById(R.id.edit_date)
        startTime = requireView().findViewById(R.id.start_time)
        endTime = requireView().findViewById(R.id.end_time)

        val dateFormatter = SimpleDateFormat("dd-MM-yyyy")
        editDate.text = dateFormatter.format(Date())

        editDate.setOnClickListener {
            val datePicker =
                MaterialDatePicker.Builder.datePicker()
                    .setTitleText("Select date")
                    .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
                    .build()

            datePicker.addOnPositiveButtonClickListener {
                editDate.text = dateFormatter.format(Date(it))
            }

            datePicker.show(requireActivity().supportFragmentManager, "date picker")
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_edit_event, container, false)
    }

}