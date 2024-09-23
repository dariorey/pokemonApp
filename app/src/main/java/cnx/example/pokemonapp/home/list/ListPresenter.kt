package cnx.example.pokemonapp.home.list

import android.content.Intent
import android.util.Log
import cnx.example.pokemonapp.home.api.PokeApiService
import cnx.example.pokemonapp.home.api.PokemonUrl
import cnx.example.pokemonapp.home.api.ResponseBody
import cnx.example.pokemonapp.login.LoginActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListPresenter(private val view: ListFragment): ListContract.Presenter {
    override fun logOut() {
        val intent = Intent(this.view.requireContext(), LoginActivity::class.java)
        this.view.startActivity(intent)
    }

    override fun fetchItems() {
        Log.i("Pokeapi","Entro en el fetch" )
        view.showLoader()
       // var pokeList: List<PokemonUrl>? = null

        PokeApiService.getPokemonList().enqueue(
            object: Callback<ResponseBody> {
                override fun onResponse(p0: Call<ResponseBody>, p1: Response<ResponseBody>) {
                    p1.body()?.results?.let {
                        list ->
                        {
                            Log.i("Pokeapi", "esta es la lista $list")
                             list }
                    }
                    view.hideLoader()
                }

                override fun onFailure(p0: Call<ResponseBody>, p1: Throwable) {
                    p0.cancel()
                }

            }
        )

       // return pokeList
    }


}