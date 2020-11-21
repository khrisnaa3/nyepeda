package id.ac.ui.cs.mobileprogramming.stefanus_khrisna.nyepeda.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class User(
    var name: String = "Stefanus Khrisna"
){
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}