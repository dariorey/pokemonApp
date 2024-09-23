package cnx.example.pokemonapp.home.api

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object PokeApiService{

    private var pokeApi: Api

    const val BASE_URL: String = "https://pokeapi.co/api/v2/"

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        pokeApi = retrofit.create(Api::class.java)
    }

    fun getPokemonInfo(id: Int): Call<Pokemon>{
        return pokeApi.getPokemonInfo(id)
    }

    fun getPokemonList(): Call<ResponseBody>{
        return pokeApi.getPokemonList(50, 0)
    }

    fun getPokemonDescription(id: Int): Call<PokemonUrl>{
        return pokeApi.getPokemonSpecies(id)
    }

}

