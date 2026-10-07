import java.util.*;
import java.util.function.*;

public class Task9 
{
    public static void main(String[] args)
     {
        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split("\\s+");

        int a = Integer.parseInt(input[0]);
        String operator = input[1];
        int b = Integer.parseInt(input[2]);

        Function<int[], Integer> addition = x -> x[0] + x[1];
        Function<int[], Integer> division = x -> x[0] / x[1];

        Predicate<Integer> test = result -> result != null;

        Integer result = switch (operator) {
            case "+" -> addition.apply(new int[]{a, b});
            case "/" -> b != 0 ? division.apply(new int[]{a, b}) : null;
            default -> null;
        };

        System.out.println(test.test(result) ? "Test Passed" : "Test Failed");
    }
}


Input:
10 + 20

Output:
Test Passed
