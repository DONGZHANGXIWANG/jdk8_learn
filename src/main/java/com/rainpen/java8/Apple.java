package com.rainpen.java8;

/**
 * Created by Administrator on 2017/11/30/030.
 */
public class Apple {

    private String color;
    private long weigth;

    public Apple(String color, long weigth) {
        this.color = color;
        this.weigth = weigth;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public long getWeigth() {
        return weigth;
    }

    public void setWeigth(long weigth) {
        this.weigth = weigth;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "color='" + color + '\'' +
                ", weigth=" + weigth +
                '}';
    }
}
