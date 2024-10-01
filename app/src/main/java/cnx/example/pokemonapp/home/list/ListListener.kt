package cnx.example.pokemonapp.home.list

import cnx.example.pokemonapp.api.PokemonUrl

interface ListListener {
    fun onTapListener(item: PokemonUrl)
}