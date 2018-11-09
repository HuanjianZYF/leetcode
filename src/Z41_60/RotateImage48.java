package Z41_60;

/**
 * @author zyf
 * @date 2018/9/20 下午2:01
 */
public class RotateImage48 {
	
	public static void main(String[] args) {
		int[][] matrix = new int[][]{{1,2,3,4,5}, {5,6,7,8,9}, {9,10,11,12,13}, {13,14,15,16,17}, {0,0,0,0,0}};
		new RotateImage48().rotate(matrix);
		for (int i = 0; i < matrix[0].length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println("");
		}
	}

	/**
	 *  1  2  3  4       13  9  5  1
	 *  5  6  7  8  ->   14 10  6  2
	 *  9 10 11 12       15 11  7  3
	 * 13 14 15 16       16 12  8  4
	 * 观察一下，发现可以把方阵的外边界分割成几个正方形，对正方形的每个顶点做移位即可，
	 * 之后再把问题归约到 旋转里面的正方形，重点在只能用常量的空间
 	 */
	public void rotate(int[][] matrix) {
		int size = matrix[0].length; //矩阵的维度
		
		//就像剥壳一样，需要剥size / 2次，i代表每一次剥的深度
		for (int i = 0; i <= size / 2; i++) {
			int start = i; //要剥的壳的开始
			int end = size - 1 - i; //要剥的壳的末尾
			
			if (start == end) { //表示里面只有一个边长为1的方阵
				continue;
			}

			//将一层外壳分成size - 1个四元组，并将每一个四元组做一次右移
			for (int j = start; j <= end - 1; j++) {
				doTransfer(matrix, i, j - i, end);
			}
		}
	}

	/**
	 * 旋转某个矩阵外壳上的四元组
	 * @param matrix 数组
	 * @param start 矩阵的开头                 
	 * @param div 相对于开头的偏移量
	 * @param end 矩阵的末尾，相当于大小减1
	 */
	private void doTransfer(int[][] matrix, int start, int div, int end) {
		int tmp = matrix[start][start + div];
		matrix[start][start + div] = matrix[end - div][start];
		matrix[end - div][start] = matrix[end][end - div];
		matrix[end][end - div] = matrix[start + div][end];
		matrix[start + div][end] = tmp;
	}

}
