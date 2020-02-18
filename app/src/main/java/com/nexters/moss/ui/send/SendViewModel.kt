package com.nexters.moss.ui.send

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nexters.moss.model.CakeModel


class SendViewModel : ViewModel() {
    private val _cakeList = MutableLiveData<ArrayList<CakeModel>>()
    val cakeList: LiveData<ArrayList<CakeModel>> get() = _cakeList

    private val _isEditEnable = MutableLiveData<Boolean>().apply { value = false }
    val isEditEnable: LiveData<Boolean> get() = _isEditEnable

    private val _isVisible = MutableLiveData<Boolean>().apply{ value = true }
    val isVisible : LiveData<Boolean> get() = _isVisible

    private val _cakeImage = MutableLiveData<Int>()
    val cakeImage : LiveData<Int> get() = _cakeImage

    private val _exit = MutableLiveData<Boolean>().apply{ value = false }
    val exit : LiveData<Boolean> get() = _exit

    private val _main = MutableLiveData<Boolean>().apply{ value = false }
    val main : LiveData<Boolean> get() = _main

    private val _toYou = MutableLiveData<String>()
    val toYou: LiveData<String> get() = _toYou

    private val _cakeName = MutableLiveData<String>()
    val cakeName: LiveData<String> get() = _cakeName


    fun setCakeList(list: ArrayList<CakeModel>) {
        _cakeList.value = list
    }

    fun isTextLengthEnough(enough: Boolean) {
        _isEditEnable.value = enough
    }

    fun isBtnVisible(visible : Boolean){
        _isVisible.value = visible
    }

    fun changeCakeImage(image : Int){
        _cakeImage.value = image
    }

    fun exit(){
        _exit.value = true
    }

    fun goMain(){
        _main.value = true
    }

    fun changeString(toYou: String) {
        _toYou.value = toYou
    }

    fun changeCakeName(cakeName : String){
        _cakeName.value = cakeName
    }
}
