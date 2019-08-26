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

    public static BufferedImage addWaterMark(String imgPath, String markPath,
                                             int x, int y, float alpha) {
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

    public static void addTextMark(String imgPath, String text, Font font, Color color,
                                   float x, float y, float alpha, String destPath) {

    }

}
