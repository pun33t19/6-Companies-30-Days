package Microsoft;

class Solution4 {
    public int maxRotateFunction(int[] nums) {
        int[] dp = new int[nums.length];
        int sum = nums[0];

        // calculate and store value of first F(0)
        for (int i = 1; i < nums.length; i++) {
            dp[0] += i * nums[i];
            sum += nums[i];
        }

        int res = dp[0];

        // F(0)=0*a+1*b+2*c+3*d
        // F(1)=0*d+1*a+2*b+3*c

        // F(1)-F(0)=a+b+c-3d
        // F(1)=F(0)+(a+b+c+d)-4d

        // Generalising the above equation

        // F(k)=F(k-1)+(sum of all elements in array)-(N*(N-i)th element of array)

        for (int i = 1; i < nums.length; i++) {
            dp[i] = dp[i - 1] + sum - ((nums.length) * nums[nums.length - i]);
            res = Math.max(res, dp[i]);
        }

        return res;
    }
}

public class RotateFunc {
    public static void main(String[] args) {
        int[] arr = { 4, 3, 2, 6 };

        System.out.println(new Solution4().maxRotateFunction(arr));
    }
}
