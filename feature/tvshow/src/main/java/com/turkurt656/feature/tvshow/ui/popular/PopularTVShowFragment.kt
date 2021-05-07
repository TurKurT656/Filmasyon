package com.turkurt656.feature.tvshow.ui.popular

import com.turkurt656.common.core.base.BaseFragment
import com.turkurt656.feature.tvshow.R
import com.turkurt656.feature.tvshow.databinding.PopularTvShowFragmentBinding
import org.koin.android.ext.android.inject

class PopularTVShowFragment: BaseFragment<PopularTVShowViewModel, PopularTvShowFragmentBinding>() {

    override val viewModel: PopularTVShowViewModel by inject()

    override val layoutRes: Int = R.layout.popular_tv_show_fragment

    override fun hookVariables() {
        binding?.vm = viewModel
    }
}