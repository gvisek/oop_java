package leetcode;

public class Solution2 {
    public int[] twoSum(int[] nums, int target) {
        int[] array = new int[2];
        for(int i = 0; i < nums.length; i++){
            array[0] = i;
            for(int j = 0; j < nums.length; j++){
                array[1] = j;
                if(nums[i] + nums[j] == target && i != j){
                    return array;
                }
            }
        }
        return null;
    }
    public static void main(String[] args){
        Solution2 s2 = new Solution2();
        int[] array = {2,7,11,15};
        int target = 9;
        int[] polje = s2.twoSum(array, target);
    }
}
