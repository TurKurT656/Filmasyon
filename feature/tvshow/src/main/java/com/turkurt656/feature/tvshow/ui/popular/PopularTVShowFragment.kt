package com.turkurt656.feature.tvshow.ui.popular

import com.turkurt656.common.core.base.BaseFragment
import com.turkurt656.common.core.ktx.onLoadMore
import com.turkurt656.feature.tvshow.R
import com.turkurt656.feature.tvshow.databinding.PopularTvShowFragmentBinding
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class PopularTVShowFragment: BaseFragment<PopularTVShowViewModel, PopularTvShowFragmentBinding>() {

    override val viewModel: PopularTVShowViewModel by viewModel()
    private val adapter: TVShowAdapter by inject()

    override val layoutRes: Int = R.layout.popular_tv_show_fragment

    override fun everyTimeEvent() {
        configList()
    }

    private fun configList() {
        binding?.rcvPopularShows?.adapter = adapter
        binding?.rcvPopularShows?.onLoadMore { page, _ ->
            viewModel.fetchPopularShows(page)
        }
    }

    override fun hookVariables() {
        binding?.vm = viewModel
    }
}