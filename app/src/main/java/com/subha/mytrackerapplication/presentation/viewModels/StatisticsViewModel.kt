package com.subha.mytrackerapplication.presentation.viewModels

import androidx.lifecycle.ViewModel
import com.subha.mytrackerapplication.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class StatisticsViewModel @Inject constructor(
    val mainRepository: MainRepository
):ViewModel() {
}