package cnx.example.pokemonapp.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitInstance{

    private const val BASE_URL: String = "https://pokeapi.co/api/v2/"

     private val api: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(createOkHttpClientInterceptor())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    private fun createOkHttpClientInterceptor(): OkHttpClient {
        val okHttpClient = OkHttpClient().newBuilder()
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        okHttpClient.readTimeout(180, TimeUnit.SECONDS)
        okHttpClient.connectTimeout(120, TimeUnit.SECONDS)
        okHttpClient.addInterceptor(interceptor)

        return okHttpClient.build()
    }


    fun getPokemonInfo(id: String): Call<Pokemon>{
        return api.getPokemonInfo(id)
    }

    fun getPokemonList(): Call<PokemonList>{
        return api.getPokemonList(50, 0)
    }

    fun getPokemonDescription(id: String): Call<PokemonSpecies>{
        return api.getPokemonSpecies(id)
    }

}

