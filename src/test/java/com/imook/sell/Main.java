package com.imook.sell;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1,2,3,-1,-2,-4};
        System.out.println(threeSum(nums));
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new CopyOnWriteArrayList<>();
        HashSet<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            //如果当前元素和前一个相同,则跳过,因为已经找出符合条件的元素了.
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int sum = -nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                ArrayList<Integer> a = new ArrayList<>();
                if ((nums[left] + nums[right]) == sum) {
                    a.add(nums[i]);
                    a.add(nums[left]);
                    a.add(nums[right]);
                    set.add(a);
                    left++;
                    right--;
                } else if ((nums[left] + nums[right]) > sum) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        list.addAll(set);
        return list;
    }
}