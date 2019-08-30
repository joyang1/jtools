package cn.tommyyang.jtools.image;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

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
     * 添加水印图片
     *
     * @param imgPath 待加水印的图片
     *
     * @param destPath 图片存放路径
     *
     * @return  BufferedImage 处理后的图片对象
     *
     * @throws RuntimeException
     *
     */
    public static void addWaterMark(String imgPath, ImageWatermark watermark, String destPath) throws RuntimeException {
        BufferedImage bfImage;
        try {
            Image img = ImageIO.read(new File(imgPath));
            bfImage = new BufferedImage(img.getWidth(null), img.getHeight(null),
                    BufferedImage.TYPE_INT_RGB);

            Graphics2D g = bfImage.createGraphics();
            g.drawImage(img, 0, 0, null);
            Image markImg = ImageIO.read(new File(watermark.getImgPath()));
            BufferedImage newMarkImg = rotateImg(markImg, watermark.getRotate(), watermark.getAlpha());
            g.drawImage(newMarkImg, watermark.getX(), watermark.getY(), null);

            ImageIO.write(bfImage, watermark.getFormatName(), new File(destPath));
        } catch (Exception e) {
            throw new RuntimeException("add image watermark error");
        }
    }

    private static BufferedImage rotateImg(Image img, double rotate, float alpha) {
        int width = img.getWidth(null);
        int height = img.getHeight(null);
        BufferedImage newImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = newImage.createGraphics();
        g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));
        g.rotate(Math.toRadians(rotate), width/2, height/2);
        g.drawImage(img, null, null);
//        g.dispose();

        return newImage;
    }

    /**
     *
     * 添加文字水印
     *
     * @param imgPath 待加水印的图片
     *
     * @param watermark 水印信息
     *
     * @param destPath 图片存放路径
     *
     * @throws RuntimeException
     *
     * */
    public static void addTextMark(String imgPath, TextWatermark watermark, String destPath) throws RuntimeException {
        BufferedImage bfImage;
        try {
            Font ffont = watermark.getFont();
            Image img = ImageIO.read(new File(imgPath));
            bfImage = new BufferedImage(img.getWidth(null), img.getHeight(null),
                    BufferedImage.TYPE_INT_RGB);

            Graphics2D g = bfImage.createGraphics();
            g.drawImage(img, 0, 0, null);
            g.setColor(watermark.getColor());
            AffineTransform affineTransform = new AffineTransform();
            affineTransform.rotate(Math.toRadians(watermark.getRotate()), 0, 0);
            Font rfont = ffont.deriveFont(affineTransform);
            g.setFont(rfont);
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, watermark.getAlpha()));
            g.drawString(watermark.getText(), watermark.getX(), watermark.getY());
            g.dispose();

            ImageIO.write(bfImage, watermark.getFormatName(), new File(destPath));
        } catch (Exception e) {
            throw new RuntimeException("add text watermark error");
        }
    }

}
