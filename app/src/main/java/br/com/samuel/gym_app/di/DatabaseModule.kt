package br.com.samuel.gym_app.di

import android.content.Context
import androidx.room.Room
import androidx.room.Room.databaseBuilder
import br.com.samuel.gym_app.backendservices.database.local.AppDataBase
import br.com.samuel.gym_app.backendservices.database.local.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): AppDataBase {
        return databaseBuilder(
            appContext,
            AppDataBase::class.java,
            "app_database"
        ).build()
    }
    @Provides
    fun provideUserDao(db: AppDataBase): UserDao {
        return db.userDao()
    }
}