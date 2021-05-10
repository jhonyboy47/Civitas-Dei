package com.csci448.malagon.civitasdei.FBdata

import com.google.firebase.database.Exclude

data class Church(
    @get:Exclude
    var id: String = "",
    var name: String = "",
    var mission: String = "",
    var members: Int = 0
    /*var attendants: List<Christian>*/  ){

}