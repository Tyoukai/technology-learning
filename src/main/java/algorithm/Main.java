package algorithm;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        int[] nums = new int[3];
        nums[0] = 1;
        nums[1] = 2;
        nums[2] = 3;

        Main main = new Main();
        main.subsets(nums);
        System.out.println(main.ans);
    }

    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        back(nums, 0, new ArrayList<>());
        return ans;
    }

    public void back(int[] nums, int index, List<Integer> oneAns) {
        ans.add(new ArrayList<>(oneAns));
        if (index >= nums.length) {
            return;
        }

        for (int i = index; i < nums.length; i++) {

            oneAns.add(nums[index]);
            back(nums, index + 1, oneAns);
            oneAns.remove(oneAns.size() - 1);
            back(nums, index + 1, oneAns);
        }
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] nums = new int[m + n];

        int index1 = 0;
        int index2 = 0;
        int index = 0;
        while (index1 < m && index2 < n) {
            if (nums1[index1] <= nums2[index2]) {
                nums[index] = nums1[index1];
                index++;
                index1++;
            } else {
                nums[index] = nums2[index2];
                index++;
                index2++;
            }
        }

        if (index1 < m) {
            nums[index] = nums1[index1];
            index++;
            index1++;
        }
        if (index2 < n) {
            nums[index] = nums2[index2];
            index++;
            index2++;
        }

        if ((m + n) % 2 == 0) {
            return (nums[(m + n) / 2] + nums[(m + n) / 2 - 1]) / 2.0;
        } else {
            return nums[(m + n) / 2];
        }
    }

}
