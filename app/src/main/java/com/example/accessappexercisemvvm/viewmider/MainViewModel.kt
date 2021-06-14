package com.example.accessappexercisemvvm.viewmider

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.example.accessappexercisemvvm.R
import com.example.githubusers.Model.Data.Users
import com.squareup.picasso.Picasso


class MainViewModel : ViewModel() {

    var productName: ObservableField<String> = ObservableField("")
    var productUsers: ObservableField<Array<Users.Response>> = ObservableField()
    var productList: ObservableField<String> = ObservableField()
    var imageUrl: ObservableField<String> = ObservableField("")


    companion object {
        @JvmStatic
        @BindingAdapter("bind:imageUrl")
        fun loadImage(view: ImageView, imageUrl: String?) {
            if (imageUrl == "") {
                Picasso.get()
                    .load(R.drawable.refresh)
                    .placeholder(R.drawable.refresh)
                    .error(R.drawable.xx)
                    .into(view)
            } else {
                Picasso.get()
                    .load(imageUrl)
                    .placeholder(R.drawable.refresh)
                    .error(R.drawable.xx)
                    .into(view)
            }


        }
    }


}




