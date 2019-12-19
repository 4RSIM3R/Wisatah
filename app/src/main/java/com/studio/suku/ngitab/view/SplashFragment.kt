package com.studio.suku.ngitab.view

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide

import com.studio.suku.wisatah.R
import com.studio.suku.ngitab.viewModel.SplashViewModel
import kotlinx.android.synthetic.main.splash_fragment.*
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class SplashFragment : Fragment(), CoroutineScope {


    companion object {
        fun newInstance() = SplashFragment()
    }

    private lateinit var viewModel: SplashViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.splash_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(SplashViewModel::class.java)
        Glide.with(this).load(R.drawable.dot).into(image_logo)
        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        launch {
            delay(3000)
            withContext(Dispatchers.Main){
                this@SplashFragment.findNavController().navigate(R.id.loginFragment)
            }
        }
    }

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + Job()


}
