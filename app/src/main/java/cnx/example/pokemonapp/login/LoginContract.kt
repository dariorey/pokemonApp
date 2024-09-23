package cnx.example.pokemonapp.login

interface LoginContract {
    interface View{
        fun showError(message: String)
        fun showLoader()
        fun hideLoader()
    }
    interface Presenter{
        fun showError(message: String)
        fun authUser(user:User)
    }
    interface Model{
        fun getUsers():Set<User>
    }
}