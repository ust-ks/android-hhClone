package ru.example.mobile.data.models

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity("vacancies")
data class Vacancy(
    @PrimaryKey
    @SerializedName("id")
    val id: String,

    @SerializedName("lookingNumber")
    val lookingNumber: Int?,

    @SerializedName("title")
    val title: String,

    @Embedded("address_")
    @SerializedName("address")
    val address: Address,

    @SerializedName("company")
    val company: String,

    @Embedded("experience_")
    @SerializedName("experience")
    val experience: Experience,

    @SerializedName("publishedDate")
    val publishedDate: String,

    @SerializedName("isFavorite")
    var isFavorite: Boolean,

    @Embedded("salary")
    @SerializedName("salary")
    val salary: Salary,

    @SerializedName("schedules")
    val schedules: List<String>,

    @SerializedName("appliedNumber")
    val appliedNumber: Int?,

    @SerializedName("description")
    val description: String,

    @SerializedName("responsibilities")
    val responsibilities: String,

    @SerializedName("questions")
    val questions: List<String>
)

data class Address(
    @SerializedName("town")
    val town: String,

    @SerializedName("street")
    val street: String,

    @SerializedName("house")
    val house: String
)

data class Experience(
    @SerializedName("previewText")
    val previewText: String?,

    @SerializedName("text")
    val text: String
)

data class Salary(
    @SerializedName("short")
    var short: String,

    @SerializedName("full")
    var full: String
) {
    constructor() : this("", "")
}