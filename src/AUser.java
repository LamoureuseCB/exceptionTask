public abstract class AUser {
    String login;

    String password;
    String email;
    int age;

    public AUser(String login, String password, String email, int age) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.age = age;
    }
}
