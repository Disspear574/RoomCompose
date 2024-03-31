package ru.disspear574.roomcompose.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database (entities = [UserEntity::class], version = 1)
abstract class MainBD: RoomDatabase() {
    abstract val dao: Dao
    companion object {
        fun createBD (context: Context): MainBD {
            return Room.databaseBuilder(
                context,
                MainBD::class.java,
                name = "DataBase"
            ).build()
        }
    }

}