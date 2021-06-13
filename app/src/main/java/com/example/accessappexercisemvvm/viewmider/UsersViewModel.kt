package com.example.accessappexercisemvvm.viewmider

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.example.githubusers.Model.Data.Users

class UsersViewModel : BaseObservable() {
    var login: ObservableField<String> = ObservableField("")
    var id: ObservableField<Int> = ObservableField(0)
    var node_id: ObservableField<String> = ObservableField("")
    var avatar_url: ObservableField<String> = ObservableField("")
    var gravatar_id: ObservableField<String> = ObservableField("")
    var html_url: ObservableField<String> = ObservableField("")
    var followers_url: ObservableField<String> = ObservableField("")
    var following_url: ObservableField<String> = ObservableField("")
    var gists_url: ObservableField<String> = ObservableField("")
    var starred_url: ObservableField<String> = ObservableField("")
    var subscriptions_url: ObservableField<String> = ObservableField("")
    var organizations_url: ObservableField<String> = ObservableField("")
    var repos_url: ObservableField<String> = ObservableField("")
    var events_url: ObservableField<String> = ObservableField("")
    var received_events_url: ObservableField<String> = ObservableField("")
    var type: ObservableField<String> = ObservableField("")
    var site_admin: ObservableField<Boolean> = ObservableField(true)


    fun setAll(gg: Users.Response){
        login.set(gg.login)
        id.set(gg.id)
        node_id.set(gg.node_id)
        avatar_url.set(gg.avatar_url)
        gravatar_id.set(gg.gravatar_id)
        html_url.set(gg.html_url)
        followers_url.set(gg.followers_url)
        following_url.set(gg.following_url)
        gists_url.set(gg.gists_url)
        starred_url.set(gg.starred_url)
        subscriptions_url.set(gg.subscriptions_url)
        organizations_url.set(gg.organizations_url)
        repos_url.set(gg.repos_url)
        events_url.set(gg.events_url)
        received_events_url.set(gg.received_events_url)
        type.set(gg.type)
        site_admin.set(gg.site_admin)
    }

    @Bindable
    fun getlogin(): String?{
       return login.get()
    }


}