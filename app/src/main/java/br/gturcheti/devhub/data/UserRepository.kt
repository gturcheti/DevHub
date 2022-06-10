package br.gturcheti.devhub.data

import br.gturcheti.devhub.data.dto.UserResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UserRepository {
    private val api = userApi

    suspend fun fetchUser():UserResponse = withContext(Dispatchers.IO) {
        api.fetchUser()
    }
}