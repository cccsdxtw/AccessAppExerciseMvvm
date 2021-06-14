package com.example.accessappexercisemvvm.viewmider


import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.example.accessappexercisemvvm.R
import com.squareup.picasso.Picasso


class OneUserViewModel : ViewModel() {

    var name: ObservableField<String> = ObservableField("")
    var login: ObservableField<String> = ObservableField("")
    var location: ObservableField<String> = ObservableField("")
    var blog: ObservableField<String> = ObservableField("")
    var imageUrl: ObservableField<String> = ObservableField("")
    var clickListener: ObservableField<View.OnClickListener> = ObservableField<View.OnClickListener>()
    //    var urlImage: ObservableField<String> = ObservableField("")


    fun setAll(mName: String, mLogin: String, mLocation: String, mBlog: String, mUrlImage: String) {
        name.set(mName)
        login.set(mLogin)
        location.set(mLocation)
        blog.set(mBlog)
        imageUrl.set(mUrlImage)
    }




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






