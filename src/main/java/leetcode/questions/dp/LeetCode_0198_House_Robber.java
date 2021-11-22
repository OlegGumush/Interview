package leetcode.questions.dp;

//        198. House Robber
//        You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed,
//        the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and
//        it will automatically contact the police if two adjacent houses were broken into on the same night.
//        Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

//        Example 1:
//        Input: nums = [1,2,3,1]
//        Output: 4
//        Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
//        Total amount you can rob = 1 + 3 = 4.

//        Example 2:
//        Input: nums = [2,7,9,3,1]
//        Output: 12
//        Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
//        Total amount you can rob = 2 + 9 + 1 = 12.

public class LeetCode_0198_House_Robber {

    public static void main(String[] args) {

        System.out.println(rob(new int[]{2, 1, 1, 2}));
    }

    public static int rob(int[] nums) {

        int houseRobbed = 0;
        int houseNotRobbed = 0; // house not robbed

        for (int i = 0; i < nums.length; i++) {

            int curr = houseNotRobbed + nums[i]; // not robbed earlier, so rob curr one i.e. i th one, as let i-1 is not robbed
            houseNotRobbed = Math.max(houseRobbed, houseNotRobbed); // max of robed and not robbed house
            houseRobbed = curr; // robbed curr house
        }
        return Math.max(houseRobbed, houseNotRobbed); // max of robbed and not robbed
    }

    public static int robWithSpace(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int arr[] = new int[nums.length];
        arr[0] = nums[0];
        arr[1] = Math.max(nums[1], nums[0]);

        for (int i = 2; i < nums.length; i++) {
            arr[i] = Math.max(arr[i - 1], arr[i - 2] + nums[i]);
        }
        return Math.max(arr[nums.length - 1], arr[nums.length - 2]);
    }
}