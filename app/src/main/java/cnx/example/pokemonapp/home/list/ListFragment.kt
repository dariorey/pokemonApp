package cnx.example.pokemonapp.home.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cnx.example.pokemonapp.R
import cnx.example.pokemonapp.home.api.PokemonUrl

const val USERNAME_BUNDLE = "USERNAME"

class ListFragment : Fragment(), ListContract.View {
    private var username: String? = null
    private lateinit var presenter: ListPresenter
    private lateinit var recycler: RecyclerView
    private lateinit var adapter: PokeListAdapter
    private  lateinit var progressBar: ProgressBar


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            username = it.getString(USERNAME_BUNDLE)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val rootView = inflater.inflate(R.layout.fragment_list, container, false)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val welcomeText = view.findViewById<TextView>(R.id.textview_welcome)
        welcomeText.text = getString(R.string.bienvenido, username)

        progressBar = view.findViewById(R.id.progressBar_loading_list)

        recycler = view.findViewById(R.id.recyclerview_pokemon)
        recycler.layoutManager = LinearLayoutManager(context)

        adapter = PokeListAdapter(emptyList())
        recycler.adapter = adapter

        presenter = ListPresenter(this)
        presenter.fetchItems()

    }

    override fun showList(pokemonList: List<PokemonUrl>) {
        adapter.updatePokemons(pokemonList)
    }


    override fun showLoader() {
        progressBar.visibility = ProgressBar.VISIBLE
    }


    override fun hideLoader() {
        progressBar.visibility = ProgressBar.GONE
    }

    override fun showError(message: String) {
        Toast.makeText(context,message,Toast.LENGTH_LONG).show()
    }

}