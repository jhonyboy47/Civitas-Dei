package com.csci448.malagon.civitasdei.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class AttendantProfileEntry (
    @PrimaryKey val id: UUID = UUID.randomUUID(),
    var firstName: String = "",
    var lastName: String = "",
    var attendingChurch: String = "",
    var bio: String = "",
    var location: String = ""
        )