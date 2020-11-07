package com.masudin.dotindo.galeri

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout.VERTICAL
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import com.masudin.dotindo.R
import com.masudin.dotindo.adapters.GalleryAdapter
import com.masudin.dotindo.model.DataItem
import com.masudin.dotindo.model.ResponseGallery
import kotlinx.android.synthetic.main.fragment_gallery.*


class GalleryFragment : Fragment(){

    lateinit var galleryViewModel: GalleryViewModel
    lateinit var galleryAdapter: GalleryAdapter
    var galeriRecycler: MutableList<DataItem> = mutableListOf()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_gallery, container, false)

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()
        getGallery()
    }


    @SuppressLint("FragmentLiveDataObserve")
    fun getGallery() {
        val viewModel = ViewModelProviders.of(this).get(GalleryViewModel::class.java)
        viewModel.getGalleriRecycler().observe(this, Observer<ResponseGallery> {
            if (it != null) {
                galleryAdapter.notifyDataSetChanged()
                Toast.makeText(context, "$it", Toast.LENGTH_SHORT).show()

            } else {
                Toast.makeText(context, "gagal get data", Toast.LENGTH_SHORT).show()
            }
        })
        viewModel.callApi()
    }

    private fun initRecyclerView() {
        recycler_view_gallery.layoutManager = GridLayoutManager(activity, 3)
        recycler_view_gallery.apply {
            galleryAdapter = GalleryAdapter()
            adapter = galleryAdapter

            val decoration = DividerItemDecoration(context, VERTICAL)
            addItemDecoration(decoration)

        }

    }


}