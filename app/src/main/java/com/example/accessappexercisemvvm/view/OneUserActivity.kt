package com.example.accessappexercisemvvm.view

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.accessappexercisemvvm.R
import com.example.accessappexercisemvvm.databinding.ActivityOneuserBinding
import com.example.accessappexercisemvvm.model.Data.User
import com.example.accessappexercisemvvm.viewmider.MainViewModel
import com.example.accessappexercisemvvm.viewmider.OneUserViewModel
import com.example.githubusers.Model.Uill.CircleTransform


import com.google.gson.Gson
import com.squareup.picasso.Picasso
import okhttp3.*
import java.io.IOException

//主頁
class OneUserActivity : AppCompatActivity() {

    lateinit var mXX: ImageView
    lateinit var mimgAvatar: ImageView
    lateinit var mnameEEEE: TextView
    lateinit var mimgBadge: ImageView
    lateinit var mTextViewId: TextView
    lateinit var mTextViewlocation: TextView
    lateinit var mTextViewlink: TextView

    lateinit var binding: ActivityOneuserBinding
    lateinit var viewModel: OneUserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_oneuser)
        val bundle = intent.extras
        val mID = bundle!!.getString("ID")
        getOneUserForAPI(mID!!)
        mXX = findViewById(R.id.XX)
        mXX.setOnClickListener(View.OnClickListener() {
            onBackPressed()
        })
        mimgAvatar = findViewById(R.id.imgAvatar)
        mimgBadge = findViewById(R.id.imgBadge)

        viewModel = ViewModelProviders.of(this).get(OneUserViewModel::class.java)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_oneuser)


    }


    fun getOneUserForAPI(name: String) {
        val okHttpClient = OkHttpClient()
        val request = Request.Builder()
            // 實例化一個 Builder
            //加上要發送請求的 API 網址
            //name 為傳入的參數
            .url("https://api.github.com/users" + "/" + name)
            //建立 Request
            .build()
        val call = okHttpClient.newCall(request)

        call.enqueue(object : Callback {
            override fun onFailure(call: Call?, e: IOException?) {
                println("fail : $e")
            }

            override fun onResponse(call: Call?, response: Response?) {
                //處理回來的 Response
                val responseStr = response!!.body()!!.string()
                val item = Gson().fromJson(responseStr, User.Response::class.java)

                runOnUiThread {
                    // Stuff that updates the UI
//                    mnameEEEE.text = item.name
//                    mTextViewId.text = item.login
//                    mTextViewlocation.text = item.location
//                    mTextViewlink.text =item.blog


                    binding.oneUserViewModel = viewModel
                    viewModel.setAll(item.name, item.login, item.location, item.blog,item.avatar_url)
//                    viewModel.urlImage.set(item.avatar_url)
//                    viewModel.loadImage(mimgAvatar, item.avatar_url)
                }
            }
        })
    }

}