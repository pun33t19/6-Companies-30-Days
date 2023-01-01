package Microsoft;

import java.util.*;

/**
 * BullsAnsCowsProb
 */

class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0, cows = 0;

        int n = secret.length();
        Map<Character, Integer> map = new HashMap<>();

        // mark all the characters of secret with their count in hashmap
        for (int i = 0; i < secret.length(); i++)
            map.put(secret.charAt(i), map.getOrDefault(secret.charAt(i), 0) + 1);

        // if secret and guess have chacaters at same positions increase bull count and
        // reduce its count in the map too
        for (int i = 0; i < n; i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls++;
                map.put(guess.charAt(i), map.get(guess.charAt(i)) - 1);
            }

        }

        // now check for the positions where characters don't match and increase cow
        // count
        for (int i = 0; i < n; i++) {
            if (secret.charAt(i) != guess.charAt(i) && map.getOrDefault(guess.charAt(i), -1) > 0) {
                map.put(guess.charAt(i), map.get(guess.charAt(i)) - 1);
                cows++;
            }

        }

        return bulls + "A" + cows + "B";
    }
}

public class BullsAnsCowsProb {

    public static void main(String[] args) {
        System.out.println(new Solution().getHint("1807", "7810"));
    }
}