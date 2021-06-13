package com.example.accessappexercisemvvm.viewmider

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel

class UserViewModel : ViewModel() {
    var login: ObservableField<String> = ObservableField("")
    var id: ObservableField<Int> = ObservableField(0)
    var node_id: ObservableField<String> = ObservableField("")
    var avatar_url: ObservableField<String> = ObservableField("")
    var gravatar_id: ObservableField<String> = ObservableField("")
    var url: ObservableField<String> = ObservableField("")
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
    var site_admin: ObservableField<String> = ObservableField("")
    var name: ObservableField<String> = ObservableField("")
    var company: ObservableField<String> = ObservableField("")
    var blog: ObservableField<String> = ObservableField("")
    var location: ObservableField<String> = ObservableField("")
    var email: ObservableField<String> = ObservableField("")
    var hireable: ObservableField<String> = ObservableField("")
    var bio: ObservableField<String> = ObservableField("")
    var twitter_username: ObservableField<String> = ObservableField("")
    var public_repos: ObservableField<Int> = ObservableField(0)
    var public_gists: ObservableField<Int> = ObservableField(0)
    var followers: ObservableField<Int> = ObservableField(0)
    var following: ObservableField<Int> = ObservableField(0)
    var created_at: ObservableField<String> = ObservableField("")
    var updated_at: ObservableField<String> = ObservableField("")



}