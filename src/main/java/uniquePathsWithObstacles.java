/**
 * 不同路径：一个机器人位于一个 m x n 网格的左上角，起始点在下图中标记为“Start”。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角，在下图中标记为“Finish”。
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 *
 *
 * 问总共有多少条不同的路径？
 * 动态方程：
 * dp[i][j]=dp[i-1][j]+dp[i][j-1]
 * 当有障碍物时 该点即为0
 * 若障碍物出现在第一行或者第一列的某个点  此点后的点都为0   代表此路不通
 */
public class uniquePathsWithObstacles {

    public  static  int result(int [][] nums){
        int m=nums.length;
        int n=nums[0].length;
        int [][]dp=new int [m][n];
        if(nums[0][0]!= 1){
            dp[0][0]=1;
        }
        for(int i=1;i<m;i++){//初始化第一行
            dp[0][i]=nums[0][i] ==1?0:dp[0][i-1];
        }
        for(int j=1;j<n;j++){//初始化第一列
            dp[j][0]=nums[j][0] ==1? 0:dp[j-1][0];
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                    dp[i][j]=nums[i][j]==1? 0:dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

    public static int uniquePathsWithObstacles1(int[][] obstacleGrid) {
           int m = obstacleGrid.length;
           int n = obstacleGrid[0].length;
           int[] dp = new int[n];
           dp[0] = 1;
           for (int[] ints : obstacleGrid) {
                     for (int j = 0; j < n; j++) {
                      if (ints[j] == 1) {
                              dp[j] = 0;
                          } else if (j > 0) {
                          System.out.print(dp[j-1] +"   ");
                          System.out.print(dp[j]+"   ");
                              dp[j] += dp[j - 1];
                          System.out.print(dp[j]);
                                System.out.println();

                          }
                        }
               }
             return dp[n - 1];
         }

    public static void main(String[] args) {
        int [][]nums={{0,0,0},{0,0,0},{0,0,0}};
        int result = uniquePathsWithObstacles1(nums);
        System.out.println(result);
    }
}
