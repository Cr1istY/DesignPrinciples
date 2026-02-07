package cn.foreveryang;

// 模拟场景，当我们想要写一个计算不同图形的面积的类时
public interface ICalculationArea {
    /**
     * 计算矩形的面积
     * @param x 矩形的长度
     * @param y 矩形的宽度
     * @return 返回矩形的面积，即长度乘以宽度
     */
    double rectangle(double x, double y);
    /**
     * 计算直角三角形的斜边长度
     * @param x 直角三角形的第一个直角边长度
     * @param y 直角三角形的第二个直角边长度
     * @param z 直角三角形的斜边长度
     * @return 直角三角形的斜边长度，通过海伦定理计算得出
     */
    double triangle(double x, double y, double z);
    /**
     * 计算圆的面积
     * @param r 圆的半径
     * @return 返回圆的面积，计算公式为 πr²
     */
    double circular(double r);

}
