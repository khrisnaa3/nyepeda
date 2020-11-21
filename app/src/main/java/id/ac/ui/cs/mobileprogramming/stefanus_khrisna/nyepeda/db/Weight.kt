package id.ac.ui.cs.mobileprogramming.stefanus_khrisna.nyepeda.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "weight_table")
data class Weight (
    var weight: Int = 59
){
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}