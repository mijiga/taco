package com.candybytes.taco.ui.vm

import androidx.lifecycle.ViewModel
import com.candybytes.taco.db.FoodDao

class CategoryViewModel (
    private val foodDao: FoodDao,
        ) : ViewModel() {
}