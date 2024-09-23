package cnx.example.pokemonapp.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.add
import androidx.fragment.app.commit
import cnx.example.pokemonapp.R
import cnx.example.pokemonapp.home.list.ListFragment
import cnx.example.pokemonapp.home.list.USERNAME_BUNDLE

//SharedPreferences para guardar valores
//DialogFragment para mostrar el loader

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val username = intent.getStringExtra("username")

        if(savedInstanceState == null) inflateFragment(username)
    }

    private fun inflateFragment(username: String?){
        val bundle = bundleOf(USERNAME_BUNDLE to username)

        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add<ListFragment>(R.id.fragment_container_home, args = bundle)
        }
    }
}