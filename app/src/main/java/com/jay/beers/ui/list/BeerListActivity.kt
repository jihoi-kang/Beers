package com.jay.beers.ui.list

import android.os.Bundle
import com.jay.beers.R
import com.jay.beers.base.BaseActivity
import com.jay.beers.databinding.ActivityBeerListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BeerListActivity : BaseActivity<ActivityBeerListBinding, BeerListViewModel>(
    R.layout.activity_beer_list,
    BeerListViewModel::class.java
) {

    private val beerListAdapter by lazy {
        BeerListAdapter(viewModel)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupUi()
        setupObserve()
    }

    private fun setupUi() {
        binding.rvBeerList.adapter = beerListAdapter
    }

    private fun setupObserve() {
        viewModel.beerItems.observe(this) {
            beerListAdapter.setBeerItems(it)
        }
    }
}