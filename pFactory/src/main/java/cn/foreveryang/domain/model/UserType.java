package cn.foreveryang.domain.model;


import lombok.Getter;

/**
 * 用户类型枚举：自带领域语义
 */
@Getter
public enum UserType {
    VISITOR("游客", 0),
    NORMAL("普通用户", 1),
    VIP("VIP", 2);

    private final String displayName;
    private final int priority;

    UserType(String displayName, int priority) {
        this.displayName = displayName;
        this.priority = priority;
    }

    public static UserType fromString(String type) {
        if (type == null || type.trim().isEmpty()) {
            throw new RuntimeException("用户类型不能为空");
        }

        try {
            return UserType.valueOf(type.trim().toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("无效的用户类型: " + type+ "，支持: " +
                    String.join(",",
                            java
                                    .util
                                    .Arrays
                                    .stream(values())
                                    .map(Enum::name)
                                    .toArray(String[]::new)));
        }
    }

}
