package cn.foreveryang.after;

import cn.foreveryang.after.impl.DrawRandom;
import cn.foreveryang.after.impl.DrawWeightRank;
import cn.foreveryang.before.BetUser;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class DrawControllerTest {

    @Test
    void doDraw() {
        DrawController drawController0 = new DrawController(new DrawRandom());
        List<BetUser> list = new ArrayList<>();
        list.add(new BetUser("user1", 10));
        list.add(new BetUser("user2", 28));
        list.add(new BetUser("user3", 27));
        list.add(new BetUser("user4", 22));
        list.add(new BetUser("user5", 21));
        list.add(new BetUser("user6", 25));
        list.add(new BetUser("user7", 22));
        List<BetUser> prizeUser0 = drawController0.doDraw(list, 5);
        DrawController drawController1 = new DrawController(new DrawWeightRank());
        List<BetUser> prizeUser1 = drawController1.doDraw(list, 5);

        for (BetUser user : prizeUser0) {
            System.out.println(user.getName());
        }

        System.out.println("=====================================");

        for (BetUser user : prizeUser1) {
            System.out.println(user.getName());
        }
    }
}