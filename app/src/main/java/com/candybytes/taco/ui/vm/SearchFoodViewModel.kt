package com.candybytes.taco.ui.vm

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.candybytes.taco.db.FoodDao
import com.candybytes.taco.vo.Food
import timber.log.Timber

class SearchFoodViewModel @ViewModelInject constructor(
    private val foodDao: FoodDao,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    val info = liveData {
        try {
            val foods = foodDao.getAllAsync()
            emit(foods)
        } catch (e: Exception) {
            Timber.e(e)
        }
    }

    fun getByCategory(categoryID: Int): LiveData<List<Food>>{
        return liveData {
            try {
                val foods = foodDao.getCategoryFoods(categoryID)
                emit(foods)
            } catch (e: Exception) {
                Timber.e(e)
            }
        }
    }
}
