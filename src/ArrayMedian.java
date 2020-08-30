import java.util.ArrayList;
import java.util.List;

public class ArrayMedian {
        // DO NOT MODIFY BOTH THE LISTS
        public static int findKthSmallestElement(List<Integer> A, int k){
            int l =0;
            int r= A.get(A.size()-1);
            int ans =0;
            while(l<=r){
                int mid = l+((r-l)/2);
                if(countNoOfElementsLessThanK(A,mid) <=k){
                    ans = mid;
                    l=mid+1;
                }else
                    r= mid-1;
            }
            return ans;
        }

        public static int countNoOfElementsLessThanK(List<Integer> A , int k){
            int l=0;
            int r=A.size()-1;
            int ans =0;
            while(l<=r){
                int mid = l+ ((r-l)/2);
                if(A.get(mid) <= k){
                    ans = mid;
                    l=mid+1;
                }else{
                    r= mid-1;
                }
            }

            return ans;
        }

        public static double findMedianSortedArrays(final List<Integer> A, final List<Integer> B) {
            if(A.isEmpty() && !B.isEmpty()){
                return (double)findKthSmallestElement(B, (B.size()/2)+1);
            }
            if(B.isEmpty() && !A.isEmpty()){
                return (double)findKthSmallestElement(A, (A.size()/2)+1);
            }
            if(B.isEmpty() && A.isEmpty()){
                return (double)-1;
            }
            int totalElements = A.size()+ B.size();
            if(totalElements%2 == 0){
                // System.out.println((totalElements/2) +"  "+((totalElements/2)+1));
                //System.out.println(findKthSmallestElement(A, B, (totalElements/2)));
                //System.out.println(findKthSmallestElement(A, B, ((totalElements/2)+1)));
                long median = findKthSmallestElement(A, B, 5)
//                System.out.println(median);
//                median = findKthSmallestElement(A, B, 6) ;
//                System.out.println(median);
                + findKthSmallestElement(A, B, 6);
                 return median/2 ;
            }else{
                 return (double)findKthSmallestElement(A, B, ((totalElements/2)+1));
            }
            //return -1;
        }


        public static int findKthSmallestElement(List<Integer> A, List<Integer> B, int k){
            int max= Math.max(A.get(A.size()-1),B.get(B.size()-1) );
            int min = Math.min(A.get(0), B.get(0));
//            for(int i=0; i<A.size();i++){
//                max = Math.max(max, A.get(i));
//                min = Math.min(min,A.get(i));
//            }
//            for(int i=0; i<B.size();i++){
//                max = Math.max(max, B.get(i));
//                min = Math.min(min,B.get(i));
//            }
            int ans =0;
            int l = min;
            int r = max;
            System.out.println("l= "+l+"  "+"r= "+r);
            while(l<=r){
                int mid = l+ ((r-l)/2);
                // System.out.println("mid==  "+mid);
                // System.out.println("mid= "+mid+"  "+countNoOfelementsLessThanEqualToK(A,B,mid));
                if(countNoOfelementsLessThanEqualToK(A,B,mid) >= k){
                    ans = mid;
                    r=mid-1;
                }else{
                    l=mid+1;
                }

            }
            return ans;

        }

        public static int countNoOfelementsLessThanEqualToK(List<Integer> A, List<Integer> B , int k){
            int l=0;
            int r=A.size()-1;
            int count1=0;
            int count2 =0;
            int mid =0;
            while(l<=r){
                mid = l+ ((r-l)/2);
                //System.out.println("midInA= "+mid);
                if(A.get(mid)<= k){
                    count1= mid+1;
                    l=mid+1;
                }else{
                    r=mid-1;
                }
            }

            l=0;
            r= B.size()-1;
            while(l<=r){
                mid = l+ ((r-l)/2);
                if(B.get(mid)<= k){
                    count2= mid+1;
                    l=mid+1;
                }else{
                    r=mid-1;
                }
            }
            //System.out.println("CountA==  "+count1+"  "+"CountB== "+count2);
            return count1+count2;
        }

    public static void main(String[] args) {
       ArrayList<Integer> A = new ArrayList<>();
        ArrayList<Integer> B = new ArrayList<>();
       A.add(-40); A.add(-25); A.add(5); A.add(10); A.add(14); A.add(28); A.add(29);A.add(48);
       B.add(-45); B.add(-31); B.add(-15);B.add(-6); A.add(1);A.add(8);
       // A : [ -50, -41, -40, -19, 5, 21, 28 ]
       // B : [ -50, -21, -10 ]
        System.out.println(findMedianSortedArrays(A,B));
//        System.out.println(solve(100,5,13));
        //solve(6,2,13);

    }

}



