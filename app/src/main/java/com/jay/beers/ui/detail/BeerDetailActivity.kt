package com.jay.beers.ui.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.jay.beers.BR
import com.jay.beers.R
import com.jay.beers.base.BaseActivity
import com.jay.beers.databinding.ActivityBeerDetailBinding
import com.jay.beers.model.Beer
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BeerDetailActivity : BaseActivity<ActivityBeerDetailBinding, BeerDetailViewModel>(
    R.layout.activity_beer_detail,
    BeerDetailViewModel::class.java
) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupUi()
    }

    private fun setupUi() {
        val beer = intent.getParcelableExtra<Beer>(EXTRA_BEER)
        binding.setVariable(BR.item, beer)
    }

    companion object {

        private const val EXTRA_BEER = "EXTRA_BEER"

        fun getIntent(
            context: Context,
            beer: Beer,
        ) = Intent(context, BeerDetailActivity::class.java).apply {
            putExtra(EXTRA_BEER, beer)
        }

    }
}