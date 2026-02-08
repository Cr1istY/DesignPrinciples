package cn.foreveryang.after.extend;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;


class CreditCardTest {
    @Test
    void test() {
        CreditCard creditCard = new CreditCard("6222020202020202", "2026-2-30");
        creditCard.loan("10010", new BigDecimal("10000"));
        creditCard.repay("10010", new BigDecimal("10000"));
    }

}