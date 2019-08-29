package cn.tommyyang.jtools.image;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * @Author : TommyYang
 * @Time : 2019-08-26 14:39
 * @Software: IntelliJ IDEA
 * @File : ImageTools.java
 */
public class ImageTools {

    private static final float DEFAULT_QUALITY = 0.215f;

    /**
     *
     * 添加水印图片（物理存盘，存盘文件使用原来的格式）
     *
     * @param imgPath 待加水印的图片
     *
     * @param markPath 水印图片
     *
     * @param x 水印位于图片左上角的 x 坐标值
     *
     * @param y 水印位于图片左上角的 y 坐标值
     *
     * @param alpha 水印透明度 0.1f ~ 1.0f
     *
     * @param destPath 文件存放路径
     *
     * @throws RuntimeException
     *
     * */
    public static void addWaterMark(String imgPath, String markPath, int x, int y,
                                    float alpha, String destPath) throws RuntimeException {
        try {
            BufferedImage bfImage = addWaterMark(imgPath, markPath, x, y, alpha);
            ImageIO.write(bfImage, imgFormat(imgPath), new File(destPath));
        } catch (Exception e) {
            throw new RuntimeException("添加图片水印异常");
        }
    }

    /**
     *
     * 添加水印图片（物理存盘，存盘文件使用自定义格式）
     *
     * @param imgPath 待加水印的图片
     *
     * @param markPath 水印图片
     *
     * @param x 水印位于图片左上角的 x 坐标值
     *
     * @param y 水印位于图片左上角的 y 坐标值
     *
     * @param alpha 水印透明度 0.1f ~ 1.0f
     *
     * @param format 存盘图片的图片格式
     *
     * @param destPath 文件存放路径
     *
     * @throws RuntimeException
     *
     * */
    public static void addWaterMark(String imgPath, String markPath, int x, int y,
                                    float alpha, String format, String destPath) {
        try {
            BufferedImage bfImage = addWaterMark(imgPath, markPath, x, y, alpha);
            ImageIO.write(bfImage, format, new File(destPath));
        } catch (Exception e) {
            throw new RuntimeException("添加图片水印异常");
        }
    }

    /**
     *
     * 添加水印图片
     *
     * @param imgPath 待加水印的图片
     *
     * @param markPath 水印图片
     *
     * @param x 水印位于图片左上角的 x 坐标值
     *
     * @param y 水印位于图片左上角的 y 坐标值
     *
     * @param alpha 水印透明度 0.1f ~ 1.0f
     *
     * @return  BufferedImage 处理后的图片对象
     *
     * @throws RuntimeException
     *
     */
    public static BufferedImage addWaterMark(String imgPath, String markPath,
                                             int x, int y, float alpha) throws RuntimeException {
        BufferedImage targtImg;
        try {
            Image img = ImageIO.read(new File(imgPath));
            targtImg = new BufferedImage(img.getWidth(null), img.getHeight(null),
                    BufferedImage.TYPE_INT_RGB);
            Graphics2D g = targtImg.createGraphics();
            g.drawImage(img, 0, 0, null);
            Image markImg = ImageIO.read(new File(markPath));
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));
            g.drawImage(markImg, x, y, null);
            g.dispose();
        } catch (Exception e) {
            throw new RuntimeException("添加图片水印错误");
        }

        return targtImg;
    }

    public static BufferedImage addTextMark(String imgPath, String text, Font font, Color color,
                                   float x, float y, float alpha) {
        BufferedImage targetImg;
        try {
            Font ffont = (font == null) ? new Font("宋体", 20 ,13) : font;
            Image img = ImageIO.read(new File(imgPath));
            targetImg = new BufferedImage(img.getWidth(null), img.getHeight(null),
                    BufferedImage.TYPE_INT_RGB);
            Graphics2D g = targetImg.createGraphics();
            g.drawImage(img, 0, 0, null);
            g.setFont(ffont);
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));
            g.drawString(text, x, y);
            g.dispose();
        } catch (Exception e) {
            throw new RuntimeException("添加文字水印错误");
        }

        return targetImg;
    }

    public static String imgFormat(String imgPath) throws Exception {
        return imgPath.substring(imgPath.lastIndexOf(".") + 1);
    }

}
