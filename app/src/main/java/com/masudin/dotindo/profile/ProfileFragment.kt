package com.masudin.dotindo.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import com.masudin.dotindo.R
import com.masudin.dotindo.model.ResponseProfile
import com.masudin.dotindo.network.Api
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ProfileFragment : Fragment() {

    lateinit var viewModel: ProfileViewModel
    lateinit var profileViewModelFactory: ProfileViewModelFactory

    companion object {
        fun newInstance() = ProfileFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val repository = ProfileRespository(Api())

        GlobalScope.launch ( Dispatchers.Main ){
            val profile = repository.getProfile()
            Toast.makeText(context, profile.toString(), Toast.LENGTH_SHORT).show()
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val api = Api()
        val respository = ProfileRespository(api)
        profileViewModelFactory = ProfileViewModelFactory(respository)
        viewModel = ViewModelProviders.of(this,profileViewModelFactory).get(ProfileViewModel::class.java)

    }
}