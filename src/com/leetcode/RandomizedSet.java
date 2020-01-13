/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: RandomizedSet
 * Author:   王小手
 * Date:     2020/1/6 17:10
 * Description:  常数时间插入、删除和获取随机元素
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.leetcode;

import java.util.*;

/**
 * 〈一句话功能简述〉<br> 
 * 〈 常数时间插入、删除和获取随机元素〉
 *设计一个支持在平均 时间复杂度 O(1) 下，执行以下操作的数据结构。
 *
 * insert(val)：当元素 val 不存在时，向集合中插入该项。
 * remove(val)：元素 val 存在时，从集合中移除该项。
 * getRandom：随机返回现有集合中的一项。每个元素应该有相同的概率被返回。
 * 示例 :
 *
 * // 初始化一个空的集合。
 * RandomizedSet randomSet = new RandomizedSet();
 *
 * // 向集合中插入 1 。返回 true 表示 1 被成功地插入。
 * randomSet.insert(1);
 *
 * // 返回 false ，表示集合中不存在 2 。
 * randomSet.remove(2);
 *
 * // 向集合中插入 2 。返回 true 。集合现在包含 [1,2] 。
 * randomSet.insert(2);
 *
 * // getRandom 应随机返回 1 或 2 。
 * randomSet.getRandom();
 *
 * // 从集合中移除 1 ，返回 true 。集合现在包含 [2] 。
 * randomSet.remove(1);
 *
 * // 2 已在集合中，所以返回 false 。
 * randomSet.insert(2);
 *
 * // 由于 2 是集合中唯一的数字，getRandom 总是返回 2 。
 * randomSet.getRandom();
 * @author
 * @create 2020/1/6
 * @since 1.0.0
 */
public class RandomizedSet {

    public static void main(String[] args) {

    }

    Map<Integer,Integer> map;
    List<Integer> list;

    public RandomizedSet(){
        map=new HashMap<Integer,Integer>();
        list=new ArrayList<Integer>();
    }

    public boolean insert(int val){
        if (!map.containsKey(val)){
            map.put(val,list.size());
            list.add(val);
            return true;
        }
        return false;
    }

    public boolean remove(int val) {
        if(map.containsKey(val)){
            int index = map.remove(val);
            list.set(index,Integer.MIN_VALUE);
            return true;
        }
        return false;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        Random rm = new Random();
        int i = rm.nextInt(list.size());
        while(list.get(i) == Integer.MIN_VALUE){
            i = rm.nextInt(list.size());
        }

        return list.get(i);
    }
}