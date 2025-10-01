package com.example.homeworke

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {
    private val _items = MutableLiveData<MutableList<Item>>(mutableListOf())
    val items: LiveData<MutableList<Item>> = _items


    fun addItem(item: Item) {
    val currentList = _items.value ?: mutableListOf()
    currentList.add(item)
    _items.value = currentList
    }
    fun sendClearSignal() {
       val currentItem = _items.value ?: mutableListOf()?:return
        val secondItem= _items.value?: mutableListOf()?:return
        currentItem.removeAll(currentItem)
        secondItem.removeAll (secondItem)
        _items.value = currentItem
    }
}