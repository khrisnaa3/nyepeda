package id.ac.ui.cs.mobileprogramming.stefanus_khrisna.nyepeda.ui.fragments

import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import id.ac.ui.cs.mobileprogramming.stefanus_khrisna.nyepeda.R
import id.ac.ui.cs.mobileprogramming.stefanus_khrisna.nyepeda.receiver.InternetBroadcastReceiver
import kotlinx.android.synthetic.main.fragment_setup.*

class SetupFragment : Fragment(R.layout.fragment_setup) {
    lateinit var internetBroadcastReceiver: InternetBroadcastReceiver

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        internetBroadcastReceiver = InternetBroadcastReceiver(arrayOf(tvWelcome, tvContinue))

        val filter = IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
        activity?.registerReceiver(internetBroadcastReceiver, filter)

        tvContinue.setOnClickListener {
            findNavController().navigate(R.id.action_setupFragment_to_cycleFragment)
        }
    }

}