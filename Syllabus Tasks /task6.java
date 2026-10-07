import java.util.*;
import java.util.stream.*;

public class Task6 
{
    public static void main(String[] args)
  {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        IntStream.range(0, n)
                .mapToObj(i -> sc.nextLine().split("\\s+"))
                .map(data -> 
                     {
                    String type = data[0];
                    int distance = Integer.parseInt(data[1]);

                    return switch (type)
                      {
                        case "Bike" -> distance * 5;
                        case "Cab" -> distance * 12;
                        case "Auto" -> distance * 12;
                        default -> 0;
                    };
                })
                .forEach(System.out::println);

        sc.close();
    }
}



Input:
3
Bike 10
Cab 15
Auto 8

Output:
50
180
96
