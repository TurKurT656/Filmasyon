package com.turkurt656.feature.tvshow.ui.detail

import androidx.navigation.fragment.navArgs
import com.turkurt656.common.core.base.BaseFragment
import com.turkurt656.feature.tvshow.R
import com.turkurt656.feature.tvshow.databinding.TvShowDetailFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class TVShowDetailFragment : BaseFragment<TVShowDetailViewModel, TvShowDetailFragmentBinding>() {

    private val args: TVShowDetailFragmentArgs by navArgs()
    override val viewModel: TVShowDetailViewModel by viewModel(
        parameters = { parametersOf(args.showId) }
    )

    override val layoutRes: Int = R.layout.tv_show_detail_fragment

    override fun hookVariables() {
        binding?.vm = viewModel
    }
}