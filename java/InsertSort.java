package sort;

public class InsertSort {

	public static void main(String [] args){
		int [] arr ={44,12,53,20,61,6,33,23,5};
		insertSort(arr);
		showarr(arr);
	}
	
	/**
	 * 直接插入排序
	 * 基本思想：在要排序的一组数中，假设前面(n-1)[n>=2]个数已经排好顺序的，现在要把第
	 * n个数插到前面的有序数中，使得这n个数也是排好顺序的。如此反复循环，直到全部排好顺序。
	 * @param arr
	 */
	public static void insertSort(int [] arr){
		for(int i=1;i<arr.length;i++){
			int temp = arr[i];
			int j=i;
			for( ;j>0;j--){
				if(arr[j-1]>temp){
					arr[j]=arr[j-1];
				}else{
					
					break;
				}
			}
			arr[j] = temp;
		}	
		
	}
	
	public static void insertSort1(int [] arr){
		for(int i=1;i<arr.length;i++){
			int temp = arr[i];
			int j=i;
			for( ;j>0&&arr[j-1]>temp;j--){				
				arr[j]=arr[j-1];
				
			}
			arr[j] = temp;
		}	
		
	}
	
	public static void showarr(int [] arr){
		for(int i =0; i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
	}
}
