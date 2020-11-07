package com.masudin.dotindo.galeri

import android.view.View
import com.masudin.dotindo.model.DataItem

interface OnItemRecyclerClick {
    fun onItemClick(view : View,dataItem: DataItem)
}
