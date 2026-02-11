package cn.foreveryang.after;

import cn.foreveryang.before.BetUser;

import java.util.List;

// 现在，我们创建一个类，来调用需要的抽奖方式以响应实际需求
public class DrawController {
    // 我们可以采用注入的方法，来更灵活地实现抽奖方式的变更
    private final IDraw draw;

    public DrawController(IDraw draw) {
        this.draw = draw;
    }

    public List<BetUser> doDraw(List<BetUser> list, int count) {
        return draw.prize(list, count);
    }


}
