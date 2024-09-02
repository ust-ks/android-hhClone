package ru.example.mobile.data.models

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "offers")
data class Offer(
    @PrimaryKey
    @SerializedName("id")
    val id: String,

    @SerializedName("title")
    val title: String,

    @Embedded(prefix = "button_")
    @SerializedName("button")
    val button: Button,

    @SerializedName("link")
    val link: String
)

data class Button(
    @SerializedName("text")
    val text: String
)