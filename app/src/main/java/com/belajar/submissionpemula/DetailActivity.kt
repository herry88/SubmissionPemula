package com.belajar.submissionpemula

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.belajar.submissionpemula.model.Item
import android.widget.ImageView
import android.widget.TextView


class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_ITEM = "EXTRA_ITEM"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val item = intent.getParcelableExtra<Item>(EXTRA_ITEM)

        val img: ImageView = findViewById(R.id.imgDetail)
        val tvName: TextView = findViewById(R.id.tvDetailName)
        val tvDesc: TextView = findViewById(R.id.tvDetailDesc)

        item?.let {
            img.setImageResource(it.photo)
            tvName.text = it.name
            tvDesc.text = it.longDesc
        }
    }
}