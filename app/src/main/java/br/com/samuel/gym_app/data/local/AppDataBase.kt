package br.com.samuel.gym_app.data.local

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [User::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun userDao(): UserDao
}