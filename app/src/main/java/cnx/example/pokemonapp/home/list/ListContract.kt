package cnx.example.pokemonapp.home.list

import cnx.example.pokemonapp.api.PokemonList
import cnx.example.pokemonapp.api.PokemonUrl

interface ListContract {
    interface View{
        fun showList(pokemonList: List<PokemonUrl>)
        fun showLoader()
        fun hideLoader()
        fun showError(message:String)
    }
    interface Presenter{
        fun fetchItems()
    }

}