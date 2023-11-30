package com.example.myapplication

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.widget.ListView
import android.widget.TextView
import com.example.myapplication.databinding.ActivityMainBinding


import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val items = ArrayList<Contact>()
        items.add(Contact(R.drawable.profile, "John Doe", "08123456789", "john.doe@example.com", "Jalan Merdeka 123, Jakarta"))
        items.add(Contact(R.drawable.profile, "Jane Doe", "08123456780", "jane.doe@example.com", "Jalan Sejahtera 456, Bandung"))
        items.add(Contact(R.drawable.profile, "John Smith", "08123456781", "john.smith@example.com", "Jalan Sukses 789, Surabaya"))

        val listView = findViewById<ListView>(R.id.listView)

        listView.setOnItemClickListener { _, _, position, _ ->
            val selectedContact = items[position]
            val dialog = DetailDialog(this, selectedContact)
            dialog.show()
        }

        val adapter = ListAdapter(this, items)
        listView.adapter = adapter
    }
}

class DetailDialog(context: Context, private val contact: Contact) : Dialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detaildialog)

        findViewById<TextView>(R.id.textView_nama).text = contact.nama
        findViewById<TextView>(R.id.textView_no_telp).text = contact.no_telp

    }
}

