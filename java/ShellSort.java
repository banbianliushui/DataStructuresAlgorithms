package sort;

public class ShellSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr ={44,12,53,91,10,31,20,61,6,33,23,5};
		shellsort(arr);
		showarr(arr);
	}
	
	/**
	 * 希尔排序（最小增量排序）
	 * 基本思想：算法先将要排序的一组数按某个增量d (n/2，n为要排序数的个数)分成若干组，每组中记录
	 * 的下标相差d。对每组中全部元素进行直接插入排序，然后再用一个较小的增量(d/2)对它进行分组，在每组中
	 * 再进行直接插入排序。当增量减到1时，进行直接插入排序后，排序完成。
	 * 特性：In-place sort，unstable sort。 
		思想：每次找一个最小值。 
		最好情况时间：O(n)。 
		最坏情况时间：O(n^2)。
	 * @param arr
	 */
	public static void shellsort(int[] arr){
		int testnum =0;
		int movenum =0;
		int gap = arr.length/2;
		for(;gap>0;gap=gap/2){
			for(int i = gap;i<arr.length;i++){//i++  还是 i=i+gapn直接使用不符合希尔排序原理
				int temp = arr[i];
				int j = i;
				while(j-gap>=0&&arr[j-gap]>temp){
					arr[j]=arr[j-gap];
					j=j-gap;
					System.out.println("移动次数"+(++movenum));
				}
				System.out.println("赋值次数"+(++testnum));
				arr[j]=temp;
			}
		}		
		
	}
	
	
	public static void shellsort1(int[] arr){
		int testnum =0;
		int movenum =0;
		int gap = arr.length/2;
		for(;gap>0;gap=gap/2){
			for(int step = 0;step<gap;step++){
				for(int i = step+gap;i<arr.length;i=i+gap){//i++  还是 i=i+gap
					int temp = arr[i];
					int j = i;
					while(j-gap>=0&&arr[j-gap]>temp){
						arr[j]=arr[j-gap];
						j=j-gap;
						System.out.println("移动次数"+(++movenum));
					}
					System.out.println("赋值次数"+(++testnum));
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
