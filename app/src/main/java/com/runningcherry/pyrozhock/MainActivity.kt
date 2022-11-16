package com.runningcherry.pyrozhock

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.datepicker.MaterialDatePicker
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var mainRecyclerView: RecyclerView
    private lateinit var mainRecyclerViewAdapter: MainRecyclerViewAdapter
    private lateinit var toolbar: Toolbar
    @SuppressLint("SimpleDateFormat")
    private val dateFormatter = SimpleDateFormat("dd-MM-yyyy")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = findViewById(R.id.main_toolbar)
        toolbar.inflateMenu(R.menu.main_default_toolbar_menu)
        toolbar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.add -> {
                    Log.i("kek", "tab to plus")
                    val intent = Intent(this, AddEditEventActivity::class.java)
                    startActivity(intent)
                }
                R.id.calendar -> {
                    Log.i("kek", "tab to calendar")
                    val datePicker =
                        MaterialDatePicker.Builder.datePicker()
                            .setTitleText("Select date")
                            .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
                            .build()

                    datePicker.addOnPositiveButtonClickListener {
                        val date = dateFormatter.format(Date(it))
                        mainRecyclerViewAdapter.changeDate(date)
                    }

                    datePicker.show(supportFragmentManager, "date picker")
                }
            }
            false
        }

        mainRecyclerView = findViewById(R.id.main_recycler_view)
        mainRecyclerViewAdapter = MainRecyclerViewAdapter(dateFormatter.format(Date()))
        mainRecyclerView.adapter = mainRecyclerViewAdapter
        val linearLayoutManager = LinearLayoutManager(this)
        mainRecyclerView.layoutManager = linearLayoutManager

        testRecyclerView()
    }

    private fun testRecyclerView() {
        val event = Event("подрочить", dateFormatter.format(Date()), "00:00", "23:59")
        for (i in 1..100) {
            mainRecyclerViewAdapter.addItem(event)
        }

    }
}