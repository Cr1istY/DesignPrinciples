package cn.foreveryang.after;

import cn.foreveryang.before.BetUser;

import java.util.List;

// 在依赖倒置原则下
// 我们将抽奖规则抽象出来，由具体的抽奖规则类实现
public interface IDraw {
    List<BetUser> prize(List<BetUser> list, int count);
}
