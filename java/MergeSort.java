package sort;

/**
 * 归并排序
 * 基本思路：归并排序法是将两个（或两个以上）有序表合并成一个新的有序表，即把待排序序列分为若干个子序列，
 * 每个子序列都是有序的。然后再把有序子序列合并为整体有序序列。
 * 
 * 该算法是采用分治法（Divide and Conquer）的一个非常典型的应用。 将已有序的子序列合并，
 * 得到完全有序的序列；即先使每个子序列有序，再使子序列段间有序。若将两个有序表合并成一个有序表，称为2-路归并。

 * 
 *
 */
public class MergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr ={44,12,53,20,61,6,33,23,5};
		mergesort1(arr);
		showarr(arr);
		System.out.println("");
		
	}
	//非递归
	/**
	  * 具体实现：首先让子表表长L=1进行处理；不断使L=2*L,进行子表处理，直到L>=n为止，这里是主体函数的内容。
	  * 然后对于某确定的子表表长L，将n个记录分成若干组子表，两两归并，这里需要循环若干次，这一步需要另一个函数，可由主体函数调用。
	  * 最后在看每一组子表的归并。在具体实现两组子表归并时需要一个辅助数组。
	 * */
	public static void mergesort1(int[] arr){
		for( int l =1;l<arr.length;l=l*2){	//这里是每个子表中有l个数据，子表长度小于arr总表的长度		
			 for(int i =0;i<=arr.length/(2*l);i++){//
				int low=i*2*l;			
				int high=i*2*l+2*l-1;
				int mid=(low+high)/2;
				if(high>arr.length-1){
					high=arr.length-1;
					mid=low+l-1;
				}
				if(high-low+1>l){
					 merge(arr , low, mid , high);
				}
				
			 }
				
			}
	}
	public static void mergesort(int[] arr,int low , int high){
		
		 int mid = (low + high) / 2;  
	        if (low < high) {  
	            // 左边  
	        	mergesort(arr, low, mid);  
	            // 右边  
	        	mergesort(arr, mid+1 , high);  
	            // 左右归并  
	            merge(arr, low, mid, high);  
	        }  

	}
	/**
	 * 
	 * @param arr
	 * @param low 要排序的其中一个子表（位置较小）的开始下标
	 * @param mid 子表（位置较大）的开始下标
	 * @param high 另一个子表的结束下标
	 */
	public static void merge(int [] arr ,int low,int mid ,int high){
		int[] temparr = new int[high-low+1];
		int i = low;
		int j = high;
		int k  = mid+1;
		int count=0;
		while(k<=high&&i<=mid){//两组归并时只有有一个子表比较完就结束运行
			while(arr[i]<arr[k]&&i<=mid){
				temparr[count++] =arr[i++];
			}
			while(k<=high&&arr[k]<arr[i]){
				temparr[count++] =arr[k++];
			}
		}
		
		if(i<=mid){
			for(int m = i;m<=mid;m++){
				temparr[count++]=arr[m];
			}			
		}
		if(k<=high){
			for(int m = k;m<=high;m++){
				temparr[count++]=arr[m];
			}	
		}
		
		for(int n=low;n<=high;n++){
			arr[n] = temparr[n-low];
		}
		System.out.println();
		
	}
	
	
	
	 public static int[] sort(int[] nums, int low, int high) {  
	        int mid = (low + high) / 2;  
	        if (low < high) {  
	            // 左边  
	            sort(nums, low, mid);  
	            // 右边  
	            sort(nums, mid + 1, high);  
	            // 左右归并  
	            merge(nums, low, mid, high);  
	        }  
	        return nums;  
	    }  
	  
	    public static void merge1(int[] nums, int low, int mid, int high) {  
	        int[] temp = new int[high - low + 1];  
	        int i = low;// 左指针  
	        int j = mid + 1;// 右指针  
	        int k = 0;  
	  
	        // 把较小的数先移到新数组中  
	        while (i <= mid && j <= high) {  
	            if (nums[i] < nums[j]) {  
	                temp[k++] = nums[i++];  
	            } else {  
	                temp[k++] = nums[j++];  
	            }  
	        }  
	  
	        // 把左边剩余的数移入数组  
	        while (i <= mid) {  
	            temp[k++] = nums[i++];  
	        }  
	  
	        // 把右边边剩余的数移入数组  
	        while (j <= high) {  
	            temp[k++] = nums[j++];  
	        }  
	  
	        // 把新数组中的数覆盖nums数组  
	        for (int k2 = 0; k2 < temp.length; k2++) {  
	            nums[k2 + low] = temp[k2];  
	        }  
	    }  
	public static void showarr(int [] arr){
		for(int i =0; i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
	}
}
