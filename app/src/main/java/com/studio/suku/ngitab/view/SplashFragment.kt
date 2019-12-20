package com.studio.suku.ngitab.view

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide

import com.studio.suku.wisatah.R
import com.studio.suku.ngitab.viewModel.SplashViewModel
import kotlinx.android.synthetic.main.splash_fragment.*
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class SplashFragment : Fragment(){


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
        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lottie_logo.playAnimation()
        lottie_logo.speed = 2f
        lottie_logo.addAnimatorUpdateListener {valueAnimator ->
            val progress = (valueAnimator.animatedValue as Float * 100).toInt()
            Log.d("Datanya", progress.toString())
            if (progress == 98)
                this@SplashFragment.findNavController().navigate(R.id.loginFragment)
        }
//        launch {
//            delay((lottie_logo.speed * 1000).toLong())
//            withContext(Dispatchers.Main){
//                Log.d("Datanya", "Selesai")
//                this@SplashFragment.findNavController().navigate(R.id.loginFragment)
//            }
//        }
    }

//    override val coroutineContext: CoroutineContext
//        get() = Dispatchers.Main + Job()


}
