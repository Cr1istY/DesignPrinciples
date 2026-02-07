### 什么是开闭原则

对扩展开放，对修改关闭。

其实，核心只有一句话**你的特定需求不能够改变原有的方法。**

例如，你好不容易建好了一座乐高城堡，如果想让它变得更壮观，你当然不想进行修改（因为这会导致难以预料的错误），而是在此基础上进行扩建。

解决了：
- 改一处、崩三处
- 保护已经测试过的功能
- 降低维护成本

不遵循：

```java
class Order { public double calculateTotal(String discountType) { 
	if(discountType.equals("holiday")) { 
	// 假期折扣逻辑 
	} else if(discountType.equals("vip")) {
	 // VIP折扣逻辑
	} else if(discountType.equals("coupon")) { 
	// 优惠券折扣逻辑
	} 
	// 每增加一种折扣类型，就要修改这个方法
    } 
} 
```

遵循：

```java
// 定义折扣策略接口
interface DiscountStrategy {
	double applyDiscount(double total);
}

// 各种具体折扣实现
class HolidayDiscount implements DiscountStrategy { /* 具体实现 */ }
class VipDiscount implements DiscountStrategy { /* 具体实现 */ }
class CouponDiscount implements DiscountStrategy { /* 具体实现 */ }

// 订单类
class Order {
	private DiscountStrategy discountStrategy;
	
	public Order(DiscountStrategy strategy) {
		this.discountStrategy = strategy;
	}
	
	public double calculateTotal(double total) {
		return discountStrategy.applyDiscount(total);
	}
}
```

**优势：** 需要新折扣类型时，只需**添加新类**实现`DiscountStrategy`接口，**无需修改**`Order`类的现有代码。

### 总结

开闭原则就像给软件设计装上了"插槽"，新功能如同"插件"，可以随时插入而不影响现有系统。它不是要求代码完全不修改，而是通过合理抽象，将变化隔离在特定区域，使系统更加灵活、稳定、易于维护。

作为架构师，我常对团队说："写代码时，想象你写的模块明天就会被其他人使用，而你无法再修改它—你只能通过扩展来适应新需求。" 这就是开闭原则的精髓。

### 如何在实践中应用？

1. **抽象是关键**：识别系统中可能变化的部分，将其抽象为接口或抽象类
2. **依赖抽象，而非具体**：代码应依赖于抽象接口，而非具体实现
3. **使用设计模式**：策略模式、工厂模式、装饰器模式等都是实现开闭原则的有效工具
4. **提前规划，但不提前实现**：预见可能的变化点，但不要过度设计