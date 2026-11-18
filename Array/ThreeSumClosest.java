import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ThreeSumClosest {

    static class Solution {
        public int threeSumClosest(int[] nums, int target) {
            Arrays.sort(nums);
            int n = nums.length;
            int closest = nums[0] + nums[1] + nums[2];

            for (int i = 0; i < n - 2; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }

                int left = i + 1;
                int right = n - 1;

                while (left < right) {
                    int sum = nums[i] + nums[left] + nums[right];

                    if (sum == target) {
                        return sum;
                    }

                    if (Math.abs(sum - target) < Math.abs(closest - target)) {
                        closest = sum;
                    }

                    if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
            return closest;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the size of the array (at least 3): ");
            int n = sc.nextInt();

            if (n < 3) {
                System.out.println("Array must contain at least 3 elements.");
                return;
            }

            int[] arr = new int[n];
            System.out.println("Enter " + n + " integers:");
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            System.out.print("Enter the target: ");
            int target = sc.nextInt();

            System.out.println("Closest sum -> " + solution.threeSumClosest(arr, target));
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter integers only.");
        }
    }
}