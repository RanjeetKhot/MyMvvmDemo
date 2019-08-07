package com.example.kotlinpeople.UI.Fragment.LoginFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.kotlinpeople.R
import com.example.kotlinpeople.databinding.FragmentLoginBinding
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance

class LoginFragment : Fragment(), KodeinAware, LoginListener {


    override val kodein by kodein()
    lateinit var mViewModel: LoginViewModel
    val factory: LoginViewModelFactory by instance()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

      /*  mViewModel = ViewModelProviders.of(this, factory).get(LoginViewModel::class.java)

        val binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
                as FragmentLoginBinding
      *//*  val bind = DataBindingUtil
            .setContentView<FragmentLoginBinding>(activity!!, R.layout.fragment_login)*//*
        binding.viewmodel = mViewModel
        binding.lifecycleOwner = this
        return binding.root*/

        val view = inflater.inflate(R.layout.fragment_login, container, false)


        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


    }
    override fun onStarted() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSuccess(message: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onFailure(message: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
