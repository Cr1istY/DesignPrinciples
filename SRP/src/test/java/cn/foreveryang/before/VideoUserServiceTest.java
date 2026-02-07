package cn.foreveryang.before;

import org.junit.jupiter.api.Test;

class VideoUserServiceTest {
    @Test
    void login() {
        VideoUserService videoUserService = new VideoUserService("VIP");
        videoUserService.serveGrade();
    }
}