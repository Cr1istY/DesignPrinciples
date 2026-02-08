package cn.foreveryang.after.extend;

import cn.foreveryang.after.BankCard;

import java.math.BigDecimal;
import java.util.logging.Logger;

public class CashCard extends BankCard {
    private final Logger logger = Logger.getLogger(CashCard.class.getName());
    public CashCard(String cardNum, String cardData) {
        super(cardNum, cardData);
    }

    @Override
    public boolean rule(BigDecimal amount) {
        return true;
    }

    public String withdraw(String orderId, BigDecimal amount) {
        logger.info("提现成功," + "单号:" + orderId + ",金额:" + amount);
        return super.negative(orderId, amount);
    }

    public String recharge(String orderId, BigDecimal amount) {
        logger.info("充值成功," + "单号:" + orderId + ",金额:" + amount);
        return super.positive(orderId, amount);
    }
}
