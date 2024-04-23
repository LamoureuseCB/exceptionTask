import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws UserNotFoundException {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите логин");
        String login = scanner.nextLine();
        System.out.println("Введите пароль");
        String password = scanner.nextLine();
        User [] users = getUsers();
        try{
            getUserByLoginAndPassword(login, password);
            validateUser(users);
            System.out.println("Доступ предоставлен");
        }catch (UserNotFoundException e){
            System.out.println(e.getMessage());
        }catch (AccessDeniedException e){
            e.getMessage();
        }
    }


    public static User[] getUsers() {
        User user1 = new User("jhon", "pass", "jhon@gmail.com\"", 24);
        User user2 = new User("stan", "stop", "stan@gmail.com\"", 16);
        return new User[]{user1, user2};
    }

    public static User getUserByLoginAndPassword(String login, String password) throws UserNotFoundException {
        User[] users = getUsers();
        for (User user : users) {
            if (user.login.equals(login) && user.password.equals(password)) {
                return user;
            }
        }
        throw new UserNotFoundException("Пользователь не найден");
    }

    public static void validateUser(User[] user) throws AccessDeniedException {
        User[] users = getUsers();
        for (User person : users) {
            if (person.age < 18) {
                throw new AccessDeniedException("Доступ запрещен");
            }

        }

    }
}
