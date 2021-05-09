package com.turkurt656.common.core.ba

import androidx.databinding.BindingAdapter
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup

object ChipGroupBindingAdapter {

    @BindingAdapter("binding:chips")
    @JvmStatic
    fun setChipGroupData(
        chipGroup: ChipGroup,
        data: List<String>?
    ) =
        with(chipGroup) {
            data?.forEach {
                val chip = Chip(context)
                chip.text = it
                addView(chip)
            }
        }

}