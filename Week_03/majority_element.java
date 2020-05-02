package assignments;

public class majority_element {
    class Solution {
        public int majorityElement(int[] nums) {
            int majorityElement = 0;
            Map<Integer,Integer> map = new HashMap<>();
            for (int x : nums) {
                if (!map.containsKey(x)) {
                    map.put(x , 1);
                } else {
                    map.put(x , map.get(x) + 1);
                }
            }
            for (int x : nums) {
                if (map.get(x) > nums.length/2) {
                    majorityElement = x;
                    break;
                }
            }
            return majorityElement;
        }
    }
}
