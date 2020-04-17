class Solution {
    /*input：一个数组和一个target
    操作：找出数组中相加等于target的两个数
    output：输出这两个数的下标
    **/

    public int[] twoSum(int[] nums, int target) {
        int [] ans = new int [2];
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0 ; i < nums.length ; i++) {
            int res = target - nums[i];
            if(map.containsKey(res) && map.get(res)!=i) {
                ans[0] = map.get(res);
                ans[1] = i;
            }
            map.put(nums[i],i);
        }
        return ans;

    }
}