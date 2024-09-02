package ru.example.mobile.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ru.example.mobile.data.database.dao.OfferDao
import ru.example.mobile.data.database.dao.VacancyDao
import ru.example.mobile.data.models.Offer
import ru.example.mobile.data.models.Vacancy

@Database(
    entities = [
        Offer::class,
        Vacancy::class
    ],
    version = 1
)
@TypeConverters(Converters::class)
abstract class LocalDatabase : RoomDatabase() {

    abstract val offerDao: OfferDao
    abstract val vacancyDao: VacancyDao

    companion object {
        const val DATABASE_NAME = "hhClone.db"
    }

}