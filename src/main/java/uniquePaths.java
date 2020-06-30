/**
 * 不同路径：一个机器人位于一个 m x n 网格的左上角，起始点在下图中标记为“Start”。机器人每次只能向下或者向右移动一步。
 * 机器人试图达到网格的右下角，在下图中标记为“Finish”。
 *
 *
 * 问：总共有多少条不同的路径？
 * 动态规划方程：
 * dp[i][j]=dp[i-1][j]+dp[i][j-1];
 *
 * 最上和最左一列初始化为1
 */

public class uniquePaths {

    public  static  int result(int m,int n){
        if(m<0 || n<0 ){
            return 0;
        }
        int [][] dp=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i ==0|| j==0){
                    dp[i][j]=1;
                }else {
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        int result = result(7, 3);
        System.out.println(result);
    }
}
