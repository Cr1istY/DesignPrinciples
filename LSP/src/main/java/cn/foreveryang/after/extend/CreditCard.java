package cn.foreveryang.after.extend;

import cn.foreveryang.after.BankCard;

import java.math.BigDecimal;
import java.util.logging.Logger;

public class CreditCard extends CashCard {
    private final Logger logger = Logger.getLogger(CreditCard.class.getName());
    public CreditCard(String cardNo, String CardData) {
        super(cardNo, CardData);
    }

    private boolean rule2(BigDecimal amount) {
        return amount.compareTo(new BigDecimal(1000)) < 0;
    }

    public String loan(String orderId, BigDecimal amount) {
        boolean flag = rule2(amount);
        if (!flag) {
            logger.info("贷款失败");
            return "E001";
        }
        logger.info("贷款成功");
        logger.info("贷款单号：" + orderId + "，贷款金额：" + amount);
        return super.negative(orderId, amount);
    }

    public String repay(String orderId, BigDecimal amount) {
        logger.info("还款成功");
        logger.info("还款单号：" + orderId + "，还款金额：" + amount);
        return super.positive(orderId, amount);
    }
}
// 信用卡类基础父类后，使用了公用的属性，即卡号和开卡时间
// 同时，新增了符合信用卡功能的新方法
// 但是，这些方法都没有破坏储蓄卡的原有方法
// 符合里氏替换原则
