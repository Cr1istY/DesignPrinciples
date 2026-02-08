package cn.foreveryang.before;

// 设置如下场景
// 储蓄卡和信用卡在使用功能上类似，都有支付、提现、还款、充值等方式。
// 但是，其中，也有些许不同
// 例如，支付时，储蓄卡进行账户扣款操作，而信用卡则进行生成贷款单的操作

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

// CashCard 储蓄卡
public class CashCard {
    private final Logger logger = Logger.getLogger("CashCard");
    /**
     * 执行提现操作的方法
     * @param orderId 订单号，用于标识本次提现操作
     * @param amount 提现金额，使用BigDecimal以确保金额计算的精确性
     * @return 返回操作结果码，"0000"表示成功
     */
    public String withdraw(String orderId, BigDecimal amount) {
    // 记录提现操作日志，包含订单号和金额信息
        logger.info("执行提现操作，订单号：" + orderId + "，金额：" + amount);
    // 返回操作结果码，此处固定返回"0000"表示成功
        return "0000";
    }

    /**
     * 执行充值操作的方法
     * @param orderId 订单号，用于标识此次充值操作
     * @param amount 充值金额，使用BigDecimal类型确保金额精度
     * @return 返回操作结果，"0000"表示充值成功
     */
    public String recharge(String orderId, BigDecimal amount) {
    // 记录充值操作日志，包含订单号和金额信息
        logger.info("执行充值操作，订单号：" + orderId + "，金额：" + amount);
    // 返回充值成功状态码
        return "0000";
    }
    /**
     * 执行交易流水操作的方法
     * @return 返回包含交易流水信息的字符串列表
     */
    public List<String> tradeFlow() {
    // 记录开始执行交易流水操作的日志
        logger.info("执行交易流水操作");
    // 创建一个用于存储交易流水信息的列表
        List<String> tradeFlow = new ArrayList<>();
    // 向列表中添加三条交易流水记录
        tradeFlow.add("10010, 100.00");
        tradeFlow.add("10010, 200.00");
        tradeFlow.add("10010, 90.22");
    // 返回包含交易流水信息的列表
        return tradeFlow;
    }
}

// 在储蓄卡中，我们实现了三个方法：提现、储蓄、交易流水查询
