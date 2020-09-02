package com.sqy.leecode;

/**
 * @author: sunqingyuan
 * @date: 2020/8/31 19:31
 */

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 */
public class T2 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {

        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(5);
//        ListNode l3 = new ListNode(9);
//        l2.next = l3;
        addTwoNumbers(l1, l2).forEach(x-> System.out.println(x.val));


    }



    public static List<ListNode> addTwoNumbers(ListNode l1, ListNode l2) {
        List<ListNode> nodes = new ArrayList<>();
        int flag = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val;
            if(flag == 1){
                sum ++;
                flag = 0;
            }
            if (sum >= 10) {
                flag = 1;
                sum %= 10;
            }
            ListNode target = new ListNode(sum);
            nodes.add(target);
            l1 = l1.next;
            l2 = l2.next;
        }

        if(l1 == null && l2 == null && flag == 1){
            ListNode target = new ListNode(1);
            nodes.add(target);
            flag = 0;
        }else if(l1 == null){
            while (l2 != null){
                int sum = l2.val;
                if(flag == 1){
                    sum ++;
                    flag = 0;
                }
                if (sum >= 10) {
                    flag = 1;
                    sum %= 10;
                }
                ListNode target = new ListNode(sum);
                nodes.add(target);
                l2 = l2.next;
            }
        }else if(l2 == null){
            while (l1 != null){
                int sum = l1.val;
                if(flag == 1){
                    sum ++;
                    flag = 0;
                }
                if (sum >= 10) {
                    flag = 1;
                    sum %= 10;
                }
                ListNode target = new ListNode(sum);
                nodes.add(target);
                l1 = l1.next;
            }

        }
        if(flag == 1){
            ListNode listNode = new ListNode(1);
            nodes.add(listNode);
        }

        for(int i = 0; i < nodes.size() - 1; i++){
            nodes.get(i).next = nodes.get(i + 1);
        }

        return nodes;
    }
}
