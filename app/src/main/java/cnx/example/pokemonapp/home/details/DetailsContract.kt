package cnx.example.pokemonapp.home.details

import cnx.example.pokemonapp.api.FlavorTextEntry
import cnx.example.pokemonapp.api.Pokemon

interface DetailsContract {
    interface View {
        fun loadInfo(pokemon: Pokemon)
        fun loadDescription(descriptionList: List<FlavorTextEntry> )
        fun showLoader()
        fun hideLoader()
        fun showError(message: String)
    }
    interface Presenter{
        fun fetchInfo(id: String)
        fun fetchDescription(id: String)
    }
}