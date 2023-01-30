package com.makendzi.shoppinglist.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.makendzi.shoppinglist.entities.LibraryItem
import com.makendzi.shoppinglist.entities.NoteItem
import com.makendzi.shoppinglist.entities.ShoppingListItem
import com.makendzi.shoppinglist.entities.ShoppingListNames

@Database(
    entities = [LibraryItem::class, NoteItem::class, ShoppingListItem::class, ShoppingListNames::class],
    version = 1
)
abstract class MainDataBase : RoomDatabase() {

    companion object {
        @Volatile
        private var INSTANCE: MainDataBase? = null

        fun getDataBast(context: Context): MainDataBase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    MainDataBase::class.java,
                    "shopping_list_db"
                ).build()
                instance
            }
        }
    }
}