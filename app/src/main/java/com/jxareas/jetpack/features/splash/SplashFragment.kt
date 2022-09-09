package com.jxareas.jetpack.features.splash

import android.os.Handler
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.jxareas.jetpack.R
import com.jxareas.jetpack.SplashGraphDirections
import com.jxareas.jetpack.core.data.AuthenticationManager
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SplashFragment :  Fragment(R.layout.fragment_splash) {
    @Inject
    lateinit var authenticationManager: AuthenticationManager

    private val handler = Handler()

    private val finishSplash: Runnable = Runnable {
        if (authenticationManager.isAuthenticated()) {
            Navigation.findNavController(requireView())
                .navigate(SplashGraphDirections.splashToLoggedIn(authenticationManager.getAuthenticatedUser()))
        } else {
            Navigation.findNavController(requireView()).navigate(R.id.splash_to_logged_out)
        }
    }

    override fun onStart() {
        super.onStart()
        handler.postDelayed(finishSplash, 1L)
    }

    override fun onStop() {
        handler.removeCallbacks(finishSplash)
        super.onStop()
    }
}