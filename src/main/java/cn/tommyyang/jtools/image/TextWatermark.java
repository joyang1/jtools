package cn.tommyyang.jtools.image;

import java.awt.*;

/**
 * @Author : TommyYang
 * @Time : 2019-08-30 11:52
 * @Software: IntelliJ IDEA
 * @File : TextWatermark.java
 */
public class TextWatermark extends Watermark {

    // 文字水印
    private String text;
    // 文字水印字体，默认为宋体
    private Font font;
    // 文字水印颜色
    private Color color;
    // 水印位于图片左上角的 x 坐标值
    private float x;
    // 水印位于图片左上角的 y 坐标值
    private float y;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Font getFont() {
        if (font == null) {
            return new Font("宋体", Font.BOLD, 20);
        }
        return font;
    }

    public void setFont(Font font) {
        this.font = font;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return super.toString() + "; TextWatermark{" +
                "text='" + text + '\'' +
                ", font=" + font +
                ", color=" + color +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
