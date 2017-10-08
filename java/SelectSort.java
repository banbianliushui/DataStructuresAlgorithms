package sort;

public class SelectSort {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr ={44,12,53,20,61,6,33,23,5};
		
		/*for(int i =0;i<=0;i++){
			System.out.println("对对对");
		}*/
		selectsort(arr);
		showarr(arr);
	}
	/**
	 * 简单选择排序
	 * 基本思想：在要排序的一组数中，选出最小的一个数与第一个位置的数交换；
	 * 然后在剩下的数当中再找最小的与第二个位置的数交换，如此循环到倒数
	 * 第二个数和最后一个数位置。
	 * @param arr
	 */
	public static void selectsort(int[] arr){
		for(int i =0;i<arr.length;i++){
			int temp = arr[i];
			int min = i;
			int j=i+1;
			
			for(;j<arr.length;j++){
				if(arr[j]<temp){
					temp=arr[j];
					min=j;
				}
			}
			arr[min]=arr[i];
			arr[i]=temp;
					
		}
	}
	public static void showarr(int [] arr){
		for(int i =0; i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
	}
}
