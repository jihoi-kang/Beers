package com.jay.beers.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.jay.beers.R
import com.jay.beers.databinding.ItemBeerBinding
import com.jay.beers.model.Beer

class BeerListAdapter(
    private val viewModel: BeerListViewModel,
) : RecyclerView.Adapter<BeerListViewHolder>() {

    private val beerItems = mutableListOf<Beer>()

    fun setBeerItems(beerItems: List<Beer>) {
        this.beerItems.clear()
        this.beerItems.addAll(beerItems)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeerListViewHolder {
        val binding = DataBindingUtil.inflate<ItemBeerBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_beer,
            parent,
            false
        )
        return BeerListViewHolder(binding, viewModel)
    }

    override fun onBindViewHolder(holder: BeerListViewHolder, position: Int) {
        holder.bind(beerItems[position])
    }

    override fun getItemCount(): Int = beerItems.size

}