package ru.example.mobile.data

import androidx.room.Room
import org.koin.dsl.module
import ru.example.mobile.data.database.LocalDatabase
import ru.example.mobile.data.network.ApiService
import ru.example.mobile.data.network.RetrofitClient

fun dataModule() = module {
    single { Preferences(get()) }
    single {
        Room.databaseBuilder(get(), LocalDatabase::class.java, LocalDatabase.DATABASE_NAME)
            .fallbackToDestructiveMigration().build()
    }
    single<ApiService> {
        RetrofitClient.retrofit.create(ApiService::class.java)
    }
    single { Repository(get(), get()) }
}