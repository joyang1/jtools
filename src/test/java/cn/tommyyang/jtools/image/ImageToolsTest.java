package cn.tommyyang.jtools.image;

import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * @Author : TommyYang
 * @Time : 2019-08-30 10:49
 * @Software: IntelliJ IDEA
 * @File : ImageToolsTest.java
 */
public class ImageToolsTest {

    @Test
    public void testAddTextMark() throws Exception {
        String imgPath = "/Users/tommy/Documents/VPProjects/Tommy学习录图片库/设计模式/策略模式类图1.jpg";
        String destPath1 = "/Users/tommy/Documents/VPProjects/Tommy学习录图片库/设计模式/策略模式类图.jpg";
//        String destPath2 = "/Users/tommy/Documents/test-imgMark.png";
//        String markPath = "/Users/tommy/Documents/watermark.png";
        Image img = ImageIO.read(new File(imgPath));
        float x = ((BufferedImage) img).getWidth() / 2;
        float y = ((BufferedImage) img).getHeight() / 2;

        Font font = new Font(Font.SERIF, Font.BOLD, 20);
        TextWatermark textWatermark = (TextWatermark) Watermark.WatermarkBuilder.newBuilder().setType(Watermark.Type.TEXT)
                .setAlpha(0.4f).setColor(Color.RED).setFont(font).setRotate(-45)
                .setText("Tommy 学习录").setX(x).setY(y).build();

//        ImageWatermark imageWatermark = (ImageWatermark)Watermark.WatermarkBuilder.newBuilder().setType(Watermark.Type.IMAGE).setRotate(45)
//                .setAlpha(0.6f).setImgPath(markPath).setX(x).setY(y).build();

        ImageTools.addTextMark(imgPath, textWatermark, destPath1);
//        ImageTools.addWaterMark(imgPath, imageWatermark, destPath2);
    }

}
