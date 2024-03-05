import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) {
        try{
            BufferedImage image = ImageIO.read(new File("img.png"));
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < image.getHeight(); i++) {
                for (int j = 0; j < image.getWidth(); j++) {
                    int color = image.getRGB(j,i); // x,y
                    int red = (color >>> 16)& 0xFF;
                    int green = (color >>> 8)& 0xFF;
                    int blue = (color) & 0xFF;
                    double luminance = (red*0.2126 + green*0.7152 + blue*0.0722)/255;
                    builder.append(changeLuminanceToChar(luminance));
                }
                builder.append("\n");
            }
            PrintWriter writer = new PrintWriter("test.txt");
            writer.print(builder);
            writer.close();
        } catch(Exception exception){
            throw new RuntimeException(exception);
        }
    }
    public static char changeLuminanceToChar(double luminance){
        if (luminance <= 0.1){
            return '@';
        } else if (luminance <= 0.2){
            return '.';
        } else if(luminance <= 0.3){
            return '-';
        } else if(luminance <= 0.4){
            return '?';
        } else if(luminance <= 0.5){
            return '$';
        } else if(luminance <= 0.6){
            return '#';
        } else if(luminance <= 0.7){
            return '&';
        }else if(luminance <= 0.8){
            return '*';
        }else if(luminance <= 0.9){
            return '`';
        }else if(luminance <= 1){
            return '+';
        }
        return 'a';
    }
}
