package cnx.example.pokemonapp.home.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import cnx.example.pokemonapp.R
import cnx.example.pokemonapp.api.FlavorTextEntry
import cnx.example.pokemonapp.api.Pokemon

const val ID_KEY = "ID_KEY"

class DetailsFragment : Fragment(), DetailsContract.View {
    private lateinit var pokemon_id: String
    private lateinit var view: View
    private lateinit var loader: ProgressBar
    private lateinit var presenter: DetailsContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            pokemon_id = it.getString(ID_KEY)!!
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        view = inflater.inflate(R.layout.fragment_details, container, false)
        return view
    }

    override fun loadInfo(pokemon: Pokemon) {
        presenter.fetchInfo(pokemon_id)
    }

    override fun loadDescription(descriptionList: List<FlavorTextEntry>) {
        presenter.fetchDescription(pokemon_id)
    }

    override fun showLoader() {
        loader.visibility = ProgressBar.VISIBLE
    }

    override fun hideLoader() {
        loader.visibility = ProgressBar.GONE
    }

    override fun showError(message: String) {
        TODO("Not yet implemented")
    }

}