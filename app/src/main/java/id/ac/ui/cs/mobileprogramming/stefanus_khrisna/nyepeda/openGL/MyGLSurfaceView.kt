package id.ac.ui.cs.mobileprogramming.stefanus_khrisna.nyepeda.openGL

import android.content.Context
import android.opengl.GLES20
import android.opengl.GLSurfaceView
import android.opengl.Matrix
import android.os.SystemClock
import javax.microedition.khronos.egl.EGLConfig
import javax.microedition.khronos.opengles.GL10

class MyGLSurfaceView : GLSurfaceView {
    val myRenderer: MyGLRendererExample


    constructor(context: Context?): super(context) {
        setEGLContextClientVersion(2)
        myRenderer = MyGLRendererExample()
        setRenderer(myRenderer)

    }


    inner class MyGLRendererExample : GLSurfaceView.Renderer {
        private var triangle1: OpenGLShape? = null
        private val rotationMatrix = FloatArray(16)
        private val vPMatrix = FloatArray(16)
        private val viewMatrix = FloatArray(16)
        private val projectionMatrix = FloatArray(16)

        /** Equivalent to glutInit - called once to set up the view's OpenGL ES environment. */
        override fun onSurfaceCreated(unused: GL10?, config: EGLConfig?) {
            GLES20.glClearColor(1.0f, 0.5f, 0.0f, 1.0f)
            triangle1 =
                Triangle(
                    createGLESProgram()
                )
        }

        /** Same as glut's displayCallback - called for each redraw of the View obj */
        override fun onDrawFrame(unused: GL10?) {
            GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT)

            // Set the camera position (View matrix)
            Matrix.setLookAtM(viewMatrix, 0, 0f, 0f, -3f, 0f, 0f, 0f, 0f, 1.0f, 20.0f)

            // Calculate the projection and view transformation
            Matrix.multiplyMM(vPMatrix, 0, projectionMatrix, 0, viewMatrix, 0)

            val scratch = FloatArray(16)

            // Create a rotation transformation for the triangle
            val time = SystemClock.uptimeMillis() % 4000L
            val angle = 0.090f * time.toInt()
            Matrix.setRotateM(rotationMatrix, 0, angle, 0f, 0f, -1.0f)

            // Combine the rotation matrix with the projection and camera view
            // Note that the vPMatrix factor *must be first* in order
            // for the matrix multiplication product to be correct.
            Matrix.multiplyMM(scratch, 0, vPMatrix, 0, rotationMatrix, 0)

            // Draw triangle
            triangle1?.draw(scratch)

        }

        /** Same as glut's reshape callback function for when the window geometry changes
         * called when the screen is rotated, for example
         */
        override fun onSurfaceChanged(unused: GL10?, width: Int, height: Int) {
            GLES20.glViewport(0, 0, width, height)
            val ratio: Float = width.toFloat() / height.toFloat()

            // this projection matrix is applied to object coordinates
            // in the onDrawFrame() methodJNIMilisToDate
            Matrix.frustumM(projectionMatrix, 0, -ratio, ratio, -1f, 1f, 3f, 7f)
        }
    }

}
