package id.ac.ui.cs.mobileprogramming.stefanus_khrisna.nyepeda.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters


@Database(
    entities = [User::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class UserDatabase : RoomDatabase() {
    abstract fun getUserDao(): UserDAO
}