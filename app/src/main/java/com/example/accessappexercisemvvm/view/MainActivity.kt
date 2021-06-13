package com.example.accessappexercisemvvm.view

import android.os.Bundle
import android.util.Log
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.accessappexercisemvvm.R
import com.example.accessappexercisemvvm.databinding.ActivityMainBinding
import com.example.accessappexercisemvvm.databinding.ListUserBinding
import com.example.accessappexercisemvvm.view.adapter.UsersListAdapter
import com.example.accessappexercisemvvm.viewmider.MainViewModel
import com.example.githubusers.Model.Data.Users
import com.google.gson.Gson
import okhttp3.*
import java.io.IOException


//主頁
class MainActivity : AppCompatActivity() {
    lateinit var itemViewer: ListView
//    lateinit var UsersListAdapter: UsersListAdapter

    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainViewModel

    //相对应xml布局文件名
    lateinit var ListUserBinding: ListUserBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         itemViewer = findViewById(R.id.itemViewer)
         viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
         binding  = DataBindingUtil.setContentView(this, R.layout.activity_main)


//        ListUserBinding = DataBindingUtil.setContentView(this, R.layout.list_user);
        //初始化一个listview的adapter
//        var UsersListAdapter = UsersListAdapter()
        //绑定adapter
//        itemViewer.setAdapter(UsersListAdapter)
        //通知adapter刷新数据
//        UsersListAdapter.notifyDataSetChanged();

        binding.mainViewMoedl = viewModel
        viewModel.getAllUserForAPI()
        viewModel.getDefault()
        getAllUserForAPI()



    }

    protected fun getAllUserForAPI() {
        val okHttpClient = OkHttpClient()
        val request = Request.Builder()
            // 實例化一個 Builder
            //加上要發送請求的 API 網址
            //name 為傳入的參數
            .url("https://api.github.com/users")
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
//                Log.d(TAG,"API取得數據="+responseStr);
                val users: Array<Users.Response> = Gson().fromJson(
                    responseStr,
                    Array<Users.Response>::class.java
                )
                Log.d("GetAllUserForAPI::", "users:" + users)
                Log.d("GetAllUserForAPI::", "users:" + users[1].login)
                changeList(itemViewer, users)
            }
        })


    }

    private fun changeList(name: ListView, itemList: Array<Users.Response>) {
        runOnUiThread {
            // Stuff that updates the UI
            val mListAdapter: UsersListAdapter = UsersListAdapter()
            mListAdapter.UsersListAdapter(this, this, itemList)
            name.setAdapter(mListAdapter)
            mListAdapter.notifyDataSetChanged()
        }
    }
}

