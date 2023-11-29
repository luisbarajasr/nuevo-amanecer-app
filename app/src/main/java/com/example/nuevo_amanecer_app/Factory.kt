package com.example.nuevo_amanecer_app

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.room__compose.viewModel.vm


class Factory (private val application: Application ) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(vm::class.java)) {
            // Use the provided application instance here
            return vm(application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}