package com.example.sky.ui.sky

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.sky.databinding.FragmentAddSkyBinding
import com.example.sky.R
import com.example.sky.model.Sky
import com.example.sky.viewmodel.SkyViewModel

class AddSkyFragment : Fragment() {
    private var _binding: FragmentAddSkyBinding? = null
    private val binding get() = _binding!!

    private lateinit var skyViewModel: SkyViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        saveInstanceState: Bundle?
    ) : View {
        _binding = FragmentAddSkyBinding.inflate(inflater, container, false)

        skyViewModel = ViewModelProvider(this).get(SkyViewModel::class.java)

        binding.submitBtn.setOnClickListener { addSky() }

        return binding.root
    }

    private fun addSky() {
        val nombre = binding.skyName.text.toString()

        if(validation(nombre)) {
            val sky = Sky(0, nombre)
            skyViewModel.addSky(sky)
            Toast.makeText(requireContext(), getString(R.string.msg_sky_added), Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(requireContext(), getString(R.string.msg_error), Toast.LENGTH_LONG).show()
        }
    }

    private fun validation (nombre: String): Boolean {
            return !(nombre.isEmpty())
    }
}
