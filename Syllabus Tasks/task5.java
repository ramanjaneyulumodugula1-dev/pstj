import java.util.Scanner;
import java.util.stream.IntStream;

public class Task5
  {
   public Task5() 
    {
   }

   public static void main(String[] var0)
    {
      Scanner var1 = new Scanner(System.in);
      int var2 = Integer.parseInt(var1.nextLine());
      int[] var3 = new int[]{0};
      IntStream.range(0, var2).mapToObj((var1x) -> var1.nextLine().trim().split("\\s+")).forEach((var1x) -> 
                                                                                                 {
         int var2 = Integer.parseInt(var1x[1]);
         if (var1x[0].equals("Deposit")) 
         {
            var3[0] += var2;
         } else if (var1x[0].equals("Withdraw")) 
         {
            var3[0] -= var2;
         }

      });
      System.out.println(var3[0]);
   }
}



input:
3
Deposit 5000
Withdraw 2000
Deposit 1000

output:
4000
