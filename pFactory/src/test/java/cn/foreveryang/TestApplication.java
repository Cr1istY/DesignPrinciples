package cn.foreveryang;

import cn.foreveryang.application.dto.GradeResult;
import cn.foreveryang.domain.service.IVideoUserService;
import cn.foreveryang.infrastructure.factory.VideoServiceFactory;
import org.junit.jupiter.api.Test;

class TestApplication {
    @Test
    public void test(){
        String [] userTypes = {"visitor", "NorMAL", "VIP", "svip"}; // 模拟用户登录
        for (String userType : userTypes) {
            try {
                IVideoUserService service = VideoServiceFactory.getService(userType);
                GradeResult result = service.serveGrade();
                System.out.println(result.toDisplayText());
                System.out.println("=".repeat(15));

            } catch (Exception e) {
                System.err.println("处理用户类型 [" + userType + "] 失败: " + e.getMessage());
            }
        }
    }
}
