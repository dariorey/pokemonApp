package cnx.example.pokemonapp.home.list

import android.util.Log
import cnx.example.pokemonapp.api.RetrofitInstance
import cnx.example.pokemonapp.api.PokemonList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListPresenter(private val view: ListContract.View): ListContract.Presenter {

    override fun fetchItems() {
        Log.i("Pokeapi","Entro en el fetch" )
        view.showLoader()

        RetrofitInstance.getPokemonList().enqueue(
            object: Callback<PokemonList> {
                override fun onResponse(call: Call<PokemonList>, response: Response<PokemonList>) {
                    Log.d("Pokeapi", "Entro en el response")
                  if (response.isSuccessful && response.body() !== null) {
                      view.showList(response.body()!!.results)
                  } else{
                      view.showError("Error al cargar la lista")
                  }
                    view.hideLoader()
                }
                override fun onFailure(call: Call<PokemonList>, t: Throwable) {
                    Log.e("Pokeapi", "${t.message}")
                    view.showError("Error desconocido, intente nuevamente")
                    call.cancel()
                    view.hideLoader()
                }

            }
        )
    }


}