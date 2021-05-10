package com.csci448.malagon.civitasdei.FBdata

import com.google.firebase.database.Exclude

data class Christian(
    @get:Exclude
    var id: String = "",
    var name: String = "",
    var favoriteVerse: String = "",
    var church: String = "" /*,
    var list: List<Church>*/ ) {
}