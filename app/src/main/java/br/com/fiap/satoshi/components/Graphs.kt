package br.com.fiap.satoshi.components

import android.graphics.Typeface
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import br.com.fiap.satoshi.R
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.github.mikephil.charting.utils.ColorTemplate


class Graphs {

    companion object {

        @Composable
        fun ProgressBar(
            title: String,
            progress: Float,
            modifier: Modifier = Modifier,
            showPercent: Boolean = true
        ) {
            Column(
                modifier = modifier.padding(8.dp)
            ) {

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        title,
                        color = Color.White,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                    if (showPercent) {
                        Text(
                            "${(progress * 100).toInt()}%",
                            color = Color.White,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

                Canvas(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(10.dp)
                ) {
                    val barWidth = size.width
                    val barHeight = size.height

                    drawRoundRect(
                        color = Color(0xFF22252B),
                        size = size,
                        cornerRadius = CornerRadius(barHeight / 2)
                    )

                    drawRoundRect(
                        color = Color(0xFF4378FF),
                        size = size.copy(width = barWidth * progress),
                        cornerRadius = CornerRadius(barHeight / 2)
                    )
                }
            }


        }

        @Composable
        fun CircularProgressBar(
            progress: Float,
            modifier: Modifier = Modifier.size(150.dp),
            strokeWidth: Float = 16f,
            showPercent: Boolean = true
        ) {
            Box(contentAlignment = androidx.compose.ui.Alignment.Center) {
                Canvas(modifier = modifier) {
                    val size = size.minDimension
                    val stroke = Stroke(width = strokeWidth, cap = StrokeCap.Round)

                    drawArc(
                        color = Color(0xFF22252B),
                        startAngle = 135f,
                        sweepAngle = 270f,
                        useCenter = false,
                        topLeft = Offset(strokeWidth / 2, strokeWidth / 2),
                        size = Size(size - strokeWidth, size - strokeWidth),
                        style = stroke
                    )

                    drawArc(
                        color = Color(0xFF4378FF),
                        startAngle = 135f,
                        sweepAngle = 270f * progress,
                        useCenter = false,
                        topLeft = Offset(strokeWidth / 2, strokeWidth / 2),
                        size = Size(size - strokeWidth, size - strokeWidth),
                        style = stroke
                    )
                }
                if (showPercent) {
                    Text(
                        text = "${(progress * 100).toInt()}%",
                        fontSize = 36.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }
            }
        }

        @Composable
        fun LineGraph(modifier: Modifier) {
            val context = LocalContext.current

            AndroidView(
                modifier = modifier
                    .fillMaxWidth()
                    .height(300.dp),
                factory = { ctx ->
                    LineChart(ctx).apply {
                        description.isEnabled = false
                        setTouchEnabled(true)
//                        setVisibleXRangeMaximum(30f)
//                        moveViewToX(20f)
//                        scrollX = 50
                        setPinchZoom(true)
                        setBackgroundColor(resources.getColor(R.color.secondary))
                        legend.isEnabled = false


                        xAxis.apply {
                            position = XAxis.XAxisPosition.BOTTOM
                            setDrawGridLines(false)
                            textSize = 10f
                            typeface = Typeface.DEFAULT_BOLD
                            textColor = resources.getColor(R.color.white)
                        }

                        xAxis.valueFormatter = IndexAxisValueFormatter(
                            arrayOf(
                                "JAN",
                                "FEB",
                                "MAR",
                                "APR",
                                "MAY",
                                "JUN",

                            )
                        )
                        xAxis.granularity = 1f


                        axisLeft.apply {
                            setDrawGridLines(true)
                            textSize = 10f
                            typeface = Typeface.DEFAULT_BOLD
                            textColor = resources.getColor(R.color.white)
                        }

                        axisRight.isEnabled = false
                        axisLeft.gridLineWidth = 0.5f

                        val entries1 = listOf(
                            Entry(0f, 500f),
                            Entry(1f, 450f),
                            Entry(2f, 300f),
                            Entry(3f, 200f),
                            Entry(4f, 100f),
                            Entry(5f, 50f),
                            Entry(6f, 50f),
                            Entry(7f, 50f),
                            Entry(8f, 50f),
                            Entry(9f, 50f),
                            Entry(10f, 50f),
                            Entry(11f, 50f)

                        )

                        val entries2 = listOf(
                            Entry(0f, 50f),
                            Entry(1f, 200f),
                            Entry(2f, 500f),
                            Entry(3f, 250f),
                            Entry(4f, 400f),
                            Entry(5f, 750f)
                        )

                        val entries3 = listOf(
                            Entry(0f, 20f),
                            Entry(1f, 100f),
                            Entry(2f, 400f),
                            Entry(3f, 750f),
                            Entry(4f, 300f),
                            Entry(5f, 700f)
                        )

                        val dataSet1 = LineDataSet(entries1, "Azul").apply {
                            color = ColorTemplate.COLORFUL_COLORS[0]
                            setCircleColor(ColorTemplate.COLORFUL_COLORS[0])
                            lineWidth = 2f
                            circleRadius = 4f
                            setDrawCircleHole(false)
                            setDrawValues(false)
                        }

                        val dataSet2 = LineDataSet(entries2, "Vermelho").apply {
                            color = ColorTemplate.COLORFUL_COLORS[2]
                            setCircleColor(ColorTemplate.COLORFUL_COLORS[2])
                            lineWidth = 2f
                            circleRadius = 4f
                            setDrawCircleHole(false)
                            setDrawValues(false)
                        }

                        val dataSet3 = LineDataSet(entries3, "Verde").apply {
                            color = ColorTemplate.COLORFUL_COLORS[3]
                            setCircleColor(ColorTemplate.COLORFUL_COLORS[3])
                            lineWidth = 2f
                            circleRadius = 4f
                            setDrawCircleHole(false)
                            setDrawValues(false)
                        }

                        data = LineData(dataSet1, dataSet2, dataSet3)
                        invalidate()
                    }
                }
            )
        }

        @Composable
        fun MiniLineGraph() {
            val context = LocalContext.current

            Card(
                modifier = Modifier
                    .size(100.dp, 80.dp),
                colors = CardDefaults.cardColors(containerColor = colorResource(R.color.secondary))


            ) {
                Column(
                    modifier = Modifier.padding(8.dp),
                    verticalArrangement = Arrangement.Center
                ) {

                    Text(
                        text = "2,476",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                    Text(
                        text = "Category Label",
                        color = Color.LightGray,
                        fontSize = 10.sp
                    )


                    AndroidView(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(40.dp),
                        factory = { ctx ->
                            LineChart(ctx).apply {
                                setTouchEnabled(false)
                                setViewPortOffsets(0f, 0f, 0f, 0f)

                                axisLeft.isEnabled = false
                                axisRight.isEnabled = false
                                xAxis.isEnabled = false
                                description.isEnabled = false
                                legend.isEnabled = false


                                val entries = listOf(
                                    Entry(0f, 20f), Entry(1f, 50f), Entry(2f, 30f),
                                    Entry(3f, 70f), Entry(4f, 40f), Entry(5f, 60f)
                                )

                                val dataSet = LineDataSet(entries, "").apply {
                                    color = resources.getColor(R.color.ligth_blue)
                                    lineWidth = 1f
                                    setDrawCircles(false)
                                    setDrawFilled(true)
                                    mode = LineDataSet.Mode.CUBIC_BEZIER
                                    fillDrawable =
                                        ContextCompat.getDrawable(ctx, R.drawable.chart_gradient)
                                    setDrawValues(false)
                                }

                                data = LineData(dataSet)
                                invalidate()
                            }
                        }
                    )
                }
            }
        }
    }

    @Preview(showSystemUi = true)
    @Composable
    private fun GraphsPreview() {

        MiniLineGraph()
    }
}

