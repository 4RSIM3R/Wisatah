package com.studio.suku.ngitab.view

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import coil.api.load
import com.studio.suku.ngitab.viewModel.DetailListViewModel

import com.studio.suku.wisatah.R
import kotlinx.android.synthetic.main.detail_list_fragment.*

class DetailListFragment : Fragment() {

    companion object {
        fun newInstance() = DetailListFragment()
    }

    private lateinit var viewModel: DetailListViewModel
    val args: DetailListFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.detail_list_fragment, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(DetailListViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val desc = args.detailData.nama
        my_desc.text = desc
        detail_places_image.load(args.detailData.gambar)
    }

}
