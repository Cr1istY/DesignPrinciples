package cn.foreveryang.after.extend;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;


class CashCardTest {

    @Test
    void test() {
        CashCard cashCard = new CashCard("6222020202020202", "2026-2-30");
        // withdraw
        cashCard.withdraw("10010", new BigDecimal(100000));
        // recharge
        cashCard.recharge("10010", new BigDecimal(100000));
    }

    // 信用卡替换储蓄卡测试
    @Test
    void test2() {
        CashCard creditCard = new CreditCard("6222020202020202", "2026-2-30");
        creditCard.withdraw("10010", new BigDecimal(100000));
        creditCard.recharge("10010", new BigDecimal(100000));
    }
}