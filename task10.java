import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class Task10 
{
    public static void main(String[] args)
     {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        Predicate<String> validUsername =
                username -> username.length() >= 3 && username.length() <= 20;

        Predicate<String> validPassword =
                password -> password.length() >= 6 && password.length() <= 20;

        BiPredicate<String, String> validLogin =
                (username, password) ->
                        validUsername.test(username)
                        && validPassword.test(password)
                        && username.equals("admin")
                        && password.equals("admin123");

        IntStream.range(0, n)
                .mapToObj(i -> sc.nextLine().split("\\s+"))
                .map(data -> validLogin.test(data[0], data[1]) ? "SUCCESS" : "FAILURE")
                .forEach(System.out::println);
    }
}



Input:
3
admin admin123
ab 123
user pass

Output:
SUCCESS
FAILURE
FAILURE
