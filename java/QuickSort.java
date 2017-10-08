package sort;

import java.util.ArrayList;

/**
 * 快速排序交换排序之一。
 * 快速排序是一种对冒泡排序的改进，其实质是对一组待排数据进行分区交换排序。
 *
 *http://www.cnblogs.com/sevenyuan/archive/2009/12/04/1616897.html
 *http://www.importnew.com/16266.html
 *http://blog.csdn.net/pzhtpf/article/details/7559896
 *http://blog.csdn.net/morewindows/article/details/6668714
 *http://blog.csdn.net/guanhang89/article/details/51902378
 http://blog.csdn.net/jianyuerensheng/article/details/51258374

 */
public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr ={44,12,53,20,61,6,33,23,5};
		quicksort(arr);
		showarr(arr);
		System.out.println("");
		int [] arr1 ={44,12,53,20,61,6,33,23,5};
		quicksort1(arr1,0,arr1.length-1);
		showarr(arr1);

	}
	/**
	 * 快速排序
	 * 基本思想： 选择一个基准元素，通常选择第一个元素或最后一个元素，通过一趟扫描，将待排序列分成两部分，
	 * 一部分比基准元素小，另一部分大于等于基准元素，此时基准元素在其排好序后的正确位置，
	 * 然后再用同样的方法递归地排序划分的两部分。
	 * 实现：如选择第一个元素为基准元素并记下基准元素，需要一个变量记录左边位置即第一个元素，右边记下最后一个元素。
	 * 然后从右边开始移动记录序列的位置，遇到数据小于基准值则把此数据交换到左边位置，然后从左边移动位置并比较数值大小
	 * 如果大于基准值则放到基准值的右边（即前一步右边记下的位置）。直到这左侧位置大于右侧时，这个基准值的位置确定。
	 * 
	 * @param arr
	 */
	//非递归快速排序。
	public static void quicksort(int [] arr){
		ArrayList stack = new ArrayList() ;		
		int [] posarr ={0,arr.length-1};
		stack.add(posarr);		
		while(stack.size()>0){
			int [] inpos =(int []) stack.get(0);
			stack.remove(0);
			int low = inpos[0];
			int high = inpos[1];
			int pos =hoare(arr,low,high);		
			if(low<pos-1){
				int [] posarr1 ={low,pos-1};
				stack.add(posarr1);
			}
			if(pos+1<high){
				int [] posarr2 ={pos+1,high};
				stack.add(posarr2);			
			}	
		}		
	}
	//递归快速排序
	public static void quicksort1(int [] arr,int low,int high){
		
		//while(true){}
		int pos =hoare(arr,low,high);
		if(low<pos-1){
			quicksort1(arr,low,pos-1);
		}
		if(high>pos+1){
			quicksort1(arr,pos+1,high);
		}
		
	}
	/**
	 * hoare霍尔提出
	 * @param arr
	 * @param low
	 * @param high
	 * @return 返回移动完成后确定的位置
	 */
	public static int hoare(int [] arr,int low,int high){
		int pos =-1;
		int temp = arr[low];
	
		while(low<high){
			while(temp<=arr[high]&&low<high){
				high--;
			}	
			if(temp>arr[high]){
				arr[low]=arr[high];
				//arr[high]=temp;
			}
			while(temp>=arr[low]&&low<high){
				low++;
			}
			if(temp<arr[low]){
				arr[high]=arr[low];
			}			
			
		}
		arr[low]=temp;
		pos = low;
		return pos;
	}
	public static void showarr(int [] arr){
		for(int i =0; i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
	}
}
