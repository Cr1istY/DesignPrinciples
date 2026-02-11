package cn.foreveryang.before;

import cn.foreveryang.after.impl.DrawRandom;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

// 下面该类中，我们用两个接口实现两个不同的抽奖逻辑
public class DrawController {

    // 无权重
    public List<BetUser> doDrawRandom(List<BetUser> list, int count) {
        if (list.size() <= count) {
            return list;
        }
        Collections.shuffle(list);
        List<BetUser> prizeList = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            prizeList.add(list.get(i));
        }
        return prizeList;
    }

    // 按照权重指定获奖用户
    public List<BetUser> doDrawWeight(List<BetUser> list, int count) {
        if (list.size() <= count) {
            return list;
        }
        // 按权重排序
        list.sort((o1, o2) -> {
            int e = o2.getUserWeight() - o1.getUserWeight();
            if (0 == e) return 0;
            return e > 0 ? 1 : -1;
        });
        List<BetUser> prizeList = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            prizeList.add(list.get(i));
        }
        return prizeList;
    }
}
