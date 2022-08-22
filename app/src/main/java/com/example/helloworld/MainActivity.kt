package com.example.helloworld

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
//pertaining to Geeks for Geeks hyperlink text tutorial
//import android.widget.TextView
import android.text.method.LinkMovementMethod
import android.view.Menu
import android.view.MenuItem
import com.klinker.android.link_builder.Link
import com.klinker.android.link_builder.applyLinks
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //implement not finished tool bar in main activity


        text_view_1.movementMethod = LinkMovementMethod.getInstance()

        //github copy/clickable link
        linkSetup()

        val button = findViewById<Button>(R.id.surpriseFactButton)
        button.setOnClickListener{
            Log.v("Hello World", "Button clicked!")
            Toast.makeText(this, R.string.caleb_fact, Toast.LENGTH_SHORT).show()
        }

        //method unsuccessful
        //declare and initialize | textview from layout file
        //val mTextView = findViewById<TextView>(R.id.text_view_1)
        //find and display content | url as hyperlink
        //mTextView.movementMethod = LinkMovementMethod.getInstance()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.app_bar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.mifact -> Toast.makeText(this, "Caleb has never eaten at Taco Bell\nHe won a Red Robin cooking competition as a child", Toast.LENGTH_SHORT).show()
            R.id.miSettings -> Toast.makeText(this, "You clicked on Settings", Toast.LENGTH_SHORT).show()
            R.id.miClose -> finish()
        }
        return true
    }
    private fun linkSetup() {
        val linkedInLink = Link("Caleb")
            .setTextColor(Color.WHITE)
            .setTextColorOfHighlightedLink(Color.WHITE)
            .setHighlightAlpha(.4f)
            .setUnderlined(true)
            .setBold(false)
            .setOnClickListener {
                Toast.makeText(this, "LinkedIn", Toast.LENGTH_SHORT).show()
            }
        text_view_1.applyLinks(linkedInLink)
    }
}