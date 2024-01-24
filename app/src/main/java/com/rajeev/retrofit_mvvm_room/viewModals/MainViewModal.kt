package com.rajeev.retrofit_mvvm_room.viewModals

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rajeev.retrofit_mvvm_room.modal.QuoteList
import com.rajeev.retrofit_mvvm_room.repo.QuoteRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModal(private val repo: QuoteRepo):ViewModel() {
    private var index =0
    init {
        viewModelScope.launch {
            Dispatchers.IO
            repo.getQuotes(1)
        }
    }

    val quotesLivedata: LiveData<QuoteList>
        get() = repo.quotes

}