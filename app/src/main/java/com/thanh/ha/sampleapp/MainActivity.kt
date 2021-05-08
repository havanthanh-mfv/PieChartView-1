package com.thanh.ha.sampleapp

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.thanh.ha.piechart.PieChart
import com.thanh.ha.piechart.PieItem
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pieChartView = findViewById<PieChart>(R.id.pieChart)
        val pieChartView2 = findViewById<PieChart>(R.id.pieChart2)
        val pieChartView3 = findViewById<PieChart>(R.id.pieChart3)
        val pieChartView4 = findViewById<PieChart>(R.id.pieChart4)
        val fakeList = listOf(
            PieItem(20f, getColor(R.color.purple_500), "Food"),
            PieItem(40f, getColor(R.color.red), "Stuff"),
            PieItem(80f, getColor(R.color.purple_700), "Petrol"),
            PieItem(100f, getColor(R.color.teal_700), "Room"),
            PieItem(120f, getColor(R.color.purple_200), "Others\n stuff"),
        )
        val fakeList2 = listOf(
            PieItem(20f, getColor(R.color.purple_500)),
            PieItem(40f, getColor(R.color.red)),
            PieItem(80f, getColor(R.color.purple_700)),
            PieItem(100f, getColor(R.color.teal_700)),
            PieItem(120f, getColor(R.color.purple_200)
            ),
        )

        val performTestList: MutableList<PieItem> = mutableListOf()
        repeat(360) {
            performTestList.add(
                PieItem(1f, getRandomColor())
            )
        }
        pieChartView.submitList(fakeList2)
        pieChartView.animateProgress(0, 360)
        pieChartView2.submitList(fakeList)
        pieChartView2.animateProgress(0, 360)
        pieChartView3.submitList(fakeList2)
        pieChartView3.animateProgress(0, 360)
        pieChartView4.submitList(performTestList)
        pieChartView4.animateProgress(0, 360)

        findViewById<Button>(R.id.animateBtn).setOnClickListener {
            pieChartView.animateProgress(0, 180)
            pieChartView2.animateProgress(0, 180)
            pieChartView3.animateProgress(0, 180)
            pieChartView4.animateProgress(0, 180)
        }
        findViewById<Button>(R.id.animateBtn2).setOnClickListener {
            pieChartView.animateProgress(0, 360)
            pieChartView2.animateProgress(0, 360)
            pieChartView3.animateProgress(0, 360)
            pieChartView4.animateProgress(0, 360)
        }
    }

    private fun getRandomColor(): Int {
        val rnd = Random()
        val color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
        return color
    }
}