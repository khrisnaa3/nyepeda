package id.ac.ui.cs.mobileprogramming.stefanus_khrisna.nyepeda.db

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "cycling_table")
data class Cycle (
    var img: Bitmap? = null,
    var timestamp: Long = 0L,
    var distanceInMeters: Int = 0,
    var timeInMillis: Long = 0L
){
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}