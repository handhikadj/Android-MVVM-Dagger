package com.example.dika.dikaapp.fragmentviews

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.dika.dikaapp.R
import com.example.dika.dikaapp.databinding.MainFragmentBinding
import com.example.dika.dikaapp.di.DaggerAppComponent
import com.example.dika.dikaapp.util.UIHelpers
import com.example.dika.dikaapp.viewmodel.MainFragmentViewModel
import javax.inject.Inject


class MainFragment : Fragment() {

    @Inject
    lateinit var uiHelpers: UIHelpers

    private val mainFragmentViewModel by lazy {
        ViewModelProviders.of(this).get(MainFragmentViewModel::class.java)
    }

    private lateinit var viewModel: MainFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: MainFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.main_fragment, container, false
        )

        DaggerAppComponent.create().inject(this)

        binding.vm = mainFragmentViewModel

        binding.lifecycleOwner = this

        mainFragmentViewModel.navigateToHome.observe(this, Observer {
            if (it) {
                findNavController().navigate(R.id.action_mainFragment_to_homeFragment)
            }
        })

        uiHelpers.closeAppIfBack(this, viewLifecycleOwner)

        return binding.root
    }
}
