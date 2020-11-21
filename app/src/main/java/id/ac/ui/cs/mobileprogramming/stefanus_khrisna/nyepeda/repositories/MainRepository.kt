package id.ac.ui.cs.mobileprogramming.stefanus_khrisna.nyepeda.repositories

import id.ac.ui.cs.mobileprogramming.stefanus_khrisna.nyepeda.db.Cycle
import id.ac.ui.cs.mobileprogramming.stefanus_khrisna.nyepeda.db.CycleDAO
import id.ac.ui.cs.mobileprogramming.stefanus_khrisna.nyepeda.db.UserDAO
import id.ac.ui.cs.mobileprogramming.stefanus_khrisna.nyepeda.db.WeightDAO
import javax.inject.Inject

class MainRepository @Inject constructor(
    val cycleDAO: CycleDAO,
    val userDAO: UserDAO,
    val weightDAO: WeightDAO
) {
    suspend fun insertCycle(cycle: Cycle) = cycleDAO.insertCycle(cycle)

    suspend fun deleteCycle(cycle: Cycle) = cycleDAO.deleteCycle(cycle)

    fun getAllCyclesSortedByDate() = cycleDAO.getAllCyclesSortedByDate()

    fun getAllCyclesSortedByDistance() = cycleDAO.getAllCyclesSortedByDistance()

    fun getTotalTimeInMillis() = cycleDAO.getTotalTimeInMillis()

    fun getTotalDistance() = cycleDAO.getTotalDistance()

    fun getName() = userDAO.getName()

    fun getWeight() = weightDAO.getWeight()
}