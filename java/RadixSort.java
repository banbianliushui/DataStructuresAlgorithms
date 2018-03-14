package sort;

/**
 * 基数排序：基数排序(radix sort)又称桶排序（bucket sort），相对于常见的比较排序，基数排序是一种分配式排序，
 * 即通过将所有数字分配到应在的位置最后再覆盖到原数组完成排序的过程。
 *
 */
public class RadixSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr ={4,59,1,61,115,31,22,7};
		radixsort(arr);
		showarr(arr);
		int [] arr1 ={4,59,1,61,115,31,22,7};
		radixsort2(arr1);
		showarr(arr1);
		
	
	
	}
	
	/**
	 * 基本思路：从低位数（个位数）开始排序，然后高位数覆盖低位数的排序。
	 * 当有数据位数小于当前判断位数时，直接将其放入待排序数组中，这些数据已经是有序，
	 * 因为之前步骤较低位排序时他们已经有序。
	 * 
	 * 这里对于十进制数排序，需要一个二维数组分别存放某位上0~9对应的数据。
	 * 还需要一个记录二维数组中放入数据的下标。
	 
	 最好的情况与最坏的情况在时间上是一致的，均为 O(d * (n + r))。
	 * @param arr
	 */
	public static void radixsort(int [] arr){ 		
		
		boolean tag = true;
		while (tag){			
			for(int i =1;;i=i*10){// i表示 位数1(一位),10(2位，十位),100(三位)..
				int [] []  temparr = new int [10][arr.length];				
				int [] order = new int[10];
				int c =0;
				boolean   innertag = false;
				for(int j = 0 ;j<arr.length;j++){
					int temp = arr[j]/i ;
					if(temp >0){
						//为了区分当前位数是否还有数据所以这里不考虑temp为0.如果length都是temp=0表示已经排序完了。
						//也可考虑进temp=0，但innertag 记录的还是至少有一个数据在当前位上大于0的情况
						innertag = true;
						for(int m =0 ;m<temparr.length;m++){
							if(temp%10==m){
								temparr[m][order[m]]=arr[j];
								order[m]++;
								break;
							}
						}
					}else{//当数值位数小于当前比较的位数直接存数组中。
						arr[c++]=arr[j];
					}
					
				}
				
				if(!innertag){
					tag = false;
					break;
				}
				
				for(int  n =0 ;n<10;n++){
					for(int p = 0 ;p<order[n];p++){
						arr[c++] = temparr[n][p];
					}
				}
			}
			
		}
		
	
		
	}
	

public static void radixsort2(int [] arr){ 		
		
		boolean tag = true;
		while (tag){			
			for(int i =1;;i=i*10){// i表示 位数1(一位),10(2位，十位),100(三位)..
				int [] []  temparr = new int [10][arr.length];//这个可以不用吗每次初始化				
				int [] order = new int[10];
				int c =0;
				boolean   innertag = false;
				for(int j = 0 ;j<arr.length;j++){
					int temp = arr[j]/i ;
					if(temp >=0){
						if(temp>0){
							innertag = true;
						}
						
						for(int m =0 ;m<temparr.length;m++){
							if(temp%10==m){
								temparr[m][order[m]]=arr[j];
								order[m]++;
								break;
							}
						}
					}else{
						
					}
					
				}
				
				if(!innertag){
					tag = false;
					break;
				}
				
				for(int  n =0 ;n<10;n++){
					for(int p = 0 ;p<order[n];p++){
						arr[c++] = temparr[n][p];
					}
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
