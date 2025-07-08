package com.example.homeworke

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {
    private val _items = MutableLiveData<MutableList<Item>>(mutableListOf())
    val items: LiveData<MutableList<Item>> = _items

    fun addItem(item: Item) {
    val currentList = _items.value ?: mutableListOf()
        val secondList= _items.value?: mutableListOf()
    currentList.add(item)
        secondList.add(item)
    _items.value = currentList
    }
}