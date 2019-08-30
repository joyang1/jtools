package cn.tommyyang.jtools.image;

import cn.tommyyang.jtools.exception.ErrorCode;
import cn.tommyyang.jtools.exception.JToolException;

import java.awt.*;

/**
 * @Author : TommyYang
 * @Time : 2019-08-30 11:44
 * @Software: IntelliJ IDEA
 * @File : Watermark.java
 */
public class Watermark {

    // 存盘图片的图片格式
    private String formatName;
    // 水印透明度 0.1f ~ 1.0f
    private float alpha;
    // 水印倾斜角度
    private double rotate;

    public String getFormatName() {
        if (this.formatName == null || this.formatName.length() == 0) {
            return "png";
        }
        return formatName;
    }

    public void setFormatName(String formatName) {
        this.formatName = formatName;
    }

    public float getAlpha() {
        return alpha;
    }

    public void setAlpha(float alpha) {
        this.alpha = alpha;
    }

    public double getRotate() {
        return rotate;
    }

    public void setRotate(double rotate) {
        this.rotate = rotate;
    }

    @Override
    public String toString() {
        return "Watermark{" +
                "formatName='" + formatName + '\'' +
                ", alpha=" + alpha +
                ", rotate=" + rotate +
                '}';
    }

    public enum Type {
        TEXT,
        IMAGE
    }

    public static class WatermarkBuilder {
        private Type type;
        private String imgPath;
        private String formatName;
        private float alpha;
        private double rotate;
        private float x;
        private float y;
        private String text;
        private Font font;
        private Color color;

        public static WatermarkBuilder newBuilder() {
            return new WatermarkBuilder();
        }

        public WatermarkBuilder setType(Type type) {
            this.type = type;
            return this;
        }

        public WatermarkBuilder setImgPath(String imgPath) {
            this.imgPath = imgPath;
            return this;
        }

        public WatermarkBuilder setFormatName(String formatName) {
            this.formatName = formatName;
            return this;
        }

        public WatermarkBuilder setAlpha(float alpha) {
            this.alpha = alpha;
            return this;
        }

        public WatermarkBuilder setRotate(double rotate) {
            this.rotate = rotate;
            return this;
        }

        public WatermarkBuilder setX(float x) {
            this.x = x;
            return this;
        }

        public WatermarkBuilder setY(float y) {
            this.y = y;
            return this;
        }

        public WatermarkBuilder setText(String text) {
            this.text = text;
            return this;
        }

        public WatermarkBuilder setFont(Font font) {
            this.font = font;
            return this;
        }

        public WatermarkBuilder setColor(Color color) {
            this.color = color;
            return this;
        }

        public Watermark build() throws JToolException {
            if (this.type == null) {
                throw new JToolException(ErrorCode.INVALID_PARAMS, "; need to set watermark type");
            }

            checkWatermarkParams();

            if (this.type == Type.TEXT) {
                checkTextWatermarkParams();
                TextWatermark watermark = new TextWatermark();
                watermark.setAlpha(this.alpha);
                watermark.setFormatName(this.formatName);
                watermark.setRotate(this.rotate);
                watermark.setText(text);
                watermark.setFont(this.font);
                watermark.setColor(this.color);
                watermark.setX(this.x);
                watermark.setY(this.y);
                return watermark;
            } else {
                checkImageWatermarkParams();
                ImageWatermark watermark = new ImageWatermark();
                watermark.setAlpha(this.alpha);
                watermark.setFormatName(this.formatName);
                watermark.setRotate(this.rotate);
                watermark.setImgPath(imgPath);
                watermark.setX((int)this.x);
                watermark.setY((int)this.y);
                return watermark;
            }
        }

        private void checkWatermarkParams() throws JToolException {
            if (this.alpha == 0f) {
                throw new JToolException(ErrorCode.INVALID_PARAMS, "; need to set alpha");
            }

            if (this.x == 0f) {
                throw new JToolException(ErrorCode.INVALID_PARAMS, "; need to set x(the x coordinate of text)");
            }

            if (this.y == 0f) {
                throw new JToolException(ErrorCode.INVALID_PARAMS, "; need to set y(the y coordinate of text)");
            }
        }

        private void checkTextWatermarkParams() throws JToolException {
            if (this.text == null || this.text.length() == 0) {
                throw  new JToolException(ErrorCode.INVALID_PARAMS, "; need to set text");
            }
        }

        private void checkImageWatermarkParams() throws JToolException {
            if (this.imgPath == null || this.imgPath.length() < 4) {
                throw  new JToolException(ErrorCode.INVALID_PARAMS, "; need to set img path");
            }
        }
    }
}
