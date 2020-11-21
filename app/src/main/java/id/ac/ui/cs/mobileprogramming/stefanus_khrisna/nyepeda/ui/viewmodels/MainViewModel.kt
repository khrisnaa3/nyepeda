package id.ac.ui.cs.mobileprogramming.stefanus_khrisna.nyepeda.ui.viewmodels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.ac.ui.cs.mobileprogramming.stefanus_khrisna.nyepeda.db.Cycle
import id.ac.ui.cs.mobileprogramming.stefanus_khrisna.nyepeda.other.SortType
import id.ac.ui.cs.mobileprogramming.stefanus_khrisna.nyepeda.repositories.MainRepository
import kotlinx.coroutines.launch

class MainViewModel @ViewModelInject constructor(
    val mainRepository: MainRepository
): ViewModel() {

    private val cyclesSortedByDate = mainRepository.getAllCyclesSortedByDate()
    private val cyclesSortedByDistance = mainRepository.getAllCyclesSortedByDistance()

    val cycles = MediatorLiveData<List<Cycle>>()

    var sortType = SortType.DATE

    init {
        cycles.addSource(cyclesSortedByDate) { result ->
            if(sortType == SortType.DATE) {
                result?.let { cycles.value = it }
            }
        }

        cycles.addSource(cyclesSortedByDistance) { result ->
            if(sortType == SortType.DISTANCE) {
                result?.let { cycles.value = it }
            }
        }
    }

    fun sortCycles(sortType: SortType) = when(sortType) {
        SortType.DATE -> cyclesSortedByDate.value?.let { cycles.value = it }
        SortType.DISTANCE -> cyclesSortedByDistance.value?.let { cycles.value = it }
    }.also {
        this.sortType = sortType
    }

    fun insertCycle(cycle: Cycle) = viewModelScope.launch {
        mainRepository.insertCycle(cycle)
    }
}