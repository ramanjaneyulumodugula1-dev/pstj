import java.util.*;
import java.util.stream.*;

public class Task8 
{
    public static void main(String[] args) 
  {
        Scanner sc = new Scanner(System.in);

        String[] first = sc.nextLine().split("\\s+");
        int n = Integer.parseInt(first[0]);
        int m = Integer.parseInt(first[1]);

        Map<Integer, List<Integer>> graph = new HashMap<>();

        IntStream.range(0, m).forEach(i ->
          {
            String[] road = sc.nextLine().split("\\s+");
            int u = Integer.parseInt(road[0]);
            int v = Integer.parseInt(road[1]);

            graph.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            graph.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        });

        String[] route = sc.nextLine().split("\\s+");
        int source = Integer.parseInt(route[0]);
        int destination = Integer.parseInt(route[1]);

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        queue.add(source);
        visited.add(source);

        while (!queue.isEmpty())
          {
            int current = queue.poll();

            if (current == destination)
            {
                System.out.println("YES");
                return;
            }

            graph.getOrDefault(current, new ArrayList<>())
                    .stream()
                    .filter(node -> !visited.contains(node))
                    .forEach(node -> {
                        visited.add(node);
                        queue.add(node);
                    });
        }

        System.out.println("NO");
    }
}


Input:
5 4
1 2
2 3
3 4
4 5
1 5

Output:
 Yes
