package com.csci448.malagon.civitasdei.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class ChurchProfileEntry (
    @PrimaryKey val id: UUID = UUID.randomUUID(),
    val name: String = "",
    val address: String = "address",
    val description: String = "",
    val numAttendants: Int = 0,
    val numLikes: Int = 0
)