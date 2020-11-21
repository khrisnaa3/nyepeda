package id.ac.ui.cs.mobileprogramming.stefanus_khrisna.nyepeda.db

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface CycleDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCycle(cycle: Cycle)

    @Delete
    suspend fun deleteCycle(cycle: Cycle)

    @Query("SELECT * FROM cycling_table ORDER BY timestamp DESC")
    fun getAllCyclesSortedByDate(): LiveData<List<Cycle>>

    @Query("SELECT * FROM cycling_table ORDER BY distanceInMeters DESC")
    fun getAllCyclesSortedByDistance(): LiveData<List<Cycle>>

    @Query("SELECT SUM(timeInMillis) FROM cycling_table")
    fun getTotalTimeInMillis(): LiveData<Long>

    @Query("SELECT SUM(distanceInMeters) FROM cycling_table")
    fun getTotalDistance(): LiveData<Int>
}