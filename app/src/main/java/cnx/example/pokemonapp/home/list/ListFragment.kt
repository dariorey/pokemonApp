package cnx.example.pokemonapp.home.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cnx.example.pokemonapp.R

const val USERNAME_BUNDLE = "USERNAME"

class ListFragment : Fragment(), ListContract.View {
    private var username: String? = null
    private lateinit var rootView: View
    private lateinit var presenter: ListContract.Presenter
    private lateinit var progressBarLoader: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            username = it.getString(USERNAME_BUNDLE)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        rootView = inflater.inflate(R.layout.fragment_list, container, false)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter = ListPresenter(this)

        val welcomeText = rootView.findViewById<TextView>(R.id.textview_welcome)
        val logoutButton = rootView.findViewById<ImageButton>(R.id.btn_logout)

        showList()
        welcomeText.text = getString(R.string.bienvenido, username)
        logoutButton.setOnClickListener {
            presenter.logOut()
        }


    }

    override fun showList() {
        val pokemonRecycler = rootView.findViewById<RecyclerView>(R.id.recyclerview_pokemon)
        val adapter = Adapter()
        presenter.fetchItems()

        //adapter.submitList(listItems)

        pokemonRecycler.layoutManager = LinearLayoutManager(requireContext())
        pokemonRecycler.adapter = adapter
    }

    override fun showLoader() {
        progressBarLoader = rootView.findViewById(R.id.progressBar_loading_list)
        progressBarLoader.visibility = ProgressBar.VISIBLE
    }

    override fun hideLoader() {
        progressBarLoader = rootView.findViewById(R.id.progressBar_loading_list)
        progressBarLoader.visibility = ProgressBar.GONE
    }

}