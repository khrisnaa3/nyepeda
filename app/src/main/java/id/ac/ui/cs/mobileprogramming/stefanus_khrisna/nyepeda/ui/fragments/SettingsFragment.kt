package id.ac.ui.cs.mobileprogramming.stefanus_khrisna.nyepeda.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.provider.AlarmClock
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import id.ac.ui.cs.mobileprogramming.stefanus_khrisna.nyepeda.R
import id.ac.ui.cs.mobileprogramming.stefanus_khrisna.nyepeda.ui.viewmodels.UserViewModel
import id.ac.ui.cs.mobileprogramming.stefanus_khrisna.nyepeda.ui.viewmodels.WeightViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_settings.*
import timber.log.Timber


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

        weightViewModel = ViewModelProvider(this)[WeightViewModel::class.java]
        weightViewModel.weight.observe(viewLifecycleOwner, Observer {
            tvWeight.text = getString(R.string.weight) + " " + it.weight.toString() + " " + getString(R.string.unit)
        })

        btnAlarm.setOnClickListener {
            setAlarm()
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