package com.example.sky.ui.sky

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.sky.databinding.FragmentSkyBinding
import com.example.sky.R
import com.example.sky.viewmodel.SkyViewModel

class SkyFragment : Fragment() {

    private lateinit var skyViewModel: SkyViewModel
    private var _binding: FragmentSkyBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        skyViewModel = ViewModelProvider(this).get(SkyViewModel::class.java)
        _binding = FragmentSkyBinding.inflate(inflater, container, false)

        binding.addSkyFabButton.setOnClickListener {
            findNavController().navigate(R.id.action_nav_sky_to_addSky2Fragment)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}