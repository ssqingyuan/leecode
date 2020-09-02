package com.sqy.leecode;

/**
 * @author: sunqingyuan
 * @date: 2020/8/31 17:11
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 有 N 个房间，开始时你位于 0 号房间。每个房间有不同的号码：0，1，2，...，N-1，并且房间里可能有一些钥匙能使你进入下一个房间。
 *
 * 在形式上，对于每个房间 i 都有一个钥匙列表 rooms[i]，每个钥匙 rooms[i][j] 由 [0,1，...，N-1] 中的一个整数表示，其中 N = rooms.length。 钥匙 rooms[i][j] = v 可以打开编号为 v 的房间。
 *
 * 最初，除 0 号房间外的其余所有房间都被锁住。
 *
 * 你可以自由地在房间之间来回走动。
 *
 * 如果能进入每个房间返回 true，否则返回 false。
 *
 输入：[[1,3],[3,0,1],[2],[0]]
 输出：false
 解释：我们不能进入 2 号房间。
 [[6,7,8],[5,4,9],[],[8],[4],[],[1,9,2,3],[7],[6,5],[2,3,1]]
 [[1,3],[3,0,1],[2],[0]]
 */
public class T841 {
    public static void main(String[] args) {
        List<List<Integer>> rooms = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(3);
        List<Integer> list2 = new ArrayList<>();
        list2.add(4);
        list2.add(1);
        List<Integer> list3 = new ArrayList<>();
        list3.add(2);
        list3.add(3);
        list3.add(4);
        list3.add(1);
        list3.add(2);
        List<Integer> list4 = new ArrayList<>();
        list4.add(4);
        list4.add(3);
        list4.add(2);
        List<Integer> list5 = new ArrayList<>();
        rooms.add(list1);
        rooms.add(list2);
        rooms.add(list3);
        rooms.add(list5);
        rooms.add(list4);
        System.out.println(canVisitAllRooms(rooms));
    }

    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> allkeys = new HashSet<>();
        allkeys.add(0);
        Integer i = 0;

        while (i < rooms.size()){
            if(allkeys.contains(i)){
                List<Integer> keys = rooms.get(i);
                i++;
                for(int j = 0; j < keys.size(); j++){
                    if(!allkeys.contains(keys.get(j)) && keys.get(j) < i){
                        i = keys.get(j);
                        continue;
                    }
                }
                allkeys.addAll(keys);
            }else {
                i++;
            }
        }
        if(allkeys.size() == rooms.size()){
            return true;
        }
        return false;
    }
}
