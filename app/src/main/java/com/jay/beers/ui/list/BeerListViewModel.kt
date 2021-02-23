package com.jay.beers.ui.list

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.jay.beers.api.BeerService
import com.jay.beers.base.BaseViewModel
import com.jay.beers.model.Beer
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BeerListViewModel @Inject constructor(
    private val beerService: BeerService,
) : BaseViewModel() {

    private val TAG = this::class.java.simpleName

    private val _beerItems = MutableLiveData<MutableList<Beer>>(mutableListOf())
    val beerItems: LiveData<MutableList<Beer>> get() = _beerItems

    init {
        viewModelScope.launch {
            val beerItems = beerService.getBeers(1, 30)
            _beerItems.value = beerItems
        }
    }

    fun openDetail(beer: Beer) {
        Log.e(TAG, "beer: ${beer.name}")
    }

}