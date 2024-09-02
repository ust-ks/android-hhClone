package ru.example.mobile.data.network

import retrofit2.Call
import retrofit2.http.GET
import ru.example.mobile.data.models.DataResponse

interface ApiService {

    @GET("u/0/uc?id=1z4TbeDkbfXkvgpoJprXbN85uCcD7f00r")
    fun getData(): Call<DataResponse>

}