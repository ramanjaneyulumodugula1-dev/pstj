import java.util.Scanner;

public class task1 {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 50};

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the index: ");
        int index = sc.nextInt();

        System.out.println("Element at index " + index + " is: " + numbers[index]);

        sc.close();
    }
}