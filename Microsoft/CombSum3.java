package Microsoft;

import java.util.*;

class Solution {
    // a global list to maintain all the integer combinations
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> l = new ArrayList<>();

        f(k, n, l, 1, 0);

        return res;
    }

    public void f(int k, int n, List<Integer> l, int s, int sum) {

        // base cases
        if (l.size() == k) {
            if (sum == n) {
                res.add(new ArrayList<>(l));
                return;
            }
            return;
        }

        if (s > 9) {
            if (l.size() == k && sum == n) {
                res.add(new ArrayList<>(l));
                return;
            }
            return;
        }

        // iterate through each numbers and add it to list and also backtrack and remove
        // it from list to test other combinations

        for (int i = s; i <= 9; i++) {
            l.add(i);
            f(k, n, l, i + 1, sum + i);
            l.remove(l.size() - 1);
        }
    }
}

public class CombSum3 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        List<List<Integer>> l = sol.combinationSum3(3, 7);
        System.out.println(l);
    }
}
