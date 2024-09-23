package cnx.example.pokemonapp.home.list

import cnx.example.pokemonapp.home.api.PokemonUrl

interface ListContract {
    interface View{
        fun showList()
        fun showLoader()
        fun hideLoader()
    }
    interface Presenter{
        fun logOut()
        fun fetchItems()
    }

}