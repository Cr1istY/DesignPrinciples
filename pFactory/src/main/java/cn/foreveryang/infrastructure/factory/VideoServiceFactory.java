package cn.foreveryang.infrastructure.factory;


import cn.foreveryang.domain.model.UserType;
import cn.foreveryang.domain.service.IVideoUserService;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 视频服务工厂
 * 1. 使用注册表模式：新增策略无需修改工厂（开闭原则）
 * 2. 线程安全：ConcurrentHashMap保障高并发安全
 * 3. 懒加载：首次使用时初始化
 */
public final class VideoServiceFactory {
    private static final Map<UserType, IVideoUserService> SERVICE_REGISTRY = new ConcurrentHashMap<>();

    // 静态初始化注册表
    static {
        registerService(new cn.foreveryang.domain.service.impl.VisitorVideoService());
        registerService(new cn.foreveryang.domain.service.impl.NormalVideoService());
        registerService(new cn.foreveryang.domain.service.impl.VipVideoService());
    }

    private static void registerService(IVideoUserService service) {
        SERVICE_REGISTRY.put(service.supportsType(), service);
    }

    /**
     * 核心方法：根据用户类型获取服务
     * @param userType 用户类型字符串（大小写不敏感）
     * @return 对应策略实例
     * @throws IllegalArgumentException 无效类型
     */
    public static IVideoUserService getService(String userType) {
        UserType type = UserType.fromString(userType);
        IVideoUserService service = SERVICE_REGISTRY.get(type);

        if (service == null) {
            throw new RuntimeException("未注册的服务策略：" + type);
        }
        return service;
    }

}
