package com.valentun.learn.lessonrecyclerview

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val data = generateData()

    private fun generateData(): List<String> = (1..100).map { "Item $it" }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        list.setHasFixedSize(true)
//        list.layoutManager = LinearLayoutManager(this)

        list.adapter = StringAdapter(data)

    }
}
