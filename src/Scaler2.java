import java.util.ArrayList;
import java.util.List;

public class Scaler2 {

    private static int[] solve(int[] A, int[] B) {

        int index = 0;
        int count = 0;

        int[] output = new int[B.length];

        for (int i = 0; i < B.length; i++) {
            int[] divisors = findDivisors(B[i]);

            for (int j = 0; j < divisors.length; j++) {
                if (A[divisors[j] - 1] != 0) {
                    A[divisors[j] - 1]--;
                }
            }
            count = 0;
            for (int j = 0; j < A.length; j++) {
                if (A[j] == 0) {
                    count++;
                }
            }

            output[index] = count;
            index++;
        }

        return output;
    }

    private static int[] findDivisors(int input) {

        List<Integer> div = new ArrayList<>();

        for (int i = 1; i <= input; i++) {
            if (input % i == 0) {
                div.add(i);
            }
        }

        int[] array = div.stream().mapToInt(i -> i).toArray();


        return array;
    }

    private static int scaler(int[] arr, int sum) {

        int start = 0;
        int end = arr.length - 1;

        int count = 0;
        while (start < end) {
            if ((2 * arr[start]) + arr[end] >= sum) {
                int temp = end - start;
                count = count + temp;
                end--;
            } else {
                start++;
            }
        }


        for (int i = 0; i < arr.length; i++) {
            if (3 * arr[i] >= sum) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {

//        int div[] = solve(new int[]{3, 1, 4, 2}, new int[]{2, 4, 3});

//        int div[] = findDivisors(7);

        int[] arr = new int[]{2, 3, 5, 8, 10};
        //int count = scaler(arr, 12);
        //System.out.println(count);

        int count=0;
        for(int i=1; i<=500; i++){
            if(i%3 ==0 || i%7 ==0 || i%9 ==0){
                count++;
            }

        }
        System.out.println(count);
    }


}
