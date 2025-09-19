import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Scanner = tool to read user input

        // Ask the user how many numbers they want in the array
        System.out.print("Enter size of array: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter elements of array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt(); // read each number one by one
        }

        // Count how many "inversions" (out-of-order pairs) exist
        int result = InversionCountPractice.countInversions(arr);

        // Show the result to the user
        System.out.println("Number of inversions: " + result);

        scanner.close(); // always close Scanner when done
    }
}
