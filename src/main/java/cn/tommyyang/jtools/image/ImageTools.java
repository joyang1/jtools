package cn.tommyyang.jtools.image;

import sun.font.FontDesignMetrics;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
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
     * 添加水印图片
     *
     * @param imgPath  待加水印的图片
     * @param destPath 图片存放路径
     * @return BufferedImage 处理后的图片对象
     * @throws RuntimeException
     */
    public static void addWaterMark(String imgPath, ImageWatermark watermark, String destPath) throws RuntimeException {
        BufferedImage bfImage;
        try {
            Image img = ImageIO.read(new File(imgPath));
            bfImage = new BufferedImage(img.getWidth(null), img.getHeight(null),
                    BufferedImage.TYPE_INT_RGB);

            Graphics2D g = bfImage.createGraphics();
            g.drawImage(img, 0, 0, null);
            BufferedImage markImg = ImageIO.read(new File(watermark.getImgPath()));
            BufferedImage newMarkImg = rotateImg(markImg, watermark.getRotate());
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, watermark.getAlpha()));
            g.drawImage(newMarkImg, watermark.getX() - newMarkImg.getWidth() / 2, watermark.getY() - newMarkImg.getHeight() / 2, null);
            g.dispose();

            ImageIO.write(bfImage, watermark.getFormatName(), new File(destPath));
        } catch (Exception e) {
            throw new RuntimeException("add image watermark error");
        }
    }

    /**
     * 旋转图片方法一
     *
     * @param img    目标图片
     * @param rotate 旋转的角度
     */
    public static BufferedImage rotateImg(BufferedImage img, double rotate) {
        int width = img.getWidth(null);
        int height = img.getHeight(null);
        Rectangle desRect = calcRotatedSize(new Rectangle(new Dimension(width, height)), rotate);

        BufferedImage newImage = new BufferedImage(desRect.width, desRect.height, img.getType());
        Graphics2D g = newImage.createGraphics();
        g.translate((desRect.width - width) / 2, (desRect.height - height) / 2);
        g.rotate(Math.toRadians(rotate), width / 2, height / 2);
        g.drawImage(img, null, null);
        g.dispose();

        return newImage;
    }

    private static Rectangle calcRotatedSize(Rectangle srcRect, double angle) {
        if (angle < 0) {
            angle = 360 + angle;
        }
        if (angle >= 90) {
            if (angle / 90 % 2 == 1) {
                int tmp = srcRect.height;
                srcRect.height = srcRect.width;
                srcRect.width = tmp;
            }

            angle = angle % 90;
        }

        double r = Math.sqrt(srcRect.width * srcRect.width + srcRect.height * srcRect.height) / 2;
        double len = r * Math.sin(Math.toRadians(angle) / 2) * 2;
        double angle1 = (Math.PI - Math.toRadians(angle)) / 2;
        double angle2 = Math.atan((double) srcRect.height / srcRect.width);
        double angle3 = Math.atan((double) srcRect.width / srcRect.height);

        int addWidth = (int) (len * Math.cos(Math.PI - angle1 - angle2));
        int addHeight = (int) (len * Math.cos(Math.PI - angle1 - angle3));

        int desWidth = srcRect.width + addWidth * 2;
        int desHeight = srcRect.height + addHeight * 2;

        return new Rectangle(new Dimension(desWidth, desHeight));
    }

    /**
     * 旋转图片方法二
     *
     * @param img    目标图片
     * @param rotate 旋转的角度
     */
    public static BufferedImage rotateImg2(BufferedImage img, double rotate) {
        int iw = img.getWidth();// 原始图象的宽度
        int ih = img.getHeight();// 原始图象的高度
        int w = 0;
        int h = 0;
        int x = 0;
        int y = 0;
        rotate = rotate % 360;
        if (rotate < 0)
            rotate = 360 + rotate;// 将角度转换到0-360度之间
        double ang = Math.toRadians(rotate);// 将角度转为弧度

        /**
         * 确定旋转后的图象的高度和宽度
         */

        if (rotate == 180 || rotate == 0 || rotate == 360) {
            w = iw;
            h = ih;
        } else if (rotate == 90 || rotate == 270) {
            w = ih;
            h = iw;
        } else {
            int d = iw + ih;
            w = (int) (d * Math.abs(Math.cos(ang)));
            h = (int) (d * Math.abs(Math.sin(ang)));
        }

        x = (w / 2) - (iw / 2);// 确定原点坐标
        y = (h / 2) - (ih / 2);
        BufferedImage rotatedImage = new BufferedImage(w, h, img.getType());

        AffineTransform at = new AffineTransform();
        at.rotate(ang, w / 2, h / 2);// 旋转图象
        at.translate(x, y);
        AffineTransformOp op = new AffineTransformOp(at,
                AffineTransformOp.TYPE_BICUBIC);
        op.filter(img, rotatedImage);
        img = rotatedImage;

        return img;
    }

    /**
     * 添加文字水印
     *
     * @param imgPath   待加水印的图片
     * @param watermark 水印信息
     * @param destPath  图片存放路径
     * @throws RuntimeException
     */
    public static void addTextMark(String imgPath, TextWatermark watermark, String destPath) throws RuntimeException {
        BufferedImage bfImage;
        try {
            Font ffont = watermark.getFont();
            Image img = ImageIO.read(new File(imgPath));
            bfImage = new BufferedImage(img.getWidth(null), img.getHeight(null),
                    BufferedImage.TYPE_INT_RGB);


            Graphics2D g = bfImage.createGraphics();
            g.setPaint(Color.LIGHT_GRAY);
            g.fillRect(0, 0, ((BufferedImage) img).getWidth(), ((BufferedImage) img).getHeight());
            g.drawImage(img, 0, 0, null);
            g.setColor(watermark.getColor());
            AffineTransform affineTransform = new AffineTransform();
            affineTransform.rotate(Math.toRadians(watermark.getRotate()), 0, 0);
            Font rfont = ffont.deriveFont(affineTransform);
            g.setFont(rfont);
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, watermark.getAlpha()));

            FontMetrics fm = FontDesignMetrics.getMetrics(rfont);
            g.drawString(watermark.getText(), watermark.getX(), watermark.getY() - fm.getHeight() / 2);
            g.dispose();

            ImageIO.write(bfImage, watermark.getFormatName(), new File(destPath));
        } catch (Exception e) {
            throw new RuntimeException("add text watermark error");
        }
    }

}
