import sun.awt.image.ImageWatched;

import java.util.*;
import java.util.LinkedList;

public class Scaler1 {

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

    private static int scalar(int[] arr, int sum){
        int[] outputArray = new int[arr.length];
        int count = 0;
        int counter=0;
        for(int i=0; i<outputArray.length; i++){
            outputArray[i]= -1;
        }
        for(int j=0; j< arr.length; j++){
            if(sum>2*arr[j]){
                outputArray[j]= sum-2*arr[j];
            }else{
                outputArray[j]=0;
            }

            count = findGreaterthanInoutputArray(outputArray, arr[j]);
            counter=counter+count;
            count=0;
        }
       return counter;

    }

    public static int findGreaterthanInoutputArray(int[] arr, int value){
        int count=0;
        for(int i=0; i<arr.length;i++){
            if(arr[i]!= -1){
                if(arr[i]<= value){
                    count++;
                }
            }
        }
        return count;
    }

    static int count(String a, String b, int m, int n, List<Integer> output, int min, int[] arr)
    {
        // If both first and second string is empty,
        // or if second string is empty, return 1
        int weight=0;
        int[] array = output.stream().mapToInt(i -> i).toArray();
        if ((m == 0 && n == 0) || n == 0){
            for(int i=0; i<array.length;i++){
                weight= weight+arr[array[i]];
            }
            System.out.println(weight);
            output= new ArrayList<>();
            return 1;}

        // If only first string is empty and
        // second string is not empty, return 0
        if (m == 0)
            return 0;

        // If last characters are same
        // Recur for remaining strings by
        // 1. considering last characters of
        // both strings
        // 2. ignoring last character of
        // first string
        if (a.charAt(m - 1) == b.charAt(n - 1)) {
            //System.out.println("****"+m+a.charAt(m-1));
            output.add(arr[m-1]);
            return count(a, b, m - 1, n - 1,output,min, arr) +
                    count(a, b, m - 1, n,output,min, arr);
        }
        else {
            // If last characters are different,
            // ignore last char of first string
            // and recur for  remaining string
            return count(a, b, m - 1, n,output,min, arr);
        }
    }

//    public static int count (String a, String b, int[] arr)
//    {
//        char[] ch = new char[a.length()];
//       List<Integer> output = new ArrayList<>();
//
//        // Copy character by character into array
//        for (int i = 0; i < a.length(); i++) {
//            ch[i] = a.charAt(i);
//        }
//
//        char[] ch2 = new char[b.length()];
//
//        // Copy character by character into array
//        for (int i = 0; i < b.length(); i++) {
//            ch[i] = b.charAt(i);
//        }
//        int i=0,j =0;
//        while (i<a.length() || j<b.length()){
//            if(ch[i]== ch2[j]){
//                i++;
//                j++;
//                output.add(arr[i]);
//            }else if(ch[i] != ch2[j]){
//                i++;
//
//            }else if(j == b.length()){
//
//            }
//        }
//
//    }

    public static int gcdCalculate(int[] arr){
        int gcd =0;
        for(int i=0;i< arr.length; i++){
            gcd = GCD(gcd,arr[i]);
        }

        return gcd;
    }

    public static int GCD(int a, int b){
        if(a==0 && b ==0){
            return  0;
        }
        else if(a==0){
            return b;
        }
        else if(b==0){
            return a;
        }
        else
            return GCD(b, a%b);
    }

    public static int waterCount( List<Integer> arr){
        int maxValueLeft=0;
        int maxValueRight=0;
        int[] prefixMax = new int[arr.size()];
        int[] postfixMax = new int[arr.size()];
        int watercount=0;
        for(int i=0; i< arr.size(); i++){
            if(maxValueLeft < arr.get(i)){
                maxValueLeft = arr.get(i);
                prefixMax[i]= maxValueLeft;
            }else{
                prefixMax[i]= maxValueLeft;
            }
        }

        for(int i = arr.size() -1 ; i>= 0 ; i--){
            if(maxValueRight < arr.get(i)){
                maxValueRight = arr.get(i);
                postfixMax[i]= maxValueRight;
            }else{
                postfixMax[i]= maxValueRight;
            }
        }
        for(int i=1; i< arr.size()-1; i++){
            if(postfixMax[i]>= prefixMax[i]){
                watercount = watercount+(prefixMax[i]- arr.get(i));
            }else{
                watercount = watercount+(postfixMax[i]-arr.get(i));
            }
        }
       return watercount;

    }

     static class Bucket{
        int max;
        int min;

        Bucket(){
            max= Integer.MIN_VALUE;
            min= Integer.MAX_VALUE;
        }
    }

    public static int maxgap(int[] A){
        int maxArray=0;
        int minArray=0;
        int index=0;
        for(int i=0; i< A.length; i++){
            if(A[i] <= minArray ){
                minArray = A[i];
            }
            if(A[i] >= maxArray){
                maxArray = A[i];
            }
        }
        if(A.length ==0 || A.length ==1){
            return 0;
        }
        if(minArray == maxArray){
            return 0;
        }
        int bucketSize = (maxArray - minArray)/(A.length-1);
        Bucket[] bucketArray = new Bucket[A.length+1];
        for(int i=0; i< bucketArray.length; i++){
            bucketArray[i] = new Bucket();
        }

        for(int i=0; i< A.length; i++){
            index = (A[i]- minArray)/bucketSize;
            if(bucketArray[index].min >= A[i]){
                bucketArray[index].min = A[i];
            }
            if(bucketArray[index].max <= A[i]){
                bucketArray[index].max = A[i];
            }
        }
        int maxGap =0;
        for(int i=0;i<bucketArray.length-1; i++){
            while(bucketArray[i].min == Integer.MAX_VALUE){
                i++;
            }
            int j=i+1;
            while(j< bucketArray.length && bucketArray[j].min == Integer.MAX_VALUE){
                j++;
            }
            if( j< bucketArray.length && (bucketArray[j].min - bucketArray[i].max) > maxGap){
                 maxGap = bucketArray[j].min - bucketArray[i].max;
            }
            i=j-1;
        }

        return maxGap;
    }

    public static int checkPalandrom( String A){
        char[] c = A.toCharArray();
        if(A.length() == 1 || A.length() ==0){
            return 1;
        }
        for(int i=0; i<= (A.length()-1)/2; i++)
        {
            if(A.charAt(i) != A.charAt(A.length()-1-i)){
                return 0;
            }
        }
        return 1;
    }

    public static int stringToInt( String A){
        int value=0;
        if(A.length() ==0 ){
            return -1;
        }
        if(A.length() ==1){
            return Integer.parseInt(A);
        }
        for(int i=0; i< A.length(); i++){
            value= value*10 + Integer.parseInt(String.valueOf(A.charAt(i)));
        }
        return value;

    }

    public static int reverseInt(int A){
        int digit = 0;
        int answer =0;
        while(A!=0) {
             digit = A % 10;
             A = A / 10;
             answer = answer*10 +digit;
        }
        return answer;
    }

    public static int wordcount(String A){
        if(A.length() ==0){
            return 0;
        }
        A= A.trim();
        int count =0;
        List<Character> items = Arrays.asList(' ', '\n', '\t');
        for(int i=0; i< A.length()-1; i++){
            if(items.contains(A.charAt(i)) && !items.contains(A.charAt(i+1))){
              count++ ;
            }
        }

        return count+1;
    }

    public static int wordcount1(String A){
        int state =0;
        int wc=0;
        List<Character> items = Arrays.asList(' ', '\n', '\t');
        for( int i=0; i< A.length(); i++){
            if( items.contains(A.charAt(i))){
                state =1;
            }else if( state== 1){
             wc++;
             state=0;
            }
        }

        return wc;
    }

    public static void printpairs( int[] A , int Sum){
        Map<Integer,Integer> indexStore = new HashMap<>();
        for( int i=0 ; i< A.length; i++){
            if(indexStore.containsKey(A[i])){
                System.out.println(indexStore.get(A[i])+"   "+i);
            }else{
                indexStore.put(Sum-A[i],i);
            }
        }
    }

    public static int printFibo( int N){
        if(N==1 || N==2){
           return 1;
        }
        else{
            int num1=1;
            int num2=1;
            int fib = 0;
            for(int i=3;i<= N; i++){
                fib = num1+num2;
                num1= num2;
                num2= fib;

            }
         return fib;
        }
    }

    public static int reverseString( String A){
        String reverse = reverse(A);
        System.out.println(reverse);
        if(A.equals(reverse)){
            return 1;
        }else return 0;
    }

    public static String reverse( String A){
        if(A== null || A.isEmpty()){
            return A;
        }
        else
            System.out.println(A.substring(0,A.length()-1));
            return A.charAt(A.length()-1)+reverse(A.substring(0,A.length()-1));
    }

    public static void main(String[] args) {

//        int div[] = solve(new int[]{3, 1, 4, 2}, new int[]{2, 4, 3});

//        int div[] = findDivisors(7);

        int[] arr = new int[]{1,0,9,5,8,2,0,2,8,10};
      //  int count = scalar(arr, 12);
//        List<Integer> output = new ArrayList<>();
//        int min =0;
//        String a = "abbaba";
//        String b="ab";
//        int count= count(a,b,a.length(),b.length(), output, min,arr);
//        System.out.println(count);
//int watercount = waterCount(arr);
        //int gcd = gcdCalculate(arr);
        //int ispalan = checkPalandrom("malayalam");
        //System.out.println(ispalan);
       // int value = reverseInt(128766);
       // int value = wordcount1("    java is great\n !\t\t\n    ok   ");
        //printpairs(arr, 10);
       // int fib = printFibo(10);
        //System.out.println(fib);
//        int palan = reverseString("abccba");
//        System.out.println(palan);
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        for (int i = 0; i < arr.length; i++) {
            hm.put(arr[i], i);
        }
        System.out.println(hm.keySet().toArray().length);
    }


}
