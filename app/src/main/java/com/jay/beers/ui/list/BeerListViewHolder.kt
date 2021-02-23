package com.jay.beers.ui.list

import androidx.recyclerview.widget.RecyclerView
import com.jay.beers.BR
import com.jay.beers.databinding.ItemBeerBinding
import com.jay.beers.model.Beer

class BeerListViewHolder(
    private val binding: ItemBeerBinding,
    private val vm: BeerListViewModel,
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(beer: Beer) {
        with(binding) {
            setVariable(BR.item, beer)
            setVariable(BR.viewModel, vm)
            executePendingBindings()
        }
    }

}