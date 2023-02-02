package com.example.criminal_intent

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Time
import java.util.*

@Entity
data class Crime(
    @PrimaryKey val id: UUID = UUID.randomUUID(),
    var title: String = "",
    var date: Date = Date(),
    var isSolved: Boolean = false,
    var requiersPolice: Boolean = false,
    var suspect: String = ""
) {
    val photoFileName get() = "IMG_$id.jpg"
}