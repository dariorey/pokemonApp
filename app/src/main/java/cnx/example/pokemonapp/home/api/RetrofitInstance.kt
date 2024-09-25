package cnx.example.pokemonapp.home.api

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance{

    private const val BASE_URL: String = "https://pokeapi.co/api/v2/"

     private val api:ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }


    fun getPokemonInfo(id: Int): Call<Pokemon>{
        return api.getPokemonInfo(id)
    }

    fun getPokemonList(): Call<PokemonList>{
        return api.getPokemonList(50, 0)
    }

    fun getPokemonDescription(id: Int): Call<PokemonUrl>{
        return api.getPokemonSpecies(id)
    }

}

