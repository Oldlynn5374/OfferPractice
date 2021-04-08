package test;

public class ParameterTest {
    public void change(int[] nums) {
        nums = new int[10];
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int[] nums2 = nums;
        System.out.println(nums[0]);
        new ParameterTest().change(nums);
        System.out.println(nums[0]);
    }
}
