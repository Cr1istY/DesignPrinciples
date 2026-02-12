package cn.foreveryang.domain.service.impl;

import cn.foreveryang.application.dto.GradeResult;
import cn.foreveryang.domain.model.UserGradeConfig;
import cn.foreveryang.domain.model.UserType;
import cn.foreveryang.domain.service.IVideoUserService;

public class VisitorVideoService implements IVideoUserService {
    private final UserGradeConfig config = UserGradeConfig.visitor();


    @Override
    public GradeResult serveGrade() {
        return GradeResult.builder().
                userLevel(UserType.VISITOR.getDisplayName()).
                resolution(config.resolution()).
                adDurationSeconds(config.adDurationSeconds()).
                prioritySupport(config.hasPrioritySupport()).
                build();
    }

    @Override
    public UserType supportsType() {
        return UserType.VISITOR;
    }
}
