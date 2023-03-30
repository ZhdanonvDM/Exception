import exception.WrongLoginException;
import exception.WrongPasswordException;

public class Main {

    public static void main(String[] args)
    {
        String login = "HelloMyName_Vasia1";
        String password = "sagliaj_23";
        String confirmPassword = "sagliaj_23";
        try {
            System.out.println("Результат проверки введенных данных - " + checkLoginPass(login, password, confirmPassword));
        } catch (WrongLoginException e) {
            System.out.println("Неправильно введен логин");
        } catch (WrongPasswordException e) {
            System.out.println("Неправильно введен пароль");
        }
    }

    public static boolean checkLogin (String login) {
        if (login.length() > 20){
            throw new WrongLoginException();
        }
        return login != null && login.matches("^[a-zA-Z_0-9]*$");
    }
    public static boolean checkPass (String pass) {
        return pass != null && pass.matches("^[a-zA-Z_0-9]*$") && pass.length() <= 20;
    }
    public static boolean checkLoginPass (String login, String password, String confirmPassword) {
        if (!password.equals(confirmPassword)){
            throw new WrongPasswordException();
        }
          return checkLogin (login) && checkPass(password) && checkPass(confirmPassword);
    }
}