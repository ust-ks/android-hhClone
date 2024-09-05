package ru.example.mobile.data.database.dao

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import ru.example.mobile.data.models.Offer

@Dao
interface OfferDao : AbstractDao<Offer> {

    @Query("SELECT * FROM offers")
    fun getFlowAll() : Flow<List<Offer>?>

}