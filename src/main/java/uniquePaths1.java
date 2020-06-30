/**
 * 不同路径：一个机器人位于一个 m x n 网格的左上角，起始点在下图中标记为“Start”。机器人每次只能向下或者向右移动一步。
 * 机器人试图达到网格的右下角，在下图中标记为“Finish”。
 *
 * 压缩空间解法：
 * dp【】【】其实只需要保存相对当前行的上一行数据即可 上上一行数据由于已经累计到上一行 所以 上上行其实没什么作用
 */
public class uniquePaths1 {

    public  static int result(int m,int n){
        int []dp=new int[n];
        for(int j=0;j<n;j++){
            dp[j]=1;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[j]+=dp[j-1];//此时j-1已经是新的一行的内容 而这一行的dp[j]由于还没有计算出来 所以仍然是上一行的内容
                // 这里dp[j-1]代表左边方格的 而dp[j]代表上面方格的

            }
        }
        return dp[n-1];

    }

    public static void main(String[] args) {
        int result = result(7, 3);
        System.out.println(result);
    }
}
