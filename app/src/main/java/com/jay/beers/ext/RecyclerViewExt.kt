package com.jay.beers.ext

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

const val DEFAULT_VISIBLE_THRESHOLD = 5

@BindingAdapter("loadMore")
fun RecyclerView.bindLoadMore(
    load: () -> Unit,
) {
    addOnScrollListener(object : RecyclerView.OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)
            layoutManager?.let {
                val totalItemCount = it.itemCount
                val visibleItemCount = it.childCount
                val lastVisibleItem = (it as LinearLayoutManager).findLastVisibleItemPosition()

                if (visibleItemCount + lastVisibleItem + DEFAULT_VISIBLE_THRESHOLD >= totalItemCount) {
                    load.invoke()
                }
            }
        }
    })
}