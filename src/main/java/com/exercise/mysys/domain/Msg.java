package com.exercise.mysys.domain;

/**
 * @ProjectName 食品企业订货销售系统
 * @Author 朱向阳
 * @Date 2018/7/20 20:55
 * @Description: 信息类
 */
public class Msg {
    private String title;
    private String content;
    private String info;

    public Msg(String title, String content, String info){
        this.title = title;
        this.content = content;
        this.info = info;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
