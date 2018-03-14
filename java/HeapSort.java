package sort;

/**
 * http://blog.csdn.net/pzhtpf/article/details/7559943
 * 
 * @author xiaozhu
 *
 */
public class HeapSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 44, 12, 53, 20, 61, 6, 33, 23, 5 };
		heapsort(arr);
	}

	/**
	 * 堆排序 基本思想：堆排序是一种树形选择排序，是对直接选择排序的有效改进。 堆定义：具有n个元素的序列（K1,K2,...Kn）,当且仅当满足(Ki
	 * <=K2i , Ki <= K2i+1) (i =1,2,...,n/2)时称之为堆,这是上小底大的堆。
	 * 由堆的定义可以看出，堆顶元素（即第一个元素）必为最小项（小顶堆）。完全二叉树可以很直观地表示堆的结构。
	 * 堆顶为根，其他为左右子树。初始时把要排序的数的序列看做是一棵顺序存储的二叉树，调整他们的存储顺序，
	 * 使之成为一个堆，这时堆的根节点的数最小。然后将根节点与堆的最后一个节点交换。然后对前面（n-1）个数
	 * 重新调整使之成为堆。以此类推，直到只有两个节点的堆，并对他们作交换，最后得到有n个节点的有序序列。 从算法描述来看，堆排序需要两个过程：
	 * 一是建堆。从堆定义出发，当i=1,2，...n/2时应满足Ki <=K2i 和Ki<=K2i+1。所以先取i=n/2
	 * (它一定是第n个节点双亲的编号)将以i节点为根的子树调整为堆；然后令i=i-1，再将以i节点为根的子树调整为堆。
	 * 此时可能会反复调整某些节点，直到i=1为止，堆初步建成。
	 * 调整堆时，先比较双亲节点的两个子节点的大小（如果有两个子节点的话），然后将比较得出较小的节点与
	 * 双亲节点比较，如果子节点比较小则将双亲节点和子节点位置调换,如果被调换的子节点还有子节点则需要继续调整以它为双亲的堆。
	 * 二是堆排序。首先输出堆顶元素，让堆中最后一个元素上移到原堆顶位置，然后恢复堆，因为经过上移堆顶元素的操作 后， 往往破坏了堆关系，所以要恢复堆。
	 * 最坏，最好，平均时间复杂度均为O(nlogn)
	  不稳定排序
	 * @param arr
	 */
	public static void heapsort(int[] arr) {
		for (int i = arr.length / 2; i >= 0; i--) {
			adjustheap(arr, i, arr.length);
		}
		int len=arr.length;
		int j=len-1;
		while(true){
			System.out.print(arr[0] + " ");			
			int temp = arr[0];
			arr[0]=arr[j];
			arr[j]=	temp;	
			for(int k =(j)/2;k>=0;k--){
				adjustheap(arr, k, j);
			}			
			j--;
			if(j<0){
				break;
			}
		}
		
		
	}

	public static void adjustheap(int[] arr, int parent, int len) {

		int j = parent;
		
		while (j * 2 < len) {
			int min = j * 2;
			if (j * 2 + 1 < len && arr[j * 2] > arr[j * 2 + 1]) {
				min = j * 2 + 1;
			}
			if (arr[min] < arr[j]) {
				int temp = arr[j];
				arr[j] = arr[min];
				arr[min] = temp;
				j = min;
			}else{
				break;
			}
			
		}

	}

	public static void showarr(int[] arr) {
		/*for (int i = 0; i < arr.length; i++) {

			System.out.print(arr[i] + " ");
		}*/
	}
}
