package cn.foreveryang.after.impl;

import cn.foreveryang.after.IDraw;
import cn.foreveryang.before.BetUser;

import java.util.ArrayList;
import java.util.List;

public class DrawWeightRank implements IDraw {
    @Override
    public List<BetUser> prize(List<BetUser> list, int count) {
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
