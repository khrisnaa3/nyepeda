package id.ac.ui.cs.mobileprogramming.stefanus_khrisna.nyepeda.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: User)

    @Query("SELECT * FROM user_table WHERE name='Stefanus Khrisna'")
    fun getName(): LiveData<User>
}

