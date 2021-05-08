package com.turkurt656.feature.tvshow.ui.popular

import com.turkurt656.common.core.base.BaseAdapter
import com.turkurt656.data.domain.dto.tvshow.TVShow
import com.turkurt656.feature.tvshow.R

class TVShowAdapter : BaseAdapter<TVShow>(
    areItemsTheSame = { oldItem: TVShow, newItem: TVShow -> oldItem.id == newItem.id },
    areContentsTheSame = { oldItem: TVShow, newItem: TVShow -> oldItem == newItem }
) {

    override fun getItemViewType(position: Int): Int = R.layout.tv_show_item
}