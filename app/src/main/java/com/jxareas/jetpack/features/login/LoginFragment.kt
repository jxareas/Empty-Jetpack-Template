package com.jxareas.jetpack.features.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.jxareas.jetpack.LoggedOutGraphDirections
import com.jxareas.jetpack.core.data.AuthenticationManager
import com.jxareas.jetpack.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LoginFragment : Fragment() {

    @Inject
    lateinit var authenticationManager: AuthenticationManager

    private var _binding: FragmentLoginBinding? = null
    private val binding: FragmentLoginBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListeners()
    }

    private fun setListeners() = binding.run {
        buttonAuthenticate.setOnClickListener {
            authenticationManager.saveRegistration("Jon")
            val toHomeAction =
                LoggedOutGraphDirections.loggedOutToLoggedIn(authenticationManager.getAuthenticatedUser())
            Navigation.findNavController(requireView()).navigate(toHomeAction)

        }
    }

    override fun onDestroy() {
        super.onDestroyView()
        _binding = null
    }

}