package cn.foreveryang.domain.model;

// 使用记录类
// 可见 https://liaoxuefeng.com/books/java/oop/core/record/index.html

/**
 * 用户等级配置
 */
public record UserGradeConfig(String resolution, int adDurationSeconds, boolean hasPrioritySupport) {
    public static UserGradeConfig visitor() {
        return new UserGradeConfig("360p", 60, false);
    }

    public static UserGradeConfig normal() {
        return new UserGradeConfig("720p", 30, false);
    }

    public static UserGradeConfig vip() {
        return new UserGradeConfig("1080p", 0, true);
    }
}
