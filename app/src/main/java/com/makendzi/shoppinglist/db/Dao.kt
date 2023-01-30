package com.makendzi.shoppinglist.db

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Insert
import com.makendzi.shoppinglist.entities.NoteItem
import kotlinx.coroutines.flow.Flow

@Dao
interface Dao {
    @Query("SELECT * FROM note_list")
    fun getAllNotes(): Flow<List<NoteItem>>

    @Insert
    suspend fun insertNote(noteItem: NoteItem)
}