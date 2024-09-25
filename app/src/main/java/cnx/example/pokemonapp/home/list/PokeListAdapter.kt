package cnx.example.pokemonapp.home.list

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cnx.example.pokemonapp.R
import cnx.example.pokemonapp.home.api.PokemonUrl

class PokeListAdapter(private var pokemonurls: List<PokemonUrl>): RecyclerView.Adapter<PokeListAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
         val name:TextView = itemView.findViewById(R.id.textview_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = pokemonurls.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val pokeUrlItem = pokemonurls[position]
        holder.name.text = pokeUrlItem.name
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updatePokemons(newPokemonUrls: List<PokemonUrl>){
        pokemonurls = newPokemonUrls
        notifyDataSetChanged()
    }

}