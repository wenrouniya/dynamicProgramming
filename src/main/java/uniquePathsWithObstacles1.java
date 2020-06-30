/**
 * 不同路径：一个机器人位于一个 m x n 网格的左上角，起始点在下图中标记为“Start”。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角，在下图中标记为“Finish”。
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 *
 * 同样 计算dp[j]只需要知道当前行的上一个格子和左边一个格子的值 所以 dp一维数组仍然可以解决
 */
public class uniquePathsWithObstacles1 {

    public static  int result(int [] []nums){
        int m=nums.length;
        int n=nums[0].length;
        int [] dp=new int[n];
        dp[0]=1;
        for(int j=1;j<n;j++){
            dp[j]=nums[0][j] ==1?0:dp[j-1];
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(nums[i][j] ==1){
                    dp[j]=0;
                }else if(j>0){//当第一列为障碍物时 在第一个if中置为0  若无障碍物则不处理 当第一个障碍物出现后 第一列再取到dp[0]的值都变成了0
                    dp[j]+=dp[j-1];
                }
            }
        }
        return dp[n-1];
    }
    public static void main(String[] args) {
        int [][]nums={{0,0,0},{0,1,0},{0,0,0}};
        int result = result(nums);
        System.out.println(result);
    }
}
