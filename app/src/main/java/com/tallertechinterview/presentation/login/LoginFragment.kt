package com.tallertechinterview.presentation.login

import android.os.Bundle
import androidx.fragment.app.Fragment

import android.view.View

import androidx.navigation.fragment.findNavController
import com.tallertechinterview.R
import com.tallertechinterview.databinding.FragmentLoginBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class LoginFragment : Fragment(R.layout.fragment_login) {

    private val viewModel: LoginViewModel = LoginViewModel()
    private  var _binding: FragmentLoginBinding? = null
    val binding get() = _binding!!


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentLoginBinding.bind(view)

        viewModel.userStatus.observe(viewLifecycleOwner) { status ->
            if (status == LoginStatus.Success) {
                findNavController().navigate(R.id.mainFragment)
            }
        }
        binding.login.setOnClickListener {
            // call viewmodel
            viewModel.login(binding.username.text.toString(), binding.password.text.toString())
        }
    }

}