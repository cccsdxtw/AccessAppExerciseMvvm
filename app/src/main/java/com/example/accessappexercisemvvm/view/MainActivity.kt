package com.example.accessappexercisemvvm.view

import android.os.Bundle
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.accessappexercisemvvm.R
import com.example.accessappexercisemvvm.databinding.ActivityMainBinding
import com.example.accessappexercisemvvm.viewmider.MainViewModel



//主頁
class MainActivity : AppCompatActivity() {
    lateinit var itemViewer: ListView
    lateinit var LinearLayout: LinearLayout
    lateinit var textView: TextView


    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        itemViewer = this.findViewById(R.id.itemViewer)

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.mainViewMoedl = viewModel
        viewModel.getAllUserForAPI()
        viewModel.getDefault()

    }
}

