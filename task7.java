import java.util.*;
import java.util.stream.*;

public class Task7
  {
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        List<String> hashtags = IntStream.range(0, n)
                .mapToObj(i -> sc.nextLine().trim())
                .collect(Collectors.toList());

        hashtags.stream()
                .collect(Collectors.groupingBy(
                        x -> x,
                        LinkedHashMap::new,
                        Collectors.counting()
                ))
                .forEach((hashtag, count) ->
                        System.out.println(hashtag + " " + count));
    }
}


input:
5
java
python
java
ai
python

Output:
java 2
python 2
ai 1
