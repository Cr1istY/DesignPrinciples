package cn.foreveryang.domain.service;

import cn.foreveryang.application.dto.GradeResult;
import cn.foreveryang.domain.model.UserType;


/**
 * 视频服务策略
 * 返回结构化结果，而非直接打印以解耦业务与输出
 */
public interface IVideoUserService {
    GradeResult serveGrade();
    UserType supportsType();
}
