package cnx.example.pokemonapp.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("pokemon/{id}")
    fun getPokemonInfo(@Path("id") id: String): Call<Pokemon>
    @GET("pokemon")
    fun getPokemonList(@Query("limit") limit: Int, @Query("offset") offset: Int): Call<PokemonList>
    @GET("pokemon-species/{id}")
    fun getPokemonSpecies(@Path("id") id: String): Call<PokemonSpecies>
}