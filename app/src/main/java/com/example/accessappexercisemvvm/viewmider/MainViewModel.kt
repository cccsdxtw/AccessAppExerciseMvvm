package com.example.accessappexercisemvvm.viewmider

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel


class MainViewModel : ViewModel() {

    var productName: ObservableField<String> = ObservableField("")

    fun getDefault() {
        productName.set("Users")
    }


    fun getProduct(productId: String) {
        productName.set(productId)
    }

    fun getUser(): String {
        return "e04"
    }
}

