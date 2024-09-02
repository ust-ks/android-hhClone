package ru.example.mobile.data.models

import com.google.gson.annotations.SerializedName

data class DataResponse(
    @SerializedName("offers") val offers: List<Offer>,
    @SerializedName("vacancies") val vacancies: List<Vacancy>
)
