package com.example.kotlinpeople.ui.fragment.loginFragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.kotlinpeople.DB.User
import com.example.kotlinpeople.R
import com.example.kotlinpeople.databinding.FragmentLoginBinding
import com.example.kotlinpeople.ui.Activity.DrawerActivity
import hide
import kotlinx.android.synthetic.main.fragment_login.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance
import show
import snackbar

class LoginFragment : Fragment(), KodeinAware,LoginListener
{



    override val kodein by kodein()

    private lateinit var viewModel: LoginViewModel
    private val factory: LoginViewModelFactory by instance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentLoginBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        viewModel = ViewModelProviders.of(this, factory).get(LoginViewModel::class.java)
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this
        viewModel.setListener(this)

        viewModel.getLoggedInUser().observe(this, Observer { user ->
            if(user != null){

            }
        })



        return binding.root
    }


    override fun onStarted() {
        progress_bar.show()
    }

    override fun onSuccess(user: User) {
        progress_bar.hide()
    }

    override fun onFailure(message: String) {
        progress_bar.hide()
        root_layout.snackbar(message)
    }
}
