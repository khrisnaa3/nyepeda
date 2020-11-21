package id.ac.ui.cs.mobileprogramming.stefanus_khrisna.nyepeda.ui.viewmodels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.ac.ui.cs.mobileprogramming.stefanus_khrisna.nyepeda.db.User
import id.ac.ui.cs.mobileprogramming.stefanus_khrisna.nyepeda.db.Weight
import id.ac.ui.cs.mobileprogramming.stefanus_khrisna.nyepeda.repositories.MainRepository

class WeightViewModel @ViewModelInject constructor(
    val mainRepository: MainRepository
): ViewModel() {
    private val userName = mainRepository.getName()

    val weight = MutableLiveData<Weight>()

    init {
        weight.value = Weight()
    }
}