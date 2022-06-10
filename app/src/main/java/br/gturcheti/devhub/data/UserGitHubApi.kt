package br.gturcheti.devhub.data

import br.gturcheti.devhub.data.dto.UserResponse
import retrofit2.http.GET

interface UserGitHubApi {

    @GET("users/gturcheti")
    suspend fun fetchUser(): UserResponse

}