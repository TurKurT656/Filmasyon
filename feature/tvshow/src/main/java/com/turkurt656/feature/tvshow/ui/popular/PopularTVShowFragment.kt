package com.turkurt656.feature.tvshow.ui.popular

import android.view.View
import com.turkurt656.common.core.base.BaseFragment
import com.turkurt656.common.core.ktx.onLoadMore
import com.turkurt656.data.domain.dto.tvshow.TVShow
import com.turkurt656.feature.tvshow.R
import com.turkurt656.feature.tvshow.databinding.PopularTvShowFragmentBinding
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class PopularTVShowFragment : BaseFragment<PopularTVShowViewModel, PopularTvShowFragmentBinding>() {

    override val viewModel: PopularTVShowViewModel by viewModel()
    private val adapter: TVShowAdapter by inject()

    override val layoutRes: Int = R.layout.popular_tv_show_fragment

    private var cachedPage = 1

    override fun everyTimeEvent() {
        configList()
    }

    private fun configList() {
        binding?.rcvPopularShows?.adapter = adapter
        adapter.onItemClicked = { item: TVShow, _: View ->
            viewModel.navigateToDetail(item)
        }
        binding?.rcvPopularShows?.onLoadMore(startingPageIndex = cachedPage) { page, _ ->
            viewModel.fetchPopularShows(page)
            cachedPage = page
        }
    }

    override fun hookVariables() {
        binding?.vm = viewModel
    }
}