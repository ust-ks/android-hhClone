package ru.example.mobile.data.database.dao

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import ru.example.mobile.data.models.Vacancy

@Dao
interface VacancyDao : AbstractDao<Vacancy> {

    @Query("SELECT * FROM vacancies")
    suspend fun getFlowAll() : Flow<List<Vacancy>?>

    @Query("UPDATE vacancies SET isFavorite = :value WHERE id = :id")
    suspend fun updateIsFavoriteById(id: String, value: Boolean)

}