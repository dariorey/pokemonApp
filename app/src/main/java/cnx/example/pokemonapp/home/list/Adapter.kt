package cnx.example.pokemonapp.home.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import cnx.example.pokemonapp.R
import cnx.example.pokemonapp.home.api.PokemonUrl

class Adapter: ListAdapter<PokemonUrl, Adapter.ViewHolder>(DiffCallback) {

    companion object DiffCallback: DiffUtil.ItemCallback<PokemonUrl>() {
        override fun areItemsTheSame(oldItem: PokemonUrl, newItem: PokemonUrl): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: PokemonUrl, newItem: PokemonUrl): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_list_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val pokemonItem = getItem(position)
        holder.bind(pokemonItem)
    }

    inner class ViewHolder(private val view: View): RecyclerView.ViewHolder(view){
        private val pokemonName = view.findViewById<TextView>(R.id.textview_name)

        fun bind(item: PokemonUrl){
            pokemonName.text = item.name
        }
    }

}