/**
 * 给定一个三角形，找出自顶向下的最小路径和。
 * 将三角形整合成如下形状
 * 2
 * 3 4
 * 6 5 7
 * 4 1 8 3
 * 即每次移动只能向下一个或者向右下一个
 * 动态转移方程：
 * 初始化 dp[0][0]=triangle[0][0];
 * dp[1][0]=dp[0][0]+triangle[1][0];
 * dp[1][1]=dp[0][0]+triangle[1][1];
 * 最左边一列 只能从正上方的元素的来  if(j==0) dp[i][j]=dp[i-1][j]+triangle[i][j]
 * 最右边一列 只能从左上方的来 if(j==triangle[i].length) dp[i][j]=dp[i-1][j-1]+triangle[i][j];
 * 普通方程 dp[i][j]=Math.min(dp[i-1][j-1]+triangle[i][j],dp[i-1][j]+triangle[i][j]);
 * triangle数组中的数字只会遍历一遍就不再使用 所以可以将triangle数组直接当成dp数组来使用  内存空间优化
 */
public class minimumTotal {

    public  static  int result(int [][] nums){

        if(nums.length<1){
            return  0;
        }
        if(nums[0].length<1){
            return 0;
        }
        if(nums[1].length<2){
            return nums[0][0]+nums[1][0];
        }
        nums[0][0]=nums[0][0];
        nums[1][0]=nums[0][0]+nums[1][0];
        nums[1][1]=nums[0][0]+nums[1][1];
        for(int i=2;i<nums.length;i++){
            for(int j=0;j<nums[i].length;j++){
                if(j ==0){
                    nums[i][j]=nums[i-1][j]+nums[i][j];
                }else if(j ==nums[i].length-1){
                    nums[j][j]=nums[i][j]+nums[i-1][j-1];
                }else{
                    nums[i][j]=Math.min(nums[i-1][j-1],nums[i-1][j])+nums[i][j];
                }
            }
        }
        int len=nums.length;
        int res=nums[len-1][0];
        for(int i=1;i<nums[len-1].length;i++){
            if(nums[len-1][i]<res){
                res=nums[len-1][i];
            }
        }
        return  res;

    }

    public static void main(String[] args) {

        int [][] triangle={{2},{3,4},{6,5,7},{4,1,8,3}};
        int result = result(triangle);
        System.out.println(result);
    }
}
