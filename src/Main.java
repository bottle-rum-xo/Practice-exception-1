import java.util.Scanner;

public class Main {
    public static User[] getUsers() {
        User user1 = new User("Jonh", "pass", "jonh@gmail.com", 24);
        User user2 = new User("Mark", "pass2", "mark@gmail.com", 21);
        User user3 = new User("Bob", "pass3", "bob@gmail.com", 17);
        return new User[]{user1, user2, user3};
    }

    public static User getUserByLoginAndPassword(String login, String password) throws UserNotFoundException {
        User[] users = getUsers();
        for (User user : users) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                return user;
            }
        }
        throw new UserNotFoundException("User not found");
    }

    public static void validateUser(User user) throws AccessDeniedException {
        if (user.getAge() < 18) {
            throw new AccessDeniedException("Доступ заблокирован");
        }
    }

    public static void main(String[] args) throws UserNotFoundException, AccessDeniedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите логин");
        String login = scanner.nextLine();
        System.out.println("Введите пароль");
        String password = scanner.nextLine();

        User user = getUserByLoginAndPassword(login, password);
        validateUser(user);

        System.out.println("доступ предоставлен");
    }
}