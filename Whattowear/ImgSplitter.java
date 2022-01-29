

import javax.imageio.ImageIO;

import java.awt.*;
import java.awt.image.BufferedImage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;

public class ImgSplitter {
    public void split(BufferedImage img) {
        try {
            BufferedImage[] arr = new BufferedImage[731];
            int subImgWidth = img.getWidth() / 17;
            int subImgHeight = img.getHeight() / 43;
            int currImg = 0;
            for (int i = 0; i < 43; i++) {
                for (int j = 0; j < 17; j++) {
                    arr[currImg] = new BufferedImage(subImgWidth, subImgHeight, img.getType());
                    Graphics2D img_creator = arr[currImg].createGraphics();
                    int src_first_x = subImgWidth * j;
                    int src_first_y = subImgHeight * i;
                    int dst_corner_x = subImgWidth * j + subImgWidth;
                    int dst_corner_y = subImgHeight * i + subImgHeight;
                    img_creator.drawImage(img, 0, 0, subImgWidth, subImgHeight, src_first_x, src_first_y, dst_corner_x, dst_corner_y, null);
                    Image tmp = arr[currImg].getScaledInstance(20, 20, Image.SCALE_DEFAULT);
                    arr[currImg] = new BufferedImage(20, 20, arr[currImg].getType());
                    img_creator = arr[currImg].createGraphics();
                    img_creator.drawImage(tmp, 0,0,null);
                    currImg++;
                }
            }
            File inputData = new File("inputData.txt");
            FileWriter writer = new FileWriter(inputData);
            File outputFile = new File("img" + currImg + ".jpg");
            ImageIO.write(arr[400], "jpg", outputFile);
            System.out.println(arr[400].getWidth() + " " + arr[400].getHeight());
            for(int i = 0; i < 731; i++) {
                StringBuilder features = new StringBuilder();
                for(int x = 0; x < arr[i].getWidth(); x++) {
                   for(int y = 0; y < arr[i].getHeight(); y++) {
                       Color color = new Color(arr[i].getRGB(x,y));
                       double brightness = 0.2126 * color.getRed() + 0.7152 * color.getGreen() + 0.0722 * color.getBlue();
                       features.append(brightness + " ");
                   }
                }
                features.append("\n");
                writer.write(features.toString());
            }
            writer.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            File file = new File("mlimg.jpg");
            FileInputStream sourceFile = new FileInputStream(file);
            BufferedImage image = ImageIO.read(sourceFile);
            ImgSplitter splitter= new ImgSplitter();
            splitter.split(image);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
