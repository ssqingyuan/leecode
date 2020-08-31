package com.sqy.leecode;

/**
 * @author: sunqingyuan
 * @date: 2020/8/31 17:02
 */

/**
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 */
public class T80 {
    public static void main(String[] args) {

    }
    public int removeDuplicates(int[] nums) {
        int len=nums.length;
        for(int i=0;i<len-1;i++) {


            if(nums[i]==nums[i+1]) {
                if(i+2>=len) {
                    break;
                }else if(nums[i]==nums[i+2]) {
                    for(int j=i+2;j<len-1;j++) {
                        nums[j]=nums[j+1];
                    }
                    i--;
                    len--;
                }
            }
            //System.out.println(i);
        }

        return len;
    }

}
