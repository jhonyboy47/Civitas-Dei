package com.csci448.malagon.civitasdei.FBdata

import com.google.firebase.database.Exclude
import java.util.*

data class Post(
    @get:Exclude
    var id: String = "",
    var title: String = "",
    var content: String = "") {
}