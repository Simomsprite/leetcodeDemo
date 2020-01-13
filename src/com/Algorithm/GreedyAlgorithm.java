/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: GreedyAlgorithm
 * Author:   王小手
 * Date:     2019/10/21 16:39
 * Description: 贪心算法
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.Algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 〈一句话功能简述〉<br> 
 * 〈贪心算法〉
 *
 * @author
 * @create 2019/10/21
 * @since 1.0.0
 */
public class GreedyAlgorithm {
    public static void main(String[] args) {
        HashMap<String, HashSet<String>> broadcasts=new HashMap<String, HashSet<String>>();

        HashSet<String> hashSet1=new HashSet<>();
        hashSet1.add("北京");
        hashSet1.add("上海");
        hashSet1.add("天津");

        HashSet<String> hashSet2=new HashSet<>();
        hashSet2.add("广州");
        hashSet2.add("北京");
        hashSet2.add("深圳");

        HashSet<String> hashSet3=new HashSet<>();
        hashSet3.add("成都");
        hashSet3.add("上海");
        hashSet3.add("杭州");

        HashSet<String> hashSet4=new HashSet<>();
        hashSet4.add("上海");
        hashSet4.add("天津");

        HashSet<String> hashSet5=new HashSet<>();
        hashSet5.add("杭州");
        hashSet5.add("大连");

        broadcasts.put("k1",hashSet1);
        broadcasts.put("k2",hashSet2);
        broadcasts.put("k3",hashSet3);
        broadcasts.put("k4",hashSet4);
        broadcasts.put("k5",hashSet5);

        HashSet<String> allAreas=new HashSet<>();
        allAreas.add("北京");
        allAreas.add("上海");
        allAreas.add("天津");
        allAreas.add("广州");
        allAreas.add("深圳");
        allAreas.add("成都");
        allAreas.add("杭州");
        allAreas.add("大连");

        //创建Arraylist,存放选择的电台集合
        ArrayList<String> selects = new ArrayList<>();
        HashSet<String> tempSet=new HashSet<>();

        //定义maxKey,保存在一次遍历过程中，能够覆盖最大未覆盖地区对应的电台的Key
        String maxKey=null;
        //如果maxKey不为空，则会加入到selects
        while (allAreas.size()!=0){//如果allAreas不为0，则表示还没有覆盖到所有的地区
            //将maxKey清空
            maxKey=null;
            for (String key:broadcasts.keySet()){
                //每进行一次for
                tempSet.clear();
                //当前这个key能够覆盖的地区
                HashSet<String> areas=broadcasts.get(key);
                tempSet.addAll(areas);
                //求出tempSet和allAreas集合的交集，交集会赋给tempSet
                tempSet.retainAll(allAreas);
                //如果当前的集合包含的未覆盖地区的数量，比maxKey指向的集合未覆盖的地区还多
                //就需要重置maxkey
                if (tempSet.size()>0 && (maxKey==null || tempSet.size()>broadcasts.get(maxKey).size())){
                   maxKey=key;
                }
            }
            //maxKey != null,就应该将maxKey加入selects
            if (maxKey != null){
                selects.add(maxKey);
                //将maxKey指向的广播覆盖的地区从allAreas去掉
                allAreas.removeAll(broadcasts.get(maxKey));
            }
        }
        System.out.println("得到的选择结果是："+selects);
    }
}