package com.runningcherry.pyrozhock

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainRecyclerViewAdapter : RecyclerView.Adapter<MainRecyclerViewAdapter.ViewHolder>() {
    private var listOfEvents : ArrayList<Event> = arrayListOf()

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var eventName : TextView = view.findViewById(R.id.event_name)
        var timePeriod : TextView = view.findViewById(R.id.time_period)
        var isDone : CheckBox = view.findViewById(R.id.is_done)

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
        holder.bind(listOfEvents[position])
    }

    override fun getItemCount(): Int {
        return listOfEvents.size
    }

    fun addItem(item: Event) {
        listOfEvents.add(item)
        notifyItemChanged(itemCount - 1)
    }

}