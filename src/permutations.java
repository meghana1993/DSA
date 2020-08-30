import java.util.*;

public class permutations {
    private static int p = (int)Math.pow(10,9)+7;
    private static long[] fact;
    private static HashMap<String,Long> duplicates = new HashMap<>();

    private static void constructFactorialArray(int n) {
        fact = new long[n + 1];
        fact[0] = 1;
        for (int i = 1; i <= n; i++)
            fact[i] = (fact[i - 1] * i) % p;

    }

    private static void updateRanks(char c, int[] ranks) {
        for (int i = c + 1; i < ranks.length; i++) {
            if(!duplicates.containsKey(String.valueOf(c)))
            ranks[i]--;
        }
        Iterator hmIterator = duplicates.entrySet().iterator();
        while (hmIterator.hasNext()) {
            Map.Entry mapElement = (Map.Entry)hmIterator.next();
            if(mapElement.getKey().toString().equalsIgnoreCase(String.valueOf(c))) {
                long value = (long) mapElement.getValue();
                value--;
                if (value == 1L) {
                    duplicates.remove(String.valueOf(c));
                } else {
                    duplicates.put(String.valueOf(c), value);
                }

            }
        }




    }

    private static long power(long a, long b, int p){
        if(b == 0){
            return 1L;
        }else if(a == 0){
            return 0L;
        }else if(b%2==0){
            return power((a*a)%p,b/2,p);
        }else {
            return (a * (power((a*a)%p,(b-1)/2,p)%p))%p;
        }
    }

    private static long inverseMod(long a, int p){
        return power(a,p-2,p);
    }

    public static int findRank(String A) {

        int length = A.length();
        int[] ranks = new int[256];

        //int[] ranks1 = new int[length];
        constructFactorialArray(length);

        for (int i = 0; i < length; i++){
            if(ranks[A.charAt(i)] == 1){
            if(duplicates.containsKey(A.charAt(i))){
                long value = duplicates.get(A.charAt(i));
                duplicates.put(String.valueOf(A.charAt(i)), value++);
            }else{
                duplicates.put(String.valueOf(A.charAt(i)), 2L);
            }
            }
            else {
                ranks[A.charAt(i)] = 1;
            }
        }

        for (int i = 1; i < ranks.length; i++)
            ranks[i] += ranks[i - 1];

        long ans = 0L;
        long numerator = 0L;
        long denominator = 1L;
        for (int i = 0; i < length; i++) {
            //System.out.println((ranks[A.charAt(i)] - 1) + " " + (length - i - 1));
            numerator =  (((ranks[A.charAt(i)] - 1) % p) * fact[length - i - 1]) % p;
            updateRanks(A.charAt(i), ranks);
            //ans = ans+numerator;
            denominator = 1L;
            Iterator hmIterator = duplicates.entrySet().iterator();
            while (hmIterator.hasNext()) {
                Map.Entry mapElement = (Map.Entry) hmIterator.next();
                //numerator = (numerator * inverseMod(fact[(int)(long)mapElement.getValue()], p))%p;
                denominator *= fact[(int)(long) mapElement.getValue()];
            }

           ans = (ans + numerator/denominator)%p;
        }

        return (int) (ans + 1) % p;
    }

    //////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////



    public static int l[][] ;

    public static void initialize(int N)
    {

        // 0C0 = 1
        l[0][0] = 1;
        for (int i = 1; i < N; i++) {
            // Set every nCr = 1 where r = 0
            l[i][0] = 1;
            for (int j = 1; j < i + 1; j++) {

                // Value for the current cell of Pascal's triangle
               // System.out.println((l[i - 1][j - 1] + l[i - 1][j]));
                l[i][j] = ((l[i - 1][j - 1] + l[i - 1][j])%M);
            }
        }
    }

    // Function to return the value of nCr
    public static int nCr(int n, int r)
    {
        // Return nCr
        //return l[n][r];
        int result=0;
        for(int line = 1; line <= n+1; line++)
        {

            long C=1;
            // used to represent C(line, i)
            for(int i = 1; i <= line; i++) {
                // The first value in a line is always 1
               System.out.print(C+" ");
//               long a
                C = (C%p) * (line - i)/i ;
                C = C%M;
                if(i == r)
                result =(int)C%M;
            }
            System.out.println();
        }
        return result;
    }

    public static int solve(int n, int r, int m) {
        //l = new int[n+1][n+1];
        M= m;
        int[] pascal = new int[r+1];
        pascal[0]= 1;
        for(int i = 1; i <= n; i++)
        {
            // Fill entries of current row using previous
            // row values
            for (int j = Math.min(i, r); j > 0; j--)

                // nCj = (n-1)Cj + (n-1)C(j-1);
                pascal[j] = (pascal[j] + pascal[j-1])%M;
        }
        return pascal[r];
        //M= m;
       // initialize(n+1);
        //return nCr(n,r);
        //return 0;

    }

  public static int M =0;

    public static void main(String[] args) {

       System.out.println(solve(6726,54,15428));
//        System.out.println(solve(100,5,13));
        //solve(6,2,13);

    }

}
