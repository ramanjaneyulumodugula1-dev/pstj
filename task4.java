import java.util.*;

public class  Task4
{

    static int[] buildLPS(String pattern)
  {
        int[] lps = new int[pattern.length()];
        int j = 0;

        for (int i = 1; i < pattern.length(); i++) 
        {
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j))
              {
                j = lps[j - 1];
            }

            if (pattern.charAt(i) == pattern.charAt(j)) 
            {
                j++;
            }

            lps[i] = j;
        }

        return lps;
    }

    static List<Integer> kmpSearch(String text, String pattern)
  {
        int[] lps = buildLPS(pattern);
        List<Integer> result = new ArrayList<>();

        int i = 0;
        int j = 0;

        while (i < text.length())
          {

            if (text.charAt(i) == pattern.charAt(j)) 
            {
                i++;
                j++;
            }

            if (j == pattern.length())
            {
                result.add(i - j);
                j = lps[j - 1];
            } 
            else if (i < text.length() && text.charAt(i) != pattern.charAt(j))
            {
                if (j > 0) 
                {
                    j = lps[j - 1];
                } 
                else
                {
                    i++;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) 
  {

        Scanner sc = new Scanner(System.in);

        String text = sc.nextLine().trim();
        String pattern = sc.nextLine().trim();

        kmpSearch(text, pattern)
                .stream()
                .map(String::valueOf)
                .forEach(x -> System.out.print(x + " "));
    }
}



Input:
AABAACAADAABAABA
AABA

Output:
0 9 12 
