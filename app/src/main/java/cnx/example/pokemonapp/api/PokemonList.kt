package cnx.example.pokemonapp.api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class PokemonList(
    @Expose @SerializedName("results") val results: List<PokemonUrl>
)

data class Pokemon(
    @Expose @SerializedName("id") val id: Int,
    @Expose @SerializedName("name") val name: String,
    @Expose @SerializedName("sprites") val sprites: Sprites,
    @Expose @SerializedName("species") val stats: List<PokemonUrl>,
    @Expose @SerializedName("types") val types: List<Type>
)

data class PokemonUrl(
    @Expose @SerializedName("name") val name: String,
    @Expose @SerializedName("url") val url: String
)

data class Sprites(
    @Expose @SerializedName("other") val other: OtherSprites
)

data class OtherSprites(
    @Expose @SerializedName("official-artwork") val officialArtwork: OfficialArtwork
)

data class OfficialArtwork(
    @Expose @SerializedName("front_default") val frontImg: String
)

data class PokemonSpecies(
    @Expose @SerializedName("flavor_text_entries") val flavorTextEntries: List<FlavorTextEntry>
)

data class FlavorTextEntry(
    @Expose @SerializedName("flavor_text") val description: String
)

data class Type(
    @Expose @SerializedName("slot") val slot: Int,
    @Expose @SerializedName("type") val type: TypeInfo
)

data class TypeInfo(
    @Expose @SerializedName("name") val name: String,
    @Expose @SerializedName("url") val url: String
)