package com.example.birthdaywishing

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        createBirthday.setOnClickListener{
//            Toast.makeText(this,"This is a Toast",Toast.LENGTH_LONG).show()
//        }
    }

    fun creates(view: View){
//        Toast.makeText(this,"This is a Toast",Toast.LENGTH_LONG).show()
        val name = editTextTextPersonName.editableText.toString()
        var intent = Intent(this,Birthday::class.java)
        intent.putExtra(Birthday.NAME_EXTRA,name)
        startActivity(intent)
    }
}