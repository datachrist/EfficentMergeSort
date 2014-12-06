package mergeSortPackage;

public class EvenBetterMergeSort {

	public static int mSort(int[] A, int[] B, int p, int r) {
		int h1,h2;
		if (p < r) {
			int q = (p + r) / 2;
			h1 = mSort(A, B, p, q);
			h2 = mSort(A, B, q + 1, r);
			try {
				if (h1 != h2) {
					throw new Exception();
				}
			} catch (Exception e) {
				System.out.println("not power of 2");
			 }
				if ((h1 % 2) != 0) {
					merge(B, A, p, q, r);
				} else {
					merge(A, B, p, q, r);
				}
				return (h1 + 1);
			}
		
		return 0;
	}
	
	public static void  merge(int[] src,int[] dest,int p,int q,int r){
		int i=p,j=q+1;
		for(int k=p;k<=r;k++){
			if((j>r)||((i<=q)&&(src[i]<=src[j]))){
				dest[k]=src[i++];
			}
			else{
				dest[k]=src[j++];
			}
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    int n = Integer.parseInt(args[0]);
        int[] A = new int[n],B = new int[n];
        System.out.print("n:"+n);
        for (int i = 0; i < n; i++) {
            A[i] = n-i;           
        }
	long start = System.currentTimeMillis();
	mSort(A,B, 0, n-1);
	long last = System.currentTimeMillis();
	int i=0;
	while(n!=1){		
		n/=2;
		i++;
	}
	if (i%2!=0)
		A=B;
	
		for (int j = 0; j < A.length - 1; j++) {
	//		System.out.println("array: " + A[j]);
			if (A[j] > A[j + 1]) {
				System.out.println("Sorting failed :-(");
				return;
			}
		}
	System.out.println("Success!");
	System.out.println("Total Running Time taken by Merge Sort: "+(last - start)+"milliSecs");
    }
	

}
