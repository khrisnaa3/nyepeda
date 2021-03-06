package id.ac.ui.cs.mobileprogramming.stefanus_khrisna.nyepeda.ui.fragments

import android.Manifest
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import id.ac.ui.cs.mobileprogramming.stefanus_khrisna.nyepeda.R
import id.ac.ui.cs.mobileprogramming.stefanus_khrisna.nyepeda.other.Constants.REQUEST_CODE_LOCATION_PERMISSION
import id.ac.ui.cs.mobileprogramming.stefanus_khrisna.nyepeda.other.TrackingUtility
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_cycle.*
import pub.devrel.easypermissions.AppSettingsDialog
import pub.devrel.easypermissions.EasyPermissions

@AndroidEntryPoint
class CycleFragment : Fragment(R.layout.fragment_cycle), EasyPermissions.PermissionCallbacks {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requestPermissions()

        fab.setOnClickListener {
            findNavController().navigate(R.id.action_cycleFragment_to_trackingFragment)
        }
    }

    private fun requestPermissions() {
        if(TrackingUtility.hasLocationPermissions(requireContext())){
            return
        }
        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.Q) {
            EasyPermissions.requestPermissions(
                this,
                "You need to accept location permissions to use this app.",
                REQUEST_CODE_LOCATION_PERMISSION,
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION
            )
        } else {
            EasyPermissions.requestPermissions(
                this,
                "You need to accept location permissions to use this app.",
                REQUEST_CODE_LOCATION_PERMISSION,
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_BACKGROUND_LOCATION
            )
        }
    }

    override fun onPermissionsDenied(requestCode: Int, perms: MutableList<String>) {
        if (EasyPermissions.somePermissionPermanentlyDenied(this, perms)) {
            findNavController().navigate(R.id.action_cycleFragment_to_noPermissionFragment)
            AppSettingsDialog.Builder(this).build().show()
        } else {
            findNavController().navigate(R.id.action_cycleFragment_to_noPermissionFragment)
            requestPermissions()
        }
    }

    override fun onPermissionsGranted(requestCode: Int, perms: MutableList<String>) {}

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this)
    }
}