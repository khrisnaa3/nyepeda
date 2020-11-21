package id.ac.ui.cs.mobileprogramming.stefanus_khrisna.nyepeda.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface WeightDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWeight(weight: Weight)

    @Query("SELECT * FROM weight_table WHERE weight=59")
    fun getWeight(): LiveData<Weight>
}