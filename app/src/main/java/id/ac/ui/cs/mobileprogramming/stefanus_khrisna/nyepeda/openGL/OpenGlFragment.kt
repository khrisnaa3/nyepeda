package id.ac.ui.cs.mobileprogramming.stefanus_khrisna.nyepeda.openGL

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import id.ac.ui.cs.mobileprogramming.stefanus_khrisna.nyepeda.openGL.MyGLSurfaceView
import id.ac.ui.cs.mobileprogramming.stefanus_khrisna.nyepeda.R

class OpenGlFragment : Fragment(R.layout.fragment_open_gl) {
    private var myGLView: MyGLSurfaceView? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Create a GLSurfaceView instance and
        myGLView = MyGLSurfaceView(context)

        return myGLView
    }

}