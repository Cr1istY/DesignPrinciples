package cn.foreveryang.after.impl;

import cn.foreveryang.after.IVideoUserService;

public class VisitorVideoUserService implements IVideoUserService {
    @Override
    public void resolution() {
        System.out.println("游客视频分辨率 480p");
    }

    @Override
    public void adDuration() {
        System.out.println("游客视频广告时长 50s");
    }

}
