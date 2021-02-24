package com.jay.beers.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.jay.beers.api.BeerService
import com.jay.beers.base.BaseViewModel
import com.jay.beers.model.Beer
import com.jay.beers.util.Event
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

    private val _openBeerDetail = MutableLiveData<Event<Beer>>()
    val openBeerDetail: LiveData<Event<Beer>> get() = _openBeerDetail

    private var isRequestInProgress = false
    private var page = 1

    init {
        load()
    }

    fun load() {
        if (isRequestInProgress) return

        viewModelScope.launch {
            isRequestInProgress = true
            showLoading()
            val beerItems = beerService.getBeers(page, DEFAULT_PER_PAGE)
            hideLoading()

            val newItems = if (page == 1) {
                beerItems.toMutableList()
            } else {
                _beerItems.value?.apply { addAll(beerItems) }
            }

            _beerItems.value = newItems ?: mutableListOf()
            isRequestInProgress = false
            page++
        }
    }

    fun openDetail(beer: Beer) {
        _openBeerDetail.value = Event(beer)
    }

    companion object {
        private const val DEFAULT_PER_PAGE = 20
    }

}