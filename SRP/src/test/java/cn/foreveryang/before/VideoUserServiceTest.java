package cn.foreveryang.before;

class VideoUserServiceTest {
    @org.junit.jupiter.api.Test
    void login() {
        VideoUserService videoUserService = new VideoUserService("VIP");
        videoUserService.serveGrade();
    }
}