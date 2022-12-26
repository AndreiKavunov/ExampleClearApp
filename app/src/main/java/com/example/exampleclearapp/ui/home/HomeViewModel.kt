package com.example.exampleclearapp.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.exampleclearapp.data.ContentRepository
import com.example.exampleclearapp.data.dto.HorizontalCard
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    val contentRepository = ContentRepository()
    
    private var _hc = MutableLiveData<List<HorizontalCard>>()

    var hc: LiveData<List<HorizontalCard>> = _hc

    fun getHorizontalCards(){
        viewModelScope.launch {
            val result = kotlin.runCatching {
//                return@runCatching contentRepository.getHorizontalCards()
              contentRepository.getHorizontalCards()
            }
            result
                .onSuccess {
                    _hc.postValue(it)
                }.onFailure{
                    Log.d("tag1", "Ex ${it.message}")
                }
        }
    }

}

