package com.csci448.malagon.civitasdei.FBdata

import com.google.firebase.database.Exclude

data class Church(
    @get:Exclude
    var id: String = "",
    var name: String = "",
    var bio: String = "",
    /*var attendants: List<Christian>*/  ){

}