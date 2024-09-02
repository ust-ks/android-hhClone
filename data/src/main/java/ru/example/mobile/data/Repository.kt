package ru.example.mobile.data

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import ru.example.mobile.data.database.LocalDatabase
import ru.example.mobile.data.models.Offer
import ru.example.mobile.data.models.Vacancy
import ru.example.mobile.data.network.ApiService
import kotlinx.coroutines.flow.Flow
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ru.example.mobile.data.models.DataResponse

class Repository(
    private val database: LocalDatabase,
    private val apiService: ApiService
) {

    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    suspend fun getOffers(): Flow<List<Offer>?> = database.offerDao.getFlowAll()

    suspend fun getVacancies(): Flow<List<Vacancy>?> = database.vacancyDao.getFlowAll()

    fun fetchData() {
        apiService.getData().enqueue(
            object : Callback<DataResponse> {
                override fun onResponse(call: Call<DataResponse>, response: Response<DataResponse>) {
                    val data = response.body()
                // todo update data in DB
                }

                override fun onFailure(call: Call<DataResponse>, t: Throwable) {
                    TODO("Not yet implemented")
                }
            }
        )
    }

}