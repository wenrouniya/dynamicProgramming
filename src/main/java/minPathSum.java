/**
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 分析：dp[i][j]的值只能从左边或者正上而来
 * 最后返回的结果 是包含最右下角的一个dp最小值
 * 动态方程：
 * dp[i][j]=Math.min(dp[i-1][j-1],dp[i-1][j];
 * 特殊情况：最上一行和最左一行
 * 最上：i==0 dp[i][j]=dp[i][j]+dp[i][j-1];
 * 最左：j==0 dp[i][j]=dp[i][j]+dp[i-1][j];
 * 空间优化：原来的二维数组中的数字只会被访问一次 所以直接将原来的二维数组编程dp数组
 */
public class minPathSum {

    public  static  int result(int [][] nums){
        int len=nums.length;
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums[i].length;j++){
                if(i==0&& j!=0){
                    nums[i][j]=nums[i][j]+nums[i][j-1];
                }else if(j==0 && i!=0){
                    nums[i][j]=nums[i][j]+nums[i-1][j];
                }else if(i !=0 && j!= 0){
                    nums[i][j]=nums[i][j]+Math.min(nums[i-1][j],nums[i-1][j]);
                }
            }
        }
        return nums[len-1][nums[len-1].length-1];
    }

    public static void main(String[] args) {
        int [] []  grid={{1,3,1},{1,5,1},{4,2,1}};
        int result = result(grid);
        System.out.println(result);
    }
}
