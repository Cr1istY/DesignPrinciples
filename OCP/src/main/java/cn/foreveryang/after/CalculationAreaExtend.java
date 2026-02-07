package cn.foreveryang.after;

import cn.foreveryang.before.CalculationArea;

public class CalculationAreaExtend extends CalculationArea {
    private final static double PI = 3.141592653D;

    @Override
    public double circular(double r) {
        return PI * r * r;
    }

    // 开闭原则告诉我们，我们的代码应该
    // 对修改关闭，对扩展开放
    // 在此，我们使用扩展的方法，重写了我们想要修改的常量
    // 当我们需要更高精度的圆面积时，调用此代码即可
}
