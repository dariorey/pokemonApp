package cnx.example.pokemonapp.login

import android.content.Intent
import android.os.Handler
import android.os.Looper
import cnx.example.pokemonapp.home.HomeActivity

class LoginPresenter(private val view: LoginActivity) : LoginContract.Presenter {
     private var model: LoginContract.Model = LoginModel()

    override fun showError(message: String) {
        this.view.hideLoader()
        this.view.showError(message)
    }

    override fun authUser(user: User) {
        this.view.showLoader()
         Handler(Looper.getMainLooper()).postDelayed({
            val userList = model.getUsers()
            if(userList.contains(user)) logIn(user.username)
            else showError("wrong username or password")
        }, 3000)
    }

    private fun logIn(username: String){
        this.view.hideLoader()
        val intent = Intent(this.view, HomeActivity::class.java).putExtra("username", username)
        view.startActivity(intent)
    }
}

