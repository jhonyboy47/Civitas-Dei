package com.csci448.malagon.civitasdei.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class AttendantProfileEntry (
    @PrimaryKey val id: UUID = UUID.randomUUID(),
    val firstName: String,
    val lastName: String,
    val attendingChurch: String,
    val bio: String,
    val location: String
        )