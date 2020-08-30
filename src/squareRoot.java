public class squareRoot {
    public int sqrt(int A) {
        int l=1;
        int r = (A/2)+1 ;
        int squareRoot = 1;

        while(l<=r){
            int mid = l+((r-l)/2);
            long square = mid*mid;
            if( square <= A){
                squareRoot = mid;
                l = mid+1;
            }else{
                r= mid-1;
            }
        }
        return squareRoot;

    }
}
