package cn.sysu.edu.algorithm;

/*
 * ��Ŀ����
 * �����һ�������������ж���һ���������Ƿ����һ������ĳ�ַ��������ַ���·����
 * ·�����ԴӾ����е�����һ�����ӿ�ʼ��ÿһ�������ھ������������ң����ϣ������ƶ�һ�����ӡ�
 * ���һ��·�������˾����е�ĳһ�����ӣ���֮�����ٴν���������ӡ� 
 * ���� a b c e s f c s a d e e ������3 X 4 �����а���һ���ַ���"bcced"��·����
 * ���Ǿ����в�����"abcb"·������Ϊ�ַ����ĵ�һ���ַ�bռ���˾����еĵ�һ�еڶ�������֮��·�������ٴν���ø��ӡ�
 */
public class FindPath {

	static boolean flag = false;
	public static void isPath(char[][] mat, int row, int col, char[] str, int index, boolean[][] pos) {
        int rows = mat.length;
        int cols = mat[0].length;
        int len = str.length;
        if(index == len) {
        	flag = true;
        	return;
        }
            
        if((row-1 >= 0) && mat[row-1][col] == str[index] && pos[row-1][col]){
            pos[row-1][col] = false;
            isPath(mat, row-1, col, str, index+1, pos);
        }
        if((row+1 < rows) && mat[row+1][col] == str[index] && pos[row+1][col]){
            pos[row+1][col] = false;
            isPath(mat, row+1, col, str, index+1, pos);
        }
        if((col-1 >= 0) && mat[row][col-1] == str[index] && pos[row][col-1]){
            pos[row][col-1] = false;
            isPath(mat, row, col-1, str, index+1, pos);
        }
        
        if((col+1 < cols) && mat[row][col+1] == str[index] && pos[row][col+1]){
            pos[row][col+1] = false;
            isPath(mat, row, col+1, str, index+1, pos);
        }
        //return;
    } 
	public static void fill(boolean[][] pos) {
		for(int i = 0; i < pos.length; i++) {
			for(int j = 0; j < pos[0].length; j++) {
				pos[i][j] = true;
			}
		}
	}
	public static boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        char[][] mat = new char[rows][cols];
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                mat[i][j] = matrix[i*cols+j];
            }
        }
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
              if(mat[i][j] == str[0]) {
                  boolean[][] pos = new boolean[rows][cols];
                  fill(pos);
                  pos[i][j] = false;
                  isPath(mat, i, j, str, 1, pos);
                  if(flag) return true;
              }
            }
        }
        
        return false;
    }
	
	public static void main(String[] args) {
		String mat = "ABCEHJIGSFCSLOPQADEEMNOEADIDEJFMVCEIFGGS";
		System.out.println(mat.length());
		String s = "SLHECCEIDEJFGGFIE";
		System.out.println(s.length());
		char[] matrix = mat.toCharArray();
		char[] str = s.toCharArray();
		boolean bool = hasPath(matrix, 5, 8, str);
		System.out.println(bool);

	}

}
