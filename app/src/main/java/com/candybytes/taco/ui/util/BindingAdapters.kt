package com.candybytes.taco.ui.util

import android.view.View
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

@BindingAdapter("goneUnless")
fun goneUnless(view: View?, visible: Boolean?) {
    view?.visibility = if (visible == true) View.VISIBLE else View.GONE
}

@BindingAdapter("setAdapter")
fun RecyclerView.bindRecyclerViewAdapter(adapter: RecyclerView.Adapter<*>){
    this.run {
        this.setHasFixedSize(true)
        this.adapter = adapter
    }
}
