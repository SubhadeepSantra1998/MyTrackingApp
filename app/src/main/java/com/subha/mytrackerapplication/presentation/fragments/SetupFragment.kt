package com.subha.mytrackerapplication.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.subha.mytrackerapplication.R
import com.subha.mytrackerapplication.databinding.FragmentSetupBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class SetupFragment : Fragment(R.layout.fragment_setup) {

    private var _binding: FragmentSetupBinding? = null
    private val binding: FragmentSetupBinding?
        get() = _binding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentSetupBinding.bind(view)

        setUI()
    }

    private fun setUI() {
        binding!!.apply {
            tvContinue.setOnClickListener {
                findNavController().navigate(R.id.action_setupFragment_to_runFragment)
            }
        }
    }

}