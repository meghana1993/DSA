import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class GoogleInterview {

    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, -1, 0, -2));
        int[] ainput = {11, 12, 16, 17, 0, 18};
        int[] binput = {-1, 0, 1, 2, 3, 4};
        int[] xinput = {1, 1, 2, 3};
        //System.out.println(findPairWithSumSorted(8,binput));
        System.out.println((maxabsoluteDiff(7, xinput)));


    }

    public int solve(int[] A) {
        int maxJump = A[0];
        int i = 0;
        int noOfJumps = 0;
        while (i < A.length) {
            noOfJumps++;
            for (int j = 1; j <= maxJump; j++) {
                if (A[i + maxJump] < A[i + j]) {
                    maxJump = j;
                }
            }
            i = i + maxJump;
        }
        return noOfJumps;
    }

    public static boolean findPairsWithSum(int Sum, int[] input) {
        HashSet<Integer> compliments = new HashSet<Integer>();
        for (int i = 0; i < input.length; i++) {
            if (compliments.contains(input[i])) {
                return true;
            }
            compliments.add(Sum - input[i]);
        }
        return false;

    }

    public static boolean findPairWithSumSorted(int Sum, int[] input) {
        int low = 0;
        int hi = input.length - 1;
        int actualsum = 0;
        while (low < hi) {
            actualsum = input[low] + input[hi];
            if (actualsum == Sum) {
                return true;
            } else if (actualsum > Sum) {
                hi--;
            } else
                low++;

        }
        return false;
    }

    public static int maxabsoluteDiff(int b, int[] input) {
        Arrays.sort(input);
        int length = input.length;
        while (b > 0 && Math.abs(input[length - 1] - input[0]) > 0) {
            int mincount = findMins(input);
            int maxcount = findMaxs(input);

            //System.out.println(maxcount);
            if (mincount <= maxcount) {
                System.out.println("***");
                while (mincount > 0 && b > 0) {
                    input[mincount - 1]++;
                    mincount--;
                    b--;
                }
            } else {
                while (maxcount > 0 && b > 0) {
                    input[length - 1]--;
                    maxcount--;
                    b--;
                }
            }

            Arrays.sort(input);
        }

        return Math.abs(input[length - 1] - input[0]);
    }

    public static int findMins(int[] input) {
        int count = 1;
        for (int i = 1; i < input.length; i++) {
            if (input[i] == input[i - 1]) {
                count++;

            } else {
                return count;
            }
        }
        return count;
    }

    public static int findMaxs(int[] input) {
        int count = 1;
        for (int i = input.length - 1; i >= 1; i--) {
            if (input[i] == input[i - 1]) {
                count++;
            } else {
                return count;
            }
        }
        return count;
    }

    public int gcd(int A, int B) {
        if (B == 0) {
            return A;
        } else
            return gcd(B, A % B);
    }

    public int solvemax(int[] A) {
        int[] p = new int[A.length];
        int[] s = new int[A.length];
        p[0] = A[0];
        int maxgcd = 0;
        s[A.length - 1] = A[A.length - 1];
        for (int i = 1; i < A.length; i++) {
            p[i] = gcd(p[i - 1], A[i]);
        }
        for (int i = A.length - 2; i > -1; i--) {
            s[i] = gcd(s[i + 1], A[i]);
        }
        for (int i = 0; i < A.length; i++) {
            if (i == 0) {
                maxgcd = maxgcd < s[1] ? s[1] : maxgcd;
            } else if (i == A.length - 1) {
                maxgcd = maxgcd < p[1] ? p[1] : maxgcd;
            } else {
                maxgcd = maxgcd < gcd(p[i - 1], s[i + 1]) ? gcd(p[i - 1], s[i + 1]) : maxgcd;
            }
        }
        return maxgcd;
    }

}
