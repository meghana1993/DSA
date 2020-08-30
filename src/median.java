public class median {
        public int findMedian(int[][] A) {
            int maxelement = Integer.MIN_VALUE;
            int minelement = Integer.MAX_VALUE;
            int N = A.length;
            int M= A[0].length;
            int[] maxMinElemtsCount = new int[2];
            int ans =0;
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    minelement= Math.min(minelement,A[i][j]);
                    maxelement= Math.max(maxelement,A[i][j]);
                }
            }
            int l= minelement;
            int r= maxelement;
            int mid = l+((r-l)/2);
            while(l<=r){
                maxMinElemtsCount = noOfelementgreaterThansmallerThanMedian(A,mid);
                if(maxMinElemtsCount[0] > maxMinElemtsCount[1]){
                    l = mid+1;
                }
                else if(maxMinElemtsCount[0] < maxMinElemtsCount[1]){
                    r= mid-1;
                }else{
                    ans =  ((N*M)%2 == 0) ? findMedianFromTwoElements(A, mid) : mid;
                    return ans;
                }

            }
            return ans;
        }

        public int[] noOfelementgreaterThansmallerThanMedian(int[][] a, int k){
            int N = a.length;
            int M = a[0].length;
            int noOfelementsSmall = 0;
            int noOfelementsGreater = 0;
            for(int i=0; i<N;i++){
                for(int j=0; j<M;j++){
                    if(a[i][j]< k){
                        noOfelementsSmall++;
                    }
                    if(a[i][j]> k){
                        noOfelementsGreater++;
                    }
                }
            }
            return new int[]{noOfelementsGreater,noOfelementsSmall};
        }

        public int findMedianFromTwoElements(int[][] a, int k){
            int N = a.length;
            int M = a[0].length;
            int nextMinElement = Integer.MIN_VALUE;
            int nextMaxElement = Integer.MAX_VALUE;
            for(int i=0;i<N; i++ ){
                for(int j=0; j<M; j++){
                    if(a[i][j] > k && a[i][j]<nextMaxElement ){
                        nextMaxElement = a[i][j];
                    }
                    if(a[i][j] < k && a[i][j]> nextMinElement){
                         nextMinElement = a[i][j];
                    }
                }
            }
            return ((nextMaxElement +nextMinElement)/2);

        }
}
