package id.ac.ui.cs.mobileprogramming.stefanus_khrisna.nyepeda.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.ac.ui.cs.mobileprogramming.stefanus_khrisna.nyepeda.R
import id.ac.ui.cs.mobileprogramming.stefanus_khrisna.nyepeda.db.Cycle
import id.ac.ui.cs.mobileprogramming.stefanus_khrisna.nyepeda.other.TrackingUtility
import kotlinx.android.synthetic.main.item_cycle.view.*
import java.text.SimpleDateFormat
import java.util.*

class CycleAdapter : RecyclerView.Adapter<CycleAdapter.CycleViewHolder>() {

    inner class CycleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    val diffCallback = object : DiffUtil.ItemCallback<Cycle>() {
        override fun areItemsTheSame(oldItem: Cycle, newItem: Cycle): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Cycle, newItem: Cycle): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }
    }

    val differ = AsyncListDiffer(this, diffCallback)

    fun submitList(list: List<Cycle>) = differ.submitList(list)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CycleViewHolder {
        return CycleViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_cycle,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: CycleViewHolder, position: Int) {
        val cycle = differ.currentList[position]
        holder.itemView.apply {
            Glide.with(this).load(cycle.img).into(ivRunImage)

            val calender = Calendar.getInstance().apply {
                timeInMillis = cycle.timestamp
            }
            val dateFormat = SimpleDateFormat("dd.MM.yy", Locale.getDefault())
            tvDate.text = dateFormat.format(calender.time)

            val distanceInKm = "${cycle.distanceInMeters / 1000f}km"
            tvDistance.text = distanceInKm

            tvTime.text = TrackingUtility.getFormattedStopwatchTime(cycle.timeInMillis)

        }
    }
}