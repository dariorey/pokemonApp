package cnx.example.pokemonapp.home.details

import android.util.Log
import cnx.example.pokemonapp.api.Pokemon
import cnx.example.pokemonapp.api.PokemonSpecies
import cnx.example.pokemonapp.api.PokemonUrl
import cnx.example.pokemonapp.api.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailsPresenter(val view: DetailsContract.View): DetailsContract.Presenter{
    override fun fetchInfo(id: String) {
        view.showLoader()
        RetrofitInstance.getPokemonInfo(id).enqueue(
            object: Callback<Pokemon>{
                override fun onResponse(call: Call<Pokemon>, response: Response<Pokemon>) {
                    if (response.isSuccessful) {
                        view.loadInfo(response.body()!!)
                    } else
                        view.showError("Hubo un error en la carga de datos, intente nuevamente")
                    view.hideLoader()
                }

                override fun onFailure(call: Call<Pokemon>, t: Throwable) {
                    call.cancel()
                    Log.e("Pokeapi", t.message.toString())
                    view.hideLoader()
                    view.showError("Error desconocido, intente nuevamente")
                }
            }
        )
    }

    override fun fetchDescription(id: String) {
        view.showLoader()
        RetrofitInstance.getPokemonDescription(id).enqueue(
            object: Callback<PokemonSpecies> {
                override fun onResponse(call: Call<PokemonSpecies>, resp: Response<PokemonSpecies>) {
                    if (resp.isSuccessful) {
                        view.loadDescription(resp.body()?.flavorTextEntries!!)
                    } else
                        view.showError("Hubo un error en la carga de la descripcion, intente nuevamente")
                    view.hideLoader()
                }

                override fun onFailure(call: Call<PokemonSpecies>, t: Throwable) {
                    call.cancel()
                    Log.e("Pokeapi", t.message.toString())
                    view.hideLoader()
                    view.showError("Error desconocido, intente nuevamente")
                }


            })
    }

}