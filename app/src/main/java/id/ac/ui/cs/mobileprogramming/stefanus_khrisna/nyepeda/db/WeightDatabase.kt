package id.ac.ui.cs.mobileprogramming.stefanus_khrisna.nyepeda.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters


@Database(
    entities = [Weight::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class WeightDatabase : RoomDatabase() {
    abstract fun getWeightDao(): WeightDAO
}