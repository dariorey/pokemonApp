package cnx.example.pokemonapp.login

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import cnx.example.pokemonapp.R
import com.google.android.material.textfield.TextInputEditText

class LoginActivity : AppCompatActivity(), LoginContract.View{
    private lateinit var presenter: LoginContract.Presenter
    private lateinit var loader: ProgressBar


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val editUsername = findViewById<TextInputEditText>(R.id.editText_username)
        val editPassword = findViewById<TextInputEditText>(R.id.editText_password)
        val buttonLogin = findViewById<Button>(R.id.btn_login)

        presenter = LoginPresenter(this)

        buttonLogin.setOnClickListener{
            val username = editUsername.text.toString()
            val password = editPassword.text.toString()

            presenter.authUser(User(username, password))
        }

    }

    override fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun showLoader() {
        loader = findViewById(R.id.progressBar_loading)
        loader.visibility = ProgressBar.VISIBLE
    }

    override fun hideLoader() {
        loader = findViewById(R.id.progressBar_loading)
        loader.visibility = ProgressBar.GONE
    }
}