package com.runningcherry.pyrozhock

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainRecyclerViewAdapter(private var currentDate: String) :
    RecyclerView.Adapter<MainRecyclerViewAdapter.ViewHolder>() {

    private var listOfEvents: MutableMap<String, ArrayList<Event>> = mutableMapOf()

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var eventName : TextView = view.findViewById(R.id.event_name)
        var timePeriod : TextView = view.findViewById(R.id.time_period)
        var isDone : CheckBox = view.findViewById(R.id.is_done)

        @SuppressLint("SetTextI18n")
        fun bind(event: Event) {
            eventName.text = event.name
            timePeriod.text = "${event.start} - ${event.end}"
            isDone.isChecked = event.done
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.main_recycler_view_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listOfEvents[currentDate]!![position])
    }

    override fun getItemCount(): Int {
        return listOfEvents[currentDate]!!.size
    }

    private fun checkValidKey(date: String) {
        if (!listOfEvents.containsKey(date)) {
            listOfEvents[date] = arrayListOf()
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun changeDate(newDate: String) {
        checkValidKey(newDate)
        currentDate = newDate
        notifyDataSetChanged()
    }

    fun addItem(item: Event) {
        checkValidKey(item.date)
        listOfEvents[item.date]!!.add(item)
        if (item.date == currentDate) {
            notifyItemChanged(itemCount - 1)
        }
    }

}