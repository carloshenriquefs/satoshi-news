import android.content.Context
import android.widget.TextView
import com.github.mikephil.charting.components.MarkerView
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.utils.MPPointF
import br.com.fiap.satoshi.R
import java.text.SimpleDateFormat
import java.util.*

class CustomMarkerView(context: Context, private val marketChart: List<List<Double>>) :
    MarkerView(context, R.layout.custom_marker) {

    private val markerPrice: TextView = findViewById(R.id.marker_price)
    private val markerDate: TextView = findViewById(R.id.marker_date)

    override fun refreshContent(e: Entry?, highlight: Highlight?) {
        e?.let {
            val index = e.x.toInt()
            if (index in marketChart.indices) {
                val timestamp = marketChart[index][0].toLong()
                val price = marketChart[index][1]

                val dateFormatter = SimpleDateFormat("dd/MM/YY", Locale.getDefault())
                val formattedDate = dateFormatter.format(Date(timestamp))
                markerPrice.text = "Price: $%.2f".format(price)
                markerDate.text = "Date: $formattedDate"
            }
        }
        super.refreshContent(e, highlight)
    }

    override fun getOffset(): MPPointF {
        return MPPointF(-width / 2f, -height.toFloat())
    }
}
