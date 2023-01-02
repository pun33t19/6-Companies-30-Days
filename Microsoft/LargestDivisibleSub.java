package Microsoft;

import java.util.*;

// Dp and memoization could be used to find the length of longest divisible subset
//then after tabulating u need to use a hash aaray to store indexes of elements to be included in the answer

class Solution5 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> l = new ArrayList<>();

        // stores the longest dubset
        int[] dp = new int[nums.length];
        // stores the index of previous element to be included in list of longest
        // divisible subset
        int[] hash = new int[nums.length];

        Arrays.fill(dp, 1);
        for (int i = 0; i < hash.length; i++)
            hash[i] = i;

        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= i - 1; j++) {

                // we check all the previous elements of curr index and if we find something
                // divisble by curent element
                if (nums[i] % nums[j] == 0) {
                    // we check if its inclusion increases the length of current longest or not and
                    // accordingly update the
                    // dp array as well as the hash array
                    if (1 + dp[j] > dp[i]) {
                        dp[i] = 1 + dp[j];
                        hash[i] = j;
                    }

                }
            }

        }

        int max_ind = 0;
        int max_len = -1;

        // finding the index of longest subset and backtracking the hash array to get
        // the subset
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] > max_len) {
                max_len = dp[i];
                max_ind = i;
            }
        }

        // System.out.println(max_ind+" "+Arrays.toString(hash));

        while (hash[max_ind] != max_ind) {
            l.add(nums[max_ind]);
            max_ind = hash[max_ind];

        }

        l.add(nums[max_ind]);
        Collections.reverse(l);
        return l;

    }

}

public class LargestDivisibleSub {
    public static void main(String[] args) {
        Solution5 s = new Solution5();
        int[] nums = { 1, 2, 3 };

        System.out.println(s.largestDivisibleSubset(nums));
    }
}
