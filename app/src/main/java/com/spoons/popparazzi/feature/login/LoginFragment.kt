package com.spoons.popparazzi.feature.login

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.spoons.popparazzi.NavAppDirections
import com.spoons.popparazzi.core.ui.base.fragment.BaseBindFragment
import com.spoons.popparazzi.databinding.FragmentLoginBinding

class LoginFragment: BaseBindFragment<FragmentLoginBinding>(FragmentLoginBinding::inflate) {
    private val viewModel: LoginViewModel by viewModels()

    override fun bindUi() {
        super.bindUi()
        viewModel // viewModel 초기화 시점
    }

    override fun regListener() {
        super.regListener()
        binding.btnLogin.setOnClickListener {
            findNavController().navigate(NavAppDirections.toMainContainer())
        }
    }
}