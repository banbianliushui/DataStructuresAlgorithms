package sort;

/**
 * 冒泡排序交换排序之一，交换排序根据数据元素的大小将数据交换来进行排序。包括冒泡和快速排序。
 *
 */
public class BubbleSort {
	public static void main(String [] args){
		int [] arr ={44,12,53,20,61,6,33,23,5};
		bubblesort(arr);
		showarr(arr);
		System.out.println("");
		bubblesort1(arr);
		showarr(arr);
	}
	/**
	 * 冒泡排序
	 * 基本思想：在要排序的一组数中，对当前还未排好序的范围内的全部数，自上而下堆相邻的两个数依次进行比较
	 * 和调整，让较大的数往下沉，较小的往上冒。即每当相邻的数比较后发现他们的排序和排序要求相反时，就将他们互换。
	 * 从小到大排序：从后向前比较，把小的往前冒或从前向后比较，把大的往后冒
	 * 
	 * 时间复杂度：O(n2)  n的平方，原始序列有序则时间复杂度是O(n).
	 * 稳定性：稳定
	 * @param arr
	 */
	public static void bubblesort(int [] arr){//从前往后冒，把最大的放在最后
		for(int i = 0;i<arr.length;i++){	//i表示需要排序的元素个数		
			for(int j=0;j<arr.length-1-i;j++){
				if(arr[j]>arr[j+1]){
					int temp = arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
		
	}
	public static void bubblesort1(int [] arr){//从后往前冒，把最小的放最前面
		for(int i = 0;i<arr.length-1;i++){			
			for(int j=arr.length-1;j>i;j--){
				if(arr[j-1]>arr[j]){
					int temp = arr[j-1];
					arr[j-1]=arr[j];
					arr[j]=temp;
				}
			}
		}
		
	}
	public static void showarr(int [] arr){
		for(int i =0; i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
	}
}
