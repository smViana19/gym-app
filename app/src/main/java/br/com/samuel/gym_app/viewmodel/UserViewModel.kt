package br.com.samuel.gym_app.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.samuel.gym_app.data.local.User
import br.com.samuel.gym_app.data.repository.UserRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class UserViewModel @Inject constructor(private val repository: UserRepository) : ViewModel()  {
    private val _user = MutableLiveData<User?>()
    val user: LiveData<User?> = _user

    fun registerUser(username: String, password: String) {
        viewModelScope.launch {
            val newUser = User(username = username, password = password)
            repository.insert(newUser)
        }
    }
    fun loginUser(username: String, password: String) {
        viewModelScope.launch {
            _user.value = repository.getUser(username, password)
        }
    }
}