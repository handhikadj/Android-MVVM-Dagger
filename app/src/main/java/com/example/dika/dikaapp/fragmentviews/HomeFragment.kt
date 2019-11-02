package com.example.dika.dikaapp.fragmentviews


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.dika.dikaapp.R
import com.example.dika.dikaapp.databinding.HomeFragmentBinding
import com.example.dika.dikaapp.viewmodel.HomeFragmentViewModel

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    private val homeFragmentViewModel by lazy {
        ViewModelProviders.of(this).get(HomeFragmentViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: HomeFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.home_fragment, container, false
        )

        binding.vm = homeFragmentViewModel

        binding.lifecycleOwner = this

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            homeFragmentViewModel.toMain()
        }

        homeFragmentViewModel.navigateToMain.observe(this, Observer {
            if (it) {
                this.findNavController().navigate(R.id.action_homeFragment_to_mainFragment)
            }
        })

        return binding.root


    }


}
