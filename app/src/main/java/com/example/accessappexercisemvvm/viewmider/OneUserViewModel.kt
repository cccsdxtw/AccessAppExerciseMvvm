package com.example.accessappexercisemvvm.viewmider

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.example.githubusers.Model.Data.Users


class OneUserViewModel : ViewModel() {

    var productName: ObservableField<String> = ObservableField("")
    var productUsers: ObservableField<Array<Users.Response>> = ObservableField()


    fun getAllUserForAPI() : Array<Users.Response>? {
        return productUsers.get()
    }

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




