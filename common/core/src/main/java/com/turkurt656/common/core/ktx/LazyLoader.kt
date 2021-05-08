package com.turkurt656.common.core.ktx

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

abstract class LazyLoader(
    private val layoutManager: RecyclerView.LayoutManager,
    // The minimum amount of items to have below your current scroll position before loading more.
    private var visibleThreshold: Int = 5,
    // Sets the starting page index
    private val startingPageIndex: Int = 1
) : RecyclerView.OnScrollListener() {

    // The current offset index of data you have loaded
    private var currentPage = startingPageIndex

    // The total number of items in the dataSet after the last load
    private var previousTotalItemCount = 0

    // True if we are still waiting for the last set of data to load.
    private var loading = true

    init {
        visibleThreshold *= when (layoutManager) {
            is LinearLayoutManager -> 1
            is GridLayoutManager -> layoutManager.spanCount
            is StaggeredGridLayoutManager -> layoutManager.spanCount
            else -> throw Exception("Unsupported LayoutManager")
        }
    }

    fun getLastVisibleItem(lastVisibleItemPositions: IntArray): Int {
        var maxSize = 0
        for (i in lastVisibleItemPositions.indices) {
            if (i == 0) {
                maxSize = lastVisibleItemPositions[i]
            } else if (lastVisibleItemPositions[i] > maxSize) {
                maxSize = lastVisibleItemPositions[i]
            }
        }
        return maxSize
    }

    // This happens many times a second during a scroll, so be wary of the code you place here.
    // We are given a few useful parameters to help us work out if we need to load some more data,
    // but first we check if we are waiting for the previous load to finish.
    override fun onScrolled(view: RecyclerView, dx: Int, dy: Int) {
        val totalItemCount: Int = layoutManager.itemCount
        val lastVisibleItemPosition = when (layoutManager) {
            is StaggeredGridLayoutManager -> {
                val lastVisibleItemPositions: IntArray =
                    layoutManager.findLastVisibleItemPositions(null)
                // get maximum element within the list
                getLastVisibleItem(lastVisibleItemPositions)
            }
            is GridLayoutManager ->
                layoutManager.findLastVisibleItemPosition()
            is LinearLayoutManager ->
                layoutManager.findLastVisibleItemPosition()
            else ->
                throw Exception("Unsupported LayoutManager")
        }

        // If the total item count is zero and the previous isn't, assume the
        // list is invalidated and should be reset back to initial state
        if (totalItemCount < previousTotalItemCount) {
            currentPage = startingPageIndex
            previousTotalItemCount = totalItemCount
            if (totalItemCount == 0) loading = true
        }
        // If it’s still loading, we check to see if the dataSet count has
        // changed, if so we conclude it has finished loading and update the current page
        // number and total item count.
        if (loading && totalItemCount > previousTotalItemCount) {
            loading = false
            previousTotalItemCount = totalItemCount
        }

        // If it isn’t currently loading, we check to see if we have breached
        // the visibleThreshold and need to reload more data.
        // If we do need to reload some more data, we execute onLoadMore to fetch the data.
        // threshold should reflect how many total columns there are too
        if (!loading && lastVisibleItemPosition + visibleThreshold > totalItemCount) {
            currentPage++
            onLoadMore(currentPage, totalItemCount)
            loading = true
        }
    }

    // Call this method whenever performing new searches
    fun resetState() {
        currentPage = startingPageIndex
        previousTotalItemCount = 0
        loading = true
    }

    // Defines the process for actually loading more data based on page
    abstract fun onLoadMore(page: Int, totalItemsCount: Int)
}

fun RecyclerView.onLoadMore(
    visibleThreshold: Int = 5,
    startingPageIndex: Int = 1,
    block: (page: Int, totalItemsCount: Int) -> Unit
): RecyclerView.OnScrollListener =
    layoutManager?.let {
        val lazyLoader: RecyclerView.OnScrollListener =
            object : LazyLoader(it, visibleThreshold, startingPageIndex) {
                override fun onLoadMore(page: Int, totalItemsCount: Int) {
                    block(page, totalItemsCount)
                }
            }
        addOnScrollListener(lazyLoader)
        block(1, 0)
        lazyLoader
    } ?: throw Exception("add layoutManager before using this method")