package cn.foreveryang.before;

import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Logger;

// 在没有遵守里氏替换原则的情况下，我们可能直接使用CashCard作为CreditCard的父类
public class CreditCard extends CashCard {
    private final Logger logger = Logger.getLogger("CreditCard");

    /**
     * 重写提现方法
     * @param orderId 订单号
     * @param amount 提现金额
     * @return 处理结果代码，0000表示成功，E001表示超过单笔交易限额
     */
    @Override
    public String withdraw(String orderId, BigDecimal amount) {
        // 检查提现金额是否超过单笔交易限额1000元
        if (amount.compareTo(new BigDecimal(1000))  >= 0) {
            // 记录超过限额的日志信息
            logger.info("订单号:" + orderId + "贷款金额" + amount + " 超过单笔交易限额1000元");
            // 返回错误代码E001表示超过限额
            return "E001";
        }
        // 模拟生成贷款单，记录成功日志
        logger.info("订单号:" + orderId + "贷款金额" + amount + " 贷款成功");
        // 模拟支付成功，记录支付日志
        logger.info("订单号:" + orderId + "贷款金额" + amount + " 支付成功");
        // 返回成功代码0000表示处理成功
        return "0000";
    }

    @Override
    /**
     * 充值方法
     * @param orderId 订单号，用于标识唯一的一次充值交易
     * @param amount 充值金额，使用BigDecimal类型确保金额精度
     * @return 返回操作结果码，"0000"表示成功
     */
    public String recharge(String orderId, BigDecimal amount) {
        // 模拟生成还款单，记录成功日志
        logger.info("订单号:" + orderId + "还款金额" + amount + " 还款单生成成功");
        logger.info("订单号:" + orderId + "还款金额" + amount + " 支付成功");
        return "0000";
    }

    @Override
    public List<String> tradeFlow() {
        return super.tradeFlow();
    }

}

// 由于具体操作的不同，使用这种继承方法时，我们不得不
// 重写父类的许多方法
// 优点是，我们复用了父类的核心功能逻辑，但是也破坏了原有的方法，此时继承父类实现的信用卡类并不满足里氏替换原则。
// 因为，此时的子类不能承担原父类的功能，直接给CashCard使用
