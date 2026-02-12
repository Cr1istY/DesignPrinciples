package cn.foreveryang.domain.service.impl;

import cn.foreveryang.application.dto.GradeResult;
import cn.foreveryang.domain.model.UserGradeConfig;
import cn.foreveryang.domain.model.UserType;
import cn.foreveryang.domain.service.IVideoUserService;

public class VipVideoService implements IVideoUserService {

    private final UserGradeConfig config = UserGradeConfig.vip();


    @Override
    public GradeResult serveGrade() {
        return GradeResult.builder().
                userLevel(UserType.VIP.getDisplayName()).
                resolution(config.resolution()).
                adDurationSeconds(config.adDurationSeconds()).
                prioritySupport(config.hasPrioritySupport()).
                build();
    }

    @Override
    public UserType supportsType() {
        return UserType.VIP;
    }
}
