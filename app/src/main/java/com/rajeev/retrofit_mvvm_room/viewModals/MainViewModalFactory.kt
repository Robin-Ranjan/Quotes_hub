package com.rajeev.retrofit_mvvm_room.viewModals

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rajeev.retrofit_mvvm_room.repo.QuoteRepo

class MainViewModalFactory(private val repository: QuoteRepo) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return  MainViewModal(repository) as T
    }

}