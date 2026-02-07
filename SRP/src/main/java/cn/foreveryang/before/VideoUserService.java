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
