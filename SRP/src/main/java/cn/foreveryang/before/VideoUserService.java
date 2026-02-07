package cn.foreveryang.before;

import cn.foreveryang.UserType;

// 模拟场景：
// 用户登录后，网站根据其等级分别进行 分辨率(Resolution) 和 广告时长(AdDuration) 的设置
public class VideoUserService {
    private final UserType userType;
    public VideoUserService(String userType) {
        if (UserType.VISITOR.name().equalsIgnoreCase(userType)) {
            this.userType = UserType.VISITOR;
        } else if (UserType.NORMAL.name().equalsIgnoreCase(userType)) {
            this.userType = UserType.NORMAL;
        } else if (UserType.VIP.name().equalsIgnoreCase(userType)) {
            this.userType = UserType.VIP;
        } else {
            throw new RuntimeException("用户类型错误");
        }
    }
    public void serveGrade() {
        if (UserType.VISITOR == userType) {
            System.out.println("游客级别");
            System.out.println("分辨率：360P");
            System.out.println("广告时长：50秒");
        } else if (UserType.NORMAL == userType) {
            System.out.println("普通用户级别");
            System.out.println("分辨率：720P");
            System.out.println("广告时长：10秒");
        } else if (UserType.VIP == userType) {
            System.out.println("VIP用户级别");
            System.out.println("分辨率：1080P");
            System.out.println("广告时长：0秒");
        } else {
            throw new RuntimeException("用户类型错误");
        }
    }
}
// 在不符合单一职责原则的情况下，如果我们想要修改某一种用户类型的具体权限。
// 我们不得不每一次都修改VideoUserService类中的serveGrade方法，这样代码的维护成本就会变得很高。
// 所以，我们希望每次修改涉及的类的原因只出于一种要求。
// 即，一个软件单元，只应该有一个修改的原因。
