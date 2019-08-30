package cn.tommyyang.jtools.image;

/**
 * @Author : TommyYang
 * @Time : 2019-08-30 11:52
 * @Software: IntelliJ IDEA
 * @File : ImageWatermark.java
 */
public class ImageWatermark extends Watermark {

    // 水印图片
    private String imgPath;
    // 水印位于图片左上角的 x 坐标值
    private int x;
    // 水印位于图片左上角的 y 坐标值
    private int y;

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return super.toString() + "; ImageWatermark{" +
                "imgPath='" + imgPath + '\'' +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
