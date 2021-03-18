package com.wjx.ezreal.factory.bean;

/**
 * @author wangjinxin
 * @date 2021/3/11 11:43
 * @mail wjxScott@icloud.com
 * @description 子类-圆形
 */
public class CircleShape implements Shape {

    public CircleShape() {
        System.out.println("CircleShape init");
    }

    @Override
    public void draw() {
        System.out.println("CircleShape draw");
    }
}