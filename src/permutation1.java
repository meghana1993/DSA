public class permutation1 {
    private static final int M = 1000003;

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    private static long power(long a, long b, int p) {
        if (b == 0) {
            return 1L;
        } else if (a == 0) {
            return 0L;
        } else if (b % 2 == 0) {
            return power((a * a) % p, b / 2, p);
        } else {
            return (a * (power((a * a) % p, (b - 1) / 2, p) % p)) % p;
        }
    }

    private static long inverseMod(long a, int p) {
        return power(a, p - 2, p);
    }

    public static int findRank(String a) {
        int n = a.length();
        long[] facts = new long[n + 1];
        long[] inversefacts = new long[n + 1];
        facts[0] = inversefacts[0] = 1;
        for (int i = 1; i <= n; i++) {
            facts[i] = (facts[i - 1] * i) % M;
            inversefacts[i] = inverseMod(facts[i], M);
        }

        int[] c = new int[256];
        for (char ch : a.toCharArray()) {
            c[ch]++;
        }

        long rank = 0;
        int count = a.length();
        for (char ch : a.toCharArray()) {
            count--;
            for (int t = 0; t < ch; t++) {
                if (c[t] > 0) {
                    c[t]--;
                    long numerator = facts[count];
                    for (int i = 0; i < 256; i++) {
                        if (c[i] > 0) {
                            numerator = (numerator * inversefacts[c[i]]) % M;
                        }
                    }
                    rank = (rank + numerator) % M;
                    c[t]++;
                }
            }
            c[ch]--;
        }
        return new Long((rank + 1) % M).intValue();
    }

    //        private static int o(char ch) {
//            if (ch <= 'Z') return ch - 'A';
//            return ch - 'a' + 26;
//        }
//
//        public static long modExp(long xint, long yint) {
//            long res = 1;
//            long x = xint;
//            long y = yint;
//            //System.out.println("Exp " + x + " " + y + " " + res);
//            while (y > 0) {
//                if ((y & 1) == 1) {
//                    res = (res * x) % M;
//                }
//                x = (x * x) % M;
//                y >>= 1;
//                //System.out.println("Exp " + x + " " + y + " " + res);
//            }
//            //return new Long(res).intValue();
//            return res;
//        }
    public static void main(String[] args) {

        System.out.println(findRank("acddbb"));


    }
}


