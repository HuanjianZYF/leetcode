package forty_sixty;

/**
 * @author zyf
 * @date 2018/9/20 下午2:01
 */
public class RotateImage48 {

	/**
	 *  1  2  3  4       13  9  5  1
	 *  5  6  7  8  ->   14 10  6  2
	 *  9 10 11 12       15 11  7  3
	 * 13 14 15 16       16 12  8  4
	 * 观察一下，发现可以把方阵的外边界分割成几个正方形，对正方形的每个定点做移位即可，
	 * 之后再把问题归约到旋转里面的正方形，重点在只能用常量的空间
 	 */
	public void rotate(int[][] matrix) {
		int size = matrix[0].length; //矩阵的维度
		
		//就像剥壳一样，需要剥size / 2次，i代表每一次剥的深度
		for (int i = 0; i <= size / 2; i++) {
			int start = i; //bo
			int end = size - 1 - i;
		}
	}
}
