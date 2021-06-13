package com.example.accessappexercisemvvm.view.adapter

import android.app.Activity
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import com.example.accessappexercisemvvm.R
import com.example.accessappexercisemvvm.databinding.ListUserBinding
import com.example.accessappexercisemvvm.viewmider.UsersViewModel
import com.example.githubusers.Model.Data.Users
import com.example.githubusers.Model.Uill.CircleTransform
import com.squareup.picasso.Picasso


class UsersListAdapter : BaseAdapter() {
//    private var mLayInf: LayoutInflater? = null
    var mContext: Context? = null
    var mItemList: List<Map<String, Any>>? = null
     var mAllUser: Array<Users.Response>? = null
    var mactivity: Activity? = null

    fun UsersListAdapter(activity: Activity, context: Context, AllUser: Array<Users.Response>) {
//        mLayInf = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        mAllUser = AllUser
        mContext = context
        mactivity = activity
    }


    override fun getCount(): Int {
        Log.d("UsersListAdapter", "mAllUser.length():" + mAllUser!!.size)
        if (mAllUser!!.size < 100) {
            return mAllUser!!.size + 1
        } else {
            return 100
        }
    }

    override fun getItem(position: Int): Any? {
        //取得 ListView 列表於 position 位置上的 Item
        return position
    }

    override fun getItemId(position: Int): Long {
        //取得 ListView 列表於 position 位置上的 Item 的 ID
        return position.toLong()
    }


    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        //这个databinding也是根据布局文件item_mvvm而命名的
        lateinit var ListUserBinding: ListUserBinding
        var ConvertView: View? = convertView
        if (convertView == null) {
            //创建一个databinding
            ListUserBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent!!.context),
                R.layout.list_user,
                parent,
                false
            );
            //获取convertView
            ConvertView = ListUserBinding.getRoot();
        } else {
            //去除convertView中bangding的dataBinding
            ListUserBinding = DataBindingUtil.getBinding(ConvertView!!)!!;
        }

        UsersViewModel().setAll(mAllUser!![position])
        val layoutInflater = LayoutInflater.from(mContext)
        val view = layoutInflater.inflate(R.layout.list_user, parent, false)
        val imgView: ImageView = view.findViewById<View>(R.id.imgAvatar) as ImageView
        Picasso.get()
            .load(mAllUser!![position].avatar_url)
            .placeholder(R.drawable.refresh)
            .error(R.drawable.xx)
            .transform(CircleTransform())
            .into(imgView)

        ListUserBinding.userItem.setOnClickListener(View.OnClickListener {
             fun onClick(v: View) {

            }
        })

        return ConvertView;

//        //設定與回傳 convertView 作為顯示在這個 position 位置的 Item 的 View。
//        if (position < mAllUser.size) {
//            val layoutInflater = LayoutInflater.from(mContext)
//            val view = layoutInflater.inflate(R.layout.list_user, parent, false)
//
//            val imgView: ImageView = view.findViewById<View>(R.id.imgAvatar) as ImageView
//            val txtView = view.findViewById<View>(R.id.txtName) as TextView
//
//            txtView.text = mAllUser[position].login
//
//            Picasso.get()
//                .load(mAllUser[position].avatar_url)
//                .placeholder(R.drawable.refresh)
//                .error(R.drawable.xx)
//                .into(imgView)
//
//            val example = View.OnClickListener {
//                // 寫要做的事...
//
//
//            }
//            view.setOnClickListener(example)
//            return view
//        } else {
//            val layoutInflater = LayoutInflater.from(mContext)
//            val view = layoutInflater.inflate(R.layout.list_user_separate, parent, false)
//            return view
//        }
    }

    private class OnBtnClickListener : View.OnClickListener {
        override fun onClick(v: View) {


        }
    }
}