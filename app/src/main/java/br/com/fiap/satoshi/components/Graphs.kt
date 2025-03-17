package br.com.fiap.satoshi.components

import CustomMarkerView
import android.graphics.Typeface
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


class Graphs {

    companion object {

        @Composable
        fun LoadingScreen(isLoading: Boolean) {
            if (isLoading) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Black.copy(alpha = 0.7f)),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(64.dp),
                        color = MaterialTheme.colorScheme.secondary,
                        trackColor = MaterialTheme.colorScheme.surfaceVariant,
                    )
                }
            }
        }

        @Composable
        fun LineGraph(modifier: Modifier, marketChart: List<List<Double>>) {
            val context = LocalContext.current
            Log.i("KALEB", "API: $marketChart")

            if (marketChart.isEmpty()) {
                Text(
                    text = "Nenhum dado disponível para o gráfico.",
                    color = Color.White,
                    fontSize = 16.sp
                )
                return
            }

            AndroidView(
                modifier = modifier
                    .fillMaxWidth()
                    .height(300.dp),
                factory = { ctx ->
                    LineChart(ctx).apply {

                        description.isEnabled = false
                        setTouchEnabled(true)
                        setPinchZoom(true)
                        setBackgroundColor(resources.getColor(R.color.secondary))
                        legend.isEnabled = false


                        xAxis.apply {
                            position = XAxis.XAxisPosition.BOTTOM
                            setDrawGridLines(false)
                            textSize = 10f
                            typeface = Typeface.DEFAULT_BOLD
                            textColor = resources.getColor(R.color.white)
                            granularity = 1f
                        }

                        val dateFormatter = SimpleDateFormat("dd/MM/YY", Locale.getDefault())
                        val formattedDates = marketChart.map { data ->
                            val timestamp = (data[0] / 1000).toLong() * 1000
                            dateFormatter.format(Date(timestamp))
                        }.toTypedArray()

                        xAxis.valueFormatter = IndexAxisValueFormatter(formattedDates)

                        axisLeft.apply {
                            setDrawGridLines(true)
                            textSize = 10f
                            typeface = Typeface.DEFAULT_BOLD
                            textColor = resources.getColor(R.color.white)
                        }

                        axisRight.isEnabled = false
                        axisLeft.gridLineWidth = 0.5f


                        // Criar as entradas do gráfico
                        val entries = marketChart.mapIndexed { index, data ->
                            Entry(index.toFloat(), data[1].toFloat())
                        }

                        // Criar o dataset da linha do gráfico
                        val dataSet = LineDataSet(entries, "Preço da Moeda").apply {
                            color = ColorTemplate.rgb("#FFFFFF")
                            setCircleColor(ColorTemplate.rgb("#F7931A"))
                            lineWidth = 1f
                            circleRadius = 2f
                            setDrawCircleHole(false)
                            setDrawValues(false)

                        }

                        // Definir os dados no gráfico
                        data = LineData(dataSet)

                        val markerView = CustomMarkerView(context, marketChart)
                        markerView.chartView = this
                        marker = markerView

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
}
