package com.belajar.submissionpemula

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.belajar.submissionpemula.adapter.ListItemAdapter
import com.belajar.submissionpemula.model.Item
import com.belajar.submissionpemula.model.ItemData
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_ITEM = "EXTRA_ITEM"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 🔹 RecyclerView Setup
        val rvItems: RecyclerView = findViewById(R.id.rvItems)
        rvItems.layoutManager = LinearLayoutManager(this)

        val adapter = ListItemAdapter(ItemData.listItem) { item: Item ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra(EXTRA_ITEM, item)
            startActivity(intent)
        }

        rvItems.adapter = adapter

        // 🔹 Bottom Navigation Setup
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavigation)

        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> true

                R.id.about_page -> {
                    startActivity(Intent(this, AboutActivity::class.java))
                    true
                }

                else -> false
            }
        }
    }
}

