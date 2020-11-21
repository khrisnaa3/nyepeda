package id.ac.ui.cs.mobileprogramming.stefanus_khrisna.nyepeda.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.view.View
import android.widget.TextView

class InternetBroadcastReceiver(var tv: Array<TextView>): BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {

        if (ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.action)) {
            val noConnectivity = intent.getBooleanExtra(
                ConnectivityManager.EXTRA_NO_CONNECTIVITY, false
            )
            if (noConnectivity) {
                tv[0].text = "DISCONNECTED"
                tv[1].visibility = View.GONE
            } else {
                tv[0].text = "CONNECTED"
                tv[1].visibility = View.VISIBLE
            }
        }
    }
}