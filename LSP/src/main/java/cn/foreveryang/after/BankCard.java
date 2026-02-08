package cn.foreveryang.after;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

// 为了践行里氏替换原则
// 首先，创建一个银行卡的抽象类
public abstract class BankCard {
    private final Logger logger = Logger.getLogger(BankCard.class.getName());
    private final String cardNo; // 卡号
    private final String cardDate; // 开卡时间
    public BankCard(String cardNo, String cardDate) {
        this.cardNo = cardNo;
        this.cardDate = cardDate;
    }
    public abstract boolean rule(BigDecimal amount);

    // 正向入账，加钱
    public String positive(String orderId, BigDecimal amount) {
        logger.info("orderId:" + orderId + ",cardNo:" + cardNo + ",amount:" + amount + ",入款成功");
        return "0000";
    }
    // 反向入账，扣钱
    public String negative(String orderId, BigDecimal amount) {
        logger.info("orderId:" + orderId + ",cardNo:" + cardNo + ",amount:" + amount + ",出款成功");
        return "0000";
    }

    public List<String> tradeFlow() {
        logger.info("查询流水中:");
        List<String> tradeFlow = new ArrayList<>();
        tradeFlow.add("10010, 100.00");
        tradeFlow.add("10010, 200.00");
        tradeFlow.add("10010, 90.22");
        return tradeFlow;
    }

    public String getCardNo() {
        return cardNo;
    }

    public String getCardDate() {
        return cardDate;
    }
}
