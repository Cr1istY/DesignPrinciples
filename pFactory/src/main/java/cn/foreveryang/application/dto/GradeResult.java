package cn.foreveryang.application.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GradeResult {
    private String userLevel;
    private String resolution;
    private int adDurationSeconds;
    private boolean prioritySupport;


    public String toDisplayText() {
        return String.format(
                "[%s]\n 分辨率：%s\n 广告时长：%d秒\n 是否支持优先级：%s",
                userLevel, resolution, adDurationSeconds,
                prioritySupport ? "\n✅ 享有优先客服支持" : "");
    }

}
