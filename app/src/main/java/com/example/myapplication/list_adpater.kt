package com.example.myapplication;

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView


public class ListAdapter(private val context: Context, private val items: List<Contact>) : BaseAdapter() {

        override fun getCount(): Int {
        return items.size
        }

        override fun getItem(position: Int): Contact {
        return items[position]
        }

        override fun getItemId(position: Int): Long {
        return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        if (convertView == null) {
        convertView = LayoutInflater.from(context).inflate(R.layout.list, parent, false)
        }

        val item = getItem(position)

        val imageView = convertView!!.findViewById<ImageView>(R.id.imageView)
        imageView.setImageResource(item.imageResource)

        val textView_nama = convertView.findViewById<TextView>(R.id.textView_nama)
        textView_nama.text = item.nama

        val textView_no_telp = convertView.findViewById<TextView>(R.id.textView_no_telp)
        textView_no_telp.text = item.no_telp

        return convertView
        }
        }

