//package com.example.accessappexercisemvvm.view.adapter
//
//import android.R
//import android.view.LayoutInflater
//import android.view.ViewGroup
//import android.widget.BaseAdapter
//import androidx.databinding.DataBindingUtil
//
//
//class ListViewAdapter(list: List<UserBean>) : BaseAdapter() {
//    //資料
//    private val list: List<UserBean>
//    override fun getCount(): Int {
//        return list.size
//    }
//
//    override fun getItem(position: Int): Any {
//        return list[position]
//    }
//
//    override fun getItemId(position: Int): Long {
//        return position.toLong()
//    }
//
//    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
//        //這個databinding也是根據佈局檔案item_mvvm而命名的
//        var convertView: View? = convertView
//        val itemMvvmBinding: ItemMvvmBinding
//        if (convertView == null) {
//            //建立一個databinding
//            itemMvvmBinding = DataBindingUtil.inflate(
//                LayoutInflater.from(parent.context),
//                R.layout.item_mvvm,
//                parent,
//                false
//            )
//            //獲取convertView
//            convertView = itemMvvmBinding.getRoot()
//        } else {
//            //去除convertView中bangding的dataBinding
//            itemMvvmBinding = DataBindingUtil.getBinding(convertView)
//        }
//        val userBean: UserBean = list[position]
//        //繫結資料，這裡的BR.user根據item佈局檔案中的變數宣告來決定
//        itemMvvmBinding.setVariable(BR.user, userBean)
//        itemMvvmBinding.btnUpdate.setOnClickListener(OnBtnClickListener(1, userBean))
//        itemMvvmBinding.btnDelete.setOnClickListener(OnBtnClickListener(2, position))
//        return convertView
//    }
//
//    private inner class OnBtnClickListener : View.OnClickListener {
//        private var stats //1,修改；2，刪除
//                : Int
//        private var userBean: UserBean? = null
//        private var position = 0
//
//        internal constructor(stats: Int, userBean: UserBean?) {
//            this.stats = stats
//            this.userBean = userBean
//        }
//
//        internal constructor(stats: Int, position: Int) {
//            this.stats = stats
//            this.position = position
//        }
//
//        fun onClick(v: View?) {
//            when (stats) {
//                1 -> userBean.userName.set("修改後的名字")
//                2 -> {
//                    list.removeAt(position)
//                    notifyDataSetChanged()
//                }
//            }
//        }
//    }
//
//    init {
//        this.list = list
//    }
//}