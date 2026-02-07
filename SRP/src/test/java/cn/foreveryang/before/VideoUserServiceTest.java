package cn.foreveryang.before;

import cn.foreveryang.after.IVideoUserService;
import cn.foreveryang.after.impl.VipVideoUserService;

class VideoUserServiceTest {
    @org.junit.jupiter.api.Test
    void login_before() {
        VideoUserService videoUserService = new VideoUserService("VIP");
        videoUserService.serveGrade();
    }

    @org.junit.jupiter.api.Test
    void login_after() {
        IVideoUserService videoUserService = new VipVideoUserService();
        videoUserService.resolution();
        videoUserService.adDuration();
    }
    // 通过将三种职责进行拆分，践行SRP原则，使得代码更加清晰，职责更加明确
}