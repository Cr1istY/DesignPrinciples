package cn.foreveryang.before;

import cn.foreveryang.ICalculationArea;

public class CalculationArea implements ICalculationArea {
    private final static double PI = 3.14D;

    @Override
    public double rectangle(double x, double y) {
        return x * y;
    }

    @Override
    public double triangle(double x, double y, double z) {
        double p = (x + y + z) / 2;
        return Math.sqrt(p * (p - x) * (p - y) * (p - z));
    }

    @Override
    public double circular(double r) {
        return PI * r * r;
    }
    // 但是，如果现在，要求我们的PI取更高精度呢
    // 你可能会想到直接在该类中修改PI的值
    // 然而，这违反了开闭原则
    // 因为你并不知道，在其他地方是否有代码依赖于该精度的PI所求得的值
}
