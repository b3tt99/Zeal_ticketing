package com.example.zeal_ticketing

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport

class CustomAdapter(var context: Context, var data:ArrayList<CrashlyticsReport.Session.User>):BaseAdapter() {
    private class ViewHolder(row: View?) {
        var mEventName: TextView
        var mEventDescription: TextView


        init {
            this.mEventName = row?.findViewById(R.id.mEname) as TextView
            this.mEventDescription = row?.findViewById(R.id.mEdescription) as TextView

        }
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view: View?
        var viewHolder: ViewHolder
        if (convertView == null) {
            var layout = LayoutInflater.from(context)
            view = layout.inflate(R.layout.event_layout, parent, false)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }
        var item: Event = getItem(position) as Event
        viewHolder.mEventName.text = item.name
        viewHolder.mEventDescription.text = item.description
        return view as View
    }

    override fun getItem(position: Int): Any {
        return data.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return data.count()
    }

}