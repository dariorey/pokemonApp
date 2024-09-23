package cnx.example.pokemonapp.login

class LoginModel: LoginContract.Model {

    private val userSet = setOf(
        User("concentrix", "1234"),
        User("cnx", "111"),
        User("cnx1", "1"),
        User("cnx2", "2"),
        User("cnx3", "3")
    )

    override fun getUsers(): Set<User> {
        return userSet
    }
}