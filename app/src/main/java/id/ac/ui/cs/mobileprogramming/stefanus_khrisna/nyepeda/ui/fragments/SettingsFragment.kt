package id.ac.ui.cs.mobileprogramming.stefanus_khrisna.nyepeda.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.provider.AlarmClock
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import id.ac.ui.cs.mobileprogramming.stefanus_khrisna.nyepeda.R
import id.ac.ui.cs.mobileprogramming.stefanus_khrisna.nyepeda.ui.viewmodels.UserViewModel
import id.ac.ui.cs.mobileprogramming.stefanus_khrisna.nyepeda.ui.viewmodels.WeightViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_settings.*


@AndroidEntryPoint
class SettingsFragment : Fragment(R.layout.fragment_settings) {
    private lateinit var userViewModel: UserViewModel
    private lateinit var weightViewModel: WeightViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        userViewModel = ViewModelProvider(this)[UserViewModel::class.java]
        userViewModel.name.observe(viewLifecycleOwner, Observer {
            tvName.text = it.name
        })

        btnCalc.setOnClickListener {
            if (!etWeight.text.isNullOrEmpty()) {
                val number = etWeight.text.toString().toDouble()
                tvRes.text = weightCalculation(number).toString()
            }
        }

        weightViewModel = ViewModelProvider(this)[WeightViewModel::class.java]
        weightViewModel.weight.observe(viewLifecycleOwner, Observer {
            tvWeight.text = getString(R.string.weight) + " " + it.weight.toString() + " " + getString(R.string.unit)
        })

        btnAlarm.setOnClickListener {
            setAlarm()
        }
    }

    private external fun weightCalculation(number: Double): Double

    companion object {
        init {
            System.loadLibrary("cpp_code")
        }
    }

    private fun setAlarm() {
        val hour = etHour.text.toString().toInt()
        val minute = etMinute.text.toString().toInt()

        val intent = Intent(AlarmClock.ACTION_SET_ALARM)
        intent.putExtra(AlarmClock.EXTRA_HOUR, hour)
        intent.putExtra(AlarmClock.EXTRA_MINUTES, minute)

        if (hour <= 24 && minute <= 60) activity?.startActivity(intent)
    }
}