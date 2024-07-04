package br.com.samuel.gym_app.data.repository

import br.com.samuel.gym_app.data.local.User
import br.com.samuel.gym_app.data.local.UserDao
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository @Inject constructor(private val userDao: UserDao){
    suspend fun insert(user: User) = userDao.insert(user)
    suspend fun getUser(username: String, password: String) = userDao.getUser(username, password)
}