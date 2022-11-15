package com.runningcherry.pyrozhock

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var mainRecyclerView: RecyclerView
    private var mainRecyclerViewAdapter: MainRecyclerViewAdapter = MainRecyclerViewAdapter()
    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = findViewById(R.id.main_toolbar)
        toolbar.inflateMenu(R.menu.main_default_toolbar_menu)
        toolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.add -> {
                    Log.i("kek", "tab to plus")
                    val intent = Intent(this, AddEditEventActivity::class.java)
                    startActivity(intent)
                }
            }
            false
        }

        mainRecyclerView = findViewById(R.id.main_recycler_view)
        mainRecyclerView.adapter = mainRecyclerViewAdapter
        val linearLayoutManager = LinearLayoutManager(this)
        mainRecyclerView.layoutManager = linearLayoutManager

        testRecyclerView()
    }

    private fun testRecyclerView() {
        val event = Event("подрочить", Date(), "00:00", "23:59")
        for (i in 1..100) {
            mainRecyclerViewAdapter.addItem(event)
        }

    }
}