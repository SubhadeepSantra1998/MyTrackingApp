package com.subha.mytrackerapplication.presentation.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.subha.mytrackerapp.util.Constants.ACTION_START_OR_RESUME_SERVICE
import com.subha.mytrackerapplication.R
import com.subha.mytrackerapplication.databinding.FragmentRunBinding
import com.subha.mytrackerapplication.databinding.FragmentTrackingBinding
import com.subha.mytrackerapplication.presentation.viewModels.MainViewModel
import com.subha.mytrackerapplication.services.TrackingService
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class TrackingFragment : Fragment(R.layout.fragment_tracking) {

    private var _binding: FragmentTrackingBinding? = null
    private val binding: FragmentTrackingBinding?
        get() = _binding


    private val viewModel: MainViewModel by viewModels()

    private lateinit var mapView: MapView
    private lateinit var googleMap: GoogleMap

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentTrackingBinding.bind(view)


        setupUI()
        mapIntegration(view, savedInstanceState)
    }

    private fun setupUI() {

        binding!!.apply {
            btnToggleRun.setOnClickListener {
                sendCommandToService(ACTION_START_OR_RESUME_SERVICE)
            }
        }
    }


    private fun sendCommandToService(action: String) =
        Intent(requireContext(), TrackingService::class.java).also {
            it.action = action
            requireContext().startService(it)
        }

    private fun mapIntegration(view: View, savedInstanceState: Bundle?) {
        mapView = view.findViewById(R.id.mapView)
        mapView.onCreate(savedInstanceState)
        mapView.getMapAsync { googleMap ->
            this.googleMap = googleMap
        }
    }

    override fun onResume() {
        super.onResume()
        mapView.onResume()
    }

    override fun onStart() {
        super.onStart()
        mapView.onStart()
    }

    override fun onStop() {
        super.onStop()
        mapView.onStop()
    }

    override fun onPause() {
        super.onPause()
        mapView.onPause()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView.onLowMemory()
    }

}