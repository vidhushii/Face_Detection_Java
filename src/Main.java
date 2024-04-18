import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.*;
class HelperClass {


    public static boolean convertImg(String inputImgPath,
                                     String outputImgPath,
                                     String formatType)

            throws IOException
    {


        FileInputStream inputStream
                = new FileInputStream(inputImgPath);


        FileOutputStream outputStream
                = new FileOutputStream(outputImgPath);

        // Reading the input image from file
        BufferedImage inputImage
                = ImageIO.read(inputStream);


        boolean result = ImageIO.write(
                inputImage, formatType, outputStream);


        outputStream.close();
        inputStream.close();

        return result;
    }
}
public class Main {


    public static void main(String[] args) throws Exception{
        JFrame f=new JFrame("FACE DETECTION AND IMAGE PROCESSING");
        JButton b0=new JButton("SELECT OPTIONS BELOW");
        JButton b1=new JButton("Face Detection");
        JButton b2=new JButton("Convert To Negative Image");
        JButton b3=new JButton("Add Red Shade");
        JButton b4=new JButton("Add Sepia Shade");
        JButton b5=new JButton("Get Mirror Image");
        JButton b6=new JButton("Get Black And White Image");
        JButton b7=new JButton("Crop Image");
        JButton b8=new JButton("Convert PNG To JPEG");
        JButton b9=new JButton("Compare Two Images");
        b0.setBounds(290,50,950,40);
        b0.setBackground(Color.pink);
        b0.setFont(new Font("Cooper Black", Font.ITALIC, 40));
        f.add(b0);
        f.setSize(400,400);
        f.setLayout(null);
        f.setVisible(true);

        b1.setBounds(290,100,950,30); //290,50,950,30
        b1.setBackground(Color.pink);
        b1.setFont(new Font("Cooper Black", Font.ITALIC, 40));
        f.add(b1);
        f.setSize(400,400);
        f.setLayout(null);
        f.setVisible(true);
        //JButton b2=new JButton("Convert To Negative Image");
        b2.setBounds(290,150,950,30);
        b2.setBackground(Color.pink);
        b2.setFont(new Font("Cooper Black", Font.ITALIC, 40));
        f.add(b2);
        f.setSize(400,400);
        f.setLayout(null);
        f.setVisible(true);
        //JButton b3=new JButton("Add Red Shade");
        b3.setBounds(290,200,950,30);
        b3.setBackground(Color.pink);
        b3.setFont(new Font("Cooper Black", Font.ITALIC, 40));
        f.add(b3);
        f.setSize(400,400);
        f.setLayout(null);
        f.setVisible(true);
        //JButton b4=new JButton("Add Sepia Shade");
        b4.setBounds(290,250,950,30);
        b4.setBackground(Color.pink);
        b4.setFont(new Font("Cooper Black", Font.ITALIC, 40));
        f.add(b4);
        f.setSize(400,400);
        f.setLayout(null);
        f.setVisible(true);
        // JButton b5=new JButton("Get Mirror Image");
        b5.setBounds(290,300,950,30);
        b5.setBackground(Color.pink);
        b5.setFont(new Font("Cooper Black", Font.ITALIC, 40));
        f.add(b5);
        f.setSize(400,400);
        f.setLayout(null);
        f.setVisible(true);
        //   JButton b6=new JButton("Get Black And White Image");
        b6.setBounds(290,350,950,30);
        b6.setBackground(Color.pink);
        b6.setFont(new Font("Cooper Black", Font.ITALIC, 40));
        f.add(b6);
        f.setSize(400,400);
        f.setLayout(null);
        f.setVisible(true);
        //  JButton b7=new JButton("Crop Image");
        b7.setBounds(290,400,950,30);
        b7.setBackground(Color.pink);
        b7.setFont(new Font("Cooper Black", Font.ITALIC, 40));
        f.add(b7);
        f.setSize(400,400);
        f.setLayout(null);
        f.setVisible(true);
        //  JButton b8=new JButton("Convert PNG To JPEG");
        b8.setBounds(290,450,950,30);
        b8.setBackground(Color.pink);
        b8.setFont(new Font("Cooper Black", Font.ITALIC, 40));
        f.add(b8);
        f.setSize(400,400);
        f.setLayout(null);
        f.setVisible(true);
        //   JButton b9=new JButton("Compare Two Images");
        b9.setBounds(290,500,950,30);
        b9.setBackground(Color.pink);
        b9.setFont(new Font("Cooper Black", Font.ITALIC, 40));
        f.add(b9);
        f.setSize(400,400);
        f.setLayout(null);
        f.setVisible(true);

        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JFrame f1=new JFrame("FACE DETECTION");
                f1.setSize(400,400);
                JTextField tf1=new JTextField();
                tf1.setBounds(290,50,950,30);
                JButton l1;
                l1=new JButton("Enter Image Input Path");
                l1.setBounds(50,50, 200,30);
                l1.setBackground(Color.pink);
                l1.setFont(new Font("Cooper Black", Font.ITALIC, 10));
                f1.add(tf1);
                f1.add(l1);

                /*JFileChooser Chooser = new JFileChooser();
                //Chooser.showOpenDialog(null);
                int response=Chooser.showOpenDialog(null);
                if(response==JFileChooser.APPROVE_OPTION){
                    File file=new File(Chooser.getSelectedFile().getAbsolutePath());

                }*/
                f1.setLayout(null);
                f1.setVisible(true);
                tf1.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        String file=tf1.getText();
                        //System.out.println(file);
                        //String file="D:\\chintu.jpg";
                        System.out.println(file);
                        CascadeClassifier faceDetector
                                = new CascadeClassifier();
                        faceDetector.load(
                                "haarcascade_frontalface_alt.xml");
                        Mat image = Imgcodecs.imread(file);

                        // Detecting faces
                        MatOfRect faceDetections = new MatOfRect();
                        faceDetector.detectMultiScale(image,
                                faceDetections);
                        for (Rect rect : faceDetections.toArray()) {
                            Imgproc.rectangle(image,       //where to draw the box
                                    new Point(rect.x, rect.y),   //bottom left
                                    new Point(rect.x + rect.width, rect.y + rect.height),  //top right
                                    new Scalar(0, 0, 255),
                                    3);    //RGB color
                        }

                        String filename = "C:\\FaceDetectionImg\\facedetectionoutput.jpg";

                        Imgcodecs.imwrite(filename, image);
                        try{
                            File file1 = new File("C:\\FaceDetectionImg\\facedetectionoutput.jpg");
                            BufferedImage bufferedImage = ImageIO.read(file1);

                            ImageIcon imageIcon = new ImageIcon(bufferedImage);
                            JFrame jFrame = new JFrame();

                            jFrame.setLayout(new FlowLayout());

                            //jFrame.setSize(100, 2);
                            JLabel jLabel = new JLabel();

                            jLabel.setIcon(imageIcon);
                            jFrame.add(jLabel);
                            jFrame.setVisible(true);

                            jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);}
                        catch(Exception er){
                            System.out.println(er);
                        }
                        System.out.print("Face Detected");
                    }});
                System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
            }
        });
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JFrame f2=new JFrame("Negative Image");
                f2.setSize(400,400);
                JTextField tf2=new JTextField();
                tf2.setBounds(290,50,950,30);
                JButton l2;
                l2=new JButton("Enter Image Input Path");
                l2.setBounds(50,50, 200,30);
                l2.setBackground(Color.pink);
                l2.setFont(new Font("Cooper Black", Font.ITALIC, 10));
                f2.add(tf2);
                f2.add(l2);
                f2.setLayout(null);
                f2.setVisible(true);
                tf2.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){

                        String fileneg=tf2.getText();
                        System.out.println(fileneg);
                        BufferedImage img = null;
                        File filenegg = null;
                        try {

                            filenegg= new File(fileneg);
                            img = ImageIO.read(filenegg);
                        }
                        catch (IOException en) {
                            System.out.println(en);
                            System.out.println("no raed");
                        }

                        // Get image width and height
                        int width = img.getWidth();
                        int height = img.getHeight();

                        // Convert to negative
                        for (int y = 0; y < height; y++) {
                            for (int x = 0; x < width; x++) {
                                int p = img.getRGB(x, y);
                                int a = (p >> 24) & 0xff;
                                int r = (p >> 16) & 0xff;
                                int g = (p >> 8) & 0xff;
                                int b = p & 0xff;

                                // subtract RGB from 255
                                r = 255 - r;
                                g = 255 - g;
                                b = 255 - b;

                                // set new RGB value
                                p = (a << 24) | (r << 16) | (g << 8) | b;
                                img.setRGB(x, y, p);
                            }
                        }

                        // write image
                        try {

                            File filen = new File("C:\\FaceDetectionImg\\negativeimageoutput.jpg");
                            ImageIO.write(img, "jpg", filen);
                            System.out.println("successfull");
                        }
                        catch (IOException errorneg) {
                            System.out.println(errorneg);
                            System.out.println("no write");
                        }




                        try{
                            File file2neg = new File("C:\\FaceDetectionImg\\negativeimageoutput.jpg");
                            BufferedImage bufferedImage2 = ImageIO.read(file2neg);

                            ImageIcon imageIcon2 = new ImageIcon(bufferedImage2);
                            JFrame jFrame2 = new JFrame();

                            jFrame2.setLayout(new FlowLayout());

                            //jFrame.setSize(100, 2);
                            JLabel jLabel2 = new JLabel();

                            jLabel2.setIcon(imageIcon2);
                            jFrame2.add(jLabel2);
                            jFrame2.setVisible(true);

                            jFrame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);}
                        catch(Exception er){
                            //System.out.println(er);
                            System.out.println("no display");
                        }
                    }});

            }
        });

        b3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent errr){
                JFrame f3=new JFrame("Red Shade");
                f3.setSize(400,400);
                JTextField tf3=new JTextField();
                tf3.setBounds(290,50,950,30);
                JButton l3;
                l3=new JButton("Enter Image Input Path");
                l3.setBounds(50,50, 200,30);
                l3.setBackground(Color.pink);
                l3.setFont(new Font("Cooper Black", Font.ITALIC, 10));
                f3.add(tf3);
                f3.add(l3);
                f3.setLayout(null);
                f3.setVisible(true);
                tf3.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){ //D:\cricket.jpeg

                        String filered=tf3.getText();
                        System.out.println(filered);
                        BufferedImage imgr = null;
                        File fr = null;

                        // read image
                        try {
                            //System.out.println("Enter input path");

                            fr = new File(filered);
                            imgr = ImageIO.read(fr);
                        }
                        catch (IOException err) {
                            System.out.println(err);
                        }

                        // get width and height
                        int width = imgr.getWidth();
                        int height = imgr.getHeight();

                        // convert to red image
                        for (int y = 0; y < height; y++) {
                            for (int x = 0; x < width; x++) {
                                int p = imgr.getRGB(x, y);

                                int a = (p >> 24) & 0xff;
                                int r = (p >> 16) & 0xff;

                                // set new RGB keeping the r
                                // value same as in original image
                                // and setting g and b as 0.
                                p = (a << 24) | (r << 16) | (0 << 8) | 0;

                                imgr.setRGB(x, y, p);
                            }
                        }

                        // write image
                        try {
                            //System.out.println("Enter output path:");
                            String o="C:\\FaceDetectionImg\\redshadeoutput.jpg";
                            fr = new File(o);
                            ImageIO.write(imgr, "jpg", fr);
                        }
                        catch (IOException ered) {
                            System.out.println(ered);
                        }

                        try{
                            File file2neg = new File("C:\\FaceDetectionImg\\redshadeoutput.jpg");
                            BufferedImage bufferedImage3 = ImageIO.read(file2neg);

                            ImageIcon imageIcon3 = new ImageIcon(bufferedImage3);
                            JFrame jFrame3 = new JFrame();

                            jFrame3.setLayout(new FlowLayout());

                            //jFrame.setSize(100, 2);
                            JLabel jLabel3= new JLabel();

                            jLabel3.setIcon(imageIcon3);
                            jFrame3.add(jLabel3);
                            jFrame3.setVisible(true);

                            jFrame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);}
                        catch(Exception er){
                            //System.out.println(er);
                            System.out.println("no display");
                        }
                    }});

            }
        });
        b4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JFrame f4=new JFrame("Sepia Effect");
                f4.setSize(400,400);
                JTextField tf4=new JTextField();
                tf4.setBounds(290,50,950,30);
                JButton l4;
                l4=new JButton("Enter Image Input Path");
                l4.setBounds(50,50, 200,30);
                l4.setBackground(Color.pink);
                l4.setFont(new Font("Cooper Black", Font.ITALIC, 10));
                f4.add(tf4);
                f4.add(l4);
                f4.setLayout(null);
                f4.setVisible(true);
                tf4.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){ //D:\cricket.jpeg

                        String filesep=tf4.getText();
                        System.out.println(filesep);
                        BufferedImage imgs = null;
                        File fs = null;

                        // read image
                        try {


                            fs = new File(filesep);
                            imgs = ImageIO.read(fs);
                        }
                        catch (IOException es) {
                            System.out.println(es);
                        }

                        // get width and height of the image
                        int width = imgs.getWidth();
                        int height = imgs.getHeight();

                        // convert to sepia
                        for (int y = 0; y < height; y++) {
                            for (int x = 0; x < width; x++) {
                                int p = imgs.getRGB(x, y);

                                int a = (p >> 24) & 0xff;
                                int R = (p >> 16) & 0xff;
                                int G = (p >> 8) & 0xff;
                                int B = p & 0xff;

                                // calculate newRed, newGreen, newBlue
                                int newRed = (int)(0.393 * R + 0.769 * G
                                        + 0.189 * B);
                                int newGreen = (int)(0.349 * R + 0.686 * G
                                        + 0.168 * B);
                                int newBlue = (int)(0.272 * R + 0.534 * G
                                        + 0.131 * B);

                                // check condition
                                if (newRed > 255)
                                    R = 255;
                                else
                                    R = newRed;

                                if (newGreen > 255)
                                    G = 255;
                                else
                                    G = newGreen;

                                if (newBlue > 255)
                                    B = 255;
                                else
                                    B = newBlue;

                                // set new RGB value
                                p = (a << 24) | (R << 16) | (G << 8) | B;

                                imgs.setRGB(x, y, p);
                            }
                        }

                        // write image
                        try {
                            //System.out.println("enter image path to store");
                            String o="C:\\FaceDetectionImg\\sepiashadeoutput.jpg";
                            fs = new File(o);
                            ImageIO.write(imgs, "png", fs);
                            System.out.println("success");
                        }
                        catch (IOException es) {
                            System.out.println(es);
                        }




                        try{
                            File file4sep = new File("C:\\FaceDetectionImg\\sepiashadeoutput.jpg");
                            BufferedImage bufferedImage4 = ImageIO.read(file4sep);

                            ImageIcon imageIcon4 = new ImageIcon(bufferedImage4);
                            JFrame jFrame4= new JFrame();

                            jFrame4.setLayout(new FlowLayout());

                            //jFrame.setSize(100, 2);
                            JLabel jLabel4= new JLabel();

                            jLabel4.setIcon(imageIcon4);
                            jFrame4.add(jLabel4);
                            jFrame4.setVisible(true);

                            jFrame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);}
                        catch(Exception er){
                            //System.out.println(er);
                            System.out.println("no display");
                        }
                    }});


            }
        });
        b5.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JFrame f5=new JFrame("Mirror Image");
                f5.setSize(400,400);
                JTextField tf5=new JTextField();
                tf5.setBounds(290,50,950,30);
                JButton l5;
                l5=new JButton("Enter Image Input Path");
                l5.setBounds(50,50, 200,30);
                l5.setBackground(Color.pink);
                l5.setFont(new Font("Cooper Black", Font.ITALIC, 10));
                f5.add(tf5);
                f5.add(l5);
                f5.setLayout(null);
                f5.setVisible(true);
                tf5.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){

                        String filemir=tf5.getText();
                        System.out.println(filemir);
                        BufferedImage simg = null;

                        // File object
                        File fm = null;

                        // Read source image file
                        try {
                            fm = new File(filemir);
                            simg = ImageIO.read(fm);
                        }

                        catch (IOException em) {
                            System.out.println("Error: " + em);
                        }

                        // Get source image dimension
                        int width = simg.getWidth();
                        int height = simg.getHeight();

                        // BufferedImage for mirror image
                        BufferedImage mimg = new BufferedImage(
                                width, height, BufferedImage.TYPE_INT_ARGB);

                        // Create mirror image pixel by pixel
                        for (int y = 0; y < height; y++) {
                            for (int lx = 0, rx = width - 1; lx < width; lx++, rx--) {

                                // lx starts from the left side of the image
                                // rx starts from the right side of the
                                // image lx is used since we are getting
                                // pixel from left side rx is used to set
                                // from right side get source pixel value
                                int p = simg.getRGB(lx, y);

                                // set mirror image pixel value
                                mimg.setRGB(rx, y, p);
                            }
                        }

                        // save mirror image
                        try {
                            //System.out.println("enter output path to store");
                            String o="C:\\FaceDetectionImg\\mirrorimageoutput.jpg";
                            fm = new File(o);
                            ImageIO.write(mimg, "png", fm);
                            System.out.println("sucess");
                        }
                        catch (IOException ess) {
                            System.out.println("Error: " + ess);
                        }



                        try{
                            File file2mir = new File("");
                            BufferedImage bufferedImage2 = ImageIO.read(file2mir);

                            ImageIcon imageIcon5 = new ImageIcon(bufferedImage2);
                            JFrame jFrame5 = new JFrame();

                            jFrame5.setLayout(new FlowLayout());

                            //jFrame.setSize(100, 2);
                            JLabel jLabel5 = new JLabel();

                            jLabel5.setIcon(imageIcon5);
                            jFrame5.add(jLabel5);
                            jFrame5.setVisible(true);

                            jFrame5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);}
                        catch(Exception er){
                            //System.out.println(er);
                            System.out.println("no display");
                        }
                    }});


            }
        });
        b6.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JFrame f6=new JFrame("Black And Image");
                f6.setSize(400,400);
                JTextField tf6=new JTextField();
                tf6.setBounds(290,50,950,30);
                JButton l6;
                l6=new JButton("Enter Image Input Path");
                l6.setBounds(50,50, 200,30);
                l6.setBackground(Color.pink);
                l6.setFont(new Font("Cooper Black", Font.ITALIC, 10));
                f6.add(tf6);
                f6.add(l6);
                f6.setLayout(null);
                f6.setVisible(true);
                tf6.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){ //D:\cricket.jpeg

                        String filebla=tf6.getText();
                        System.out.println(filebla);
                        BufferedImage imgb = null;
                        File fb = null;

                        // read image
                        try {
                            System.out.println("enter image path");

                            fb= new File(filebla);
                            imgb = ImageIO.read(fb);
                        }
                        catch (IOException ebl) {
                            System.out.println(ebl);
                        }

                        // get image's width and height
                        int width = imgb.getWidth();
                        int height = imgb.getHeight();

                        // convert to grayscale
                        for (int y = 0; y < height; y++) {
                            for (int x = 0; x < width; x++) {

                                // Here (x,y)denotes the coordinate of image
                                // for modifying the pixel value.
                                int p = imgb.getRGB(x, y);

                                int a = (p >> 24) & 0xff;
                                int r = (p >> 16) & 0xff;
                                int g = (p >> 8) & 0xff;
                                int b = p & 0xff;

                                // calculate average
                                int avg = (r + g + b) / 3;

                                // replace RGB value with avg
                                p = (a << 24) | (avg << 16) | (avg << 8)
                                        | avg;

                                imgb.setRGB(x, y, p);
                            }
                        }

                        // write image
                        try {
                            //System.out.println("enter path to save");
                            String o="C:\\FaceDetectionImg\\blackandwhiteoutput.jpg";
                            fb = new File(o);
                            ImageIO.write(imgb, "jpg", fb);
                        }
                        catch (IOException ebla) {
                            System.out.println(ebla);
                        }
                        try{
                            File file6bla = new File("C:\\FaceDetectionImg\\blackandwhiteoutput.jpg");
                            BufferedImage bufferedImage6 = ImageIO.read(file6bla);

                            ImageIcon imageIcon6 = new ImageIcon(bufferedImage6);
                            JFrame jFrame6 = new JFrame();

                            jFrame6.setLayout(new FlowLayout());

                            //jFrame.setSize(100, 2);
                            JLabel jLabel6 = new JLabel();

                            jLabel6.setIcon(imageIcon6);
                            jFrame6.add(jLabel6);
                            jFrame6.setVisible(true);

                            jFrame6.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);}
                        catch(Exception eb){
                            //System.out.println(er);
                            System.out.println("no display");
                        }
                    }});

            }
        });
        b7.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JFrame f7=new JFrame("Crop Image");
                f7.setSize(400,400);
                JTextField tf7=new JTextField();
                tf7.setBounds(290,50,950,30);
                JButton l7;
                l7=new JButton("Enter Image Input Path");
                l7.setBounds(50,50,200,30);
                l7.setBackground(Color.pink);
                l7.setFont(new Font("Cooper Black", Font.ITALIC, 10));
                JTextField tf7w=new JTextField();
                tf7w.setBounds(290,100,950,30);
                JButton lh=new JButton("Enter height");
                lh.setBounds(50,100,200,30);
                JButton lw=new JButton("Enter width");
                lw.setBounds(50,150,200,30);
                JTextField tf7h=new JTextField();
                tf7h.setBounds(290,150,950,30);
                tf7h.setFont(new Font("Cooper Black", Font.ITALIC, 10));
                tf7w.setFont(new Font("Cooper Black", Font.ITALIC, 10));
                f7.add(tf7h);
                f7.add(tf7w);
                f7.add(tf7);
                f7.add(l7);
                f7.add(lh);
                f7.add(lw);
                f7.setLayout(null);
                f7.setVisible(true);
                tf7.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){

                        String filecrop=tf7.getText();
                        System.out.println(filecrop);
                        tf7h.addActionListener(new ActionListener(){
                            public void actionPerformed(ActionEvent e) {
                                String height= tf7h.getText();
                                int heii=Integer.parseInt(height);
                                tf7w.addActionListener(new ActionListener(){
                                    public void actionPerformed(ActionEvent e) {
                                        String width = tf7w.getText();
                                        int wi = Integer.parseInt(width);
                                        System.out.println(wi);
                                        int hei=heii;
                                        System.out.println(heii);
                                        System.out.println(filecrop);
                                        try {

                                            // Reading original image from local path by
                                            // creating an object of BufferedImage class
                                            //System.out.println("enter image path");

                                            BufferedImage originalImg = ImageIO.read(
                                                    new File(filecrop));

                                            // Fetching and printing alongside the
                                            // dimensions of original image using getWidth()
                                            // and getHeight() methods
                                            System.out.println("Original Image Dimension: "
                                                    + originalImg.getWidth()
                                                    + "x"
                                                    + originalImg.getHeight());

                                            // Creating a subimage of given dimensions
                                            System.out.println("Enter height and width to crop");

                                            BufferedImage SubImg
                                                    = originalImg.getSubimage(50, 50, wi, hei);

                                            // Printing Dimensions of new image created
                                            System.out.println("Cropped Image Dimension: "
                                                    + SubImg.getWidth() + "x"
                                                    + SubImg.getHeight());

                                            // Creating new file for cropped image by
                                            // creating an object of File class
                                            System.out.println("Enter path to save");
                                            String o="C:\\FaceDetectionImg\\croppedimgoutput.jpg";
                                            File outputfile = new File(o);

                                            // Writing image in new file created
                                            ImageIO.write(SubImg, "png", outputfile);

                                            // Display message on console representing
                                            // proper execution of program
                                            System.out.println(
                                                    "Cropped Image created successfully");
                                        }

                                        // Catch block to handle the exceptions
                                        catch (IOException ec) {

                                            // Print the exception along with line number
                                            // using printStackTrace() method
                                            ec.printStackTrace();
                                        }
                                        try{
                                            File file1 = new File("C:\\FaceDetectionImg\\croppedimgoutput.jpg");
                                            BufferedImage bufferedImage = ImageIO.read(file1);

                                            ImageIcon imageIcon = new ImageIcon(bufferedImage);
                                            JFrame jFrame = new JFrame();

                                            jFrame.setLayout(new FlowLayout());

                                            //jFrame.setSize(100, 2);
                                            JLabel jLabel = new JLabel();

                                            jLabel.setIcon(imageIcon);
                                            jFrame.add(jLabel);
                                            jFrame.setVisible(true);

                                            jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);}
                                        catch(Exception er){
                                            System.out.println(er);
                                        }

                                    }});

                            }});
                    }});
            }
        });
        b8.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JFrame f8=new JFrame("Convert From PNG To JPEG");
                f8.setSize(400,400);
                JTextField tf8=new JTextField();
                tf8.setBounds(290,50,950,30);
                JButton l8,l8o;
                JTextField tf8o=new JTextField();
                tf8o.setBounds(290,150,950,30);
                l8=new JButton("Enter Image Input Path");
                l8.setBackground(Color.pink);
                l8.setFont(new Font("Cooper Black", Font.ITALIC, 10));
                l8.setBounds(50,50, 200,30);
                l8o=new JButton("Enter Image Path to store");
                l8o.setBackground(Color.pink);
                l8o.setFont(new Font("Cooper Black", Font.ITALIC, 10));
                l8o.setBounds(50,150, 200,30);
                f8.add(tf8);
                f8.add(l8);
                f8.add(tf8o);
                f8.add(l8o);
                f8.setLayout(null);
                f8.setVisible(true);
                tf8.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        //tf2.getText(); String fileneg="D:\cricket.jpeg";
                        String filepng=tf8.getText();
                        System.out.println(filepng);
                        tf8o.addActionListener(new ActionListener(){
                            public void actionPerformed(ActionEvent e) {
                                String formatType = "JPEG";
                                String outputImage=tf8o.getText();
                                System.out.println(outputImage);
                                // Try block to check for exceptions
                                try {
                                    // result will store boolean value whether image
                                    // is converted successfully or not

                                    boolean result = HelperClass.convertImg(
                                            filepng, outputImage, formatType);

                                    if (result) {

                                        // Display message when image is converted
                                        // successfully
                                        System.out.println(
                                                "Image converted to jpeg successfully.");
                                        JFrame f8p=new JFrame("Convert From PNG To JPEG");
                                        JButton mes=new JButton("Image converted to jpeg successfully.");
                                        mes.setBounds(290,250,950,30);
                                        f8p.add(mes);
                                        f8p.setLayout(null);
                                        f8p.setVisible(true);
                                    } else {

                                        // Display message when image is not
                                        // converted successfully
                                        System.out.println(
                                                "Could not convert image.");
                                    }
                                }

                                // Catch block to handle the exceptions
                                catch (IOException ex) {

                                    // Display message when exception is thrown
                                    System.out.println(
                                            "Error during converting image.");

                                    // Print the line number
                                    // where the exception occurred
                                    ex.printStackTrace();
                                }
                            }});
                    }});

            }
        });
        b9.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JFrame f9=new JFrame("Compare Two Images");
                f9.setSize(400,400);
                JTextField tf91=new JTextField();
                tf91.setBounds(290,50,950,30);
                JButton l91;
                l91=new JButton("Enter First Image Path");
                l91.setBounds(50,50, 200,30);
                l91.setBackground(Color.pink);
                l91.setFont(new Font("Cooper Black", Font.ITALIC, 10));
                f9.add(tf91);
                f9.add(l91);
                JTextField tf92=new JTextField();
                tf92.setBounds(290,100,950,30);
                JButton l92;
                l92=new JButton("Enter Second Image Path");
                l92.setBounds(50,100, 200,30);
                l92.setBackground(Color.pink);
                l92.setFont(new Font("Cooper Black", Font.ITALIC, 10));
                f9.add(tf92);
                f9.add(l92);
                f9.setLayout(null);
                f9.setVisible(true);

                tf91.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){ //D:\cricket.jpeg
                        //tf2.getText(); String fileneg="D:\cricket.jpeg";
                        String file1c=tf91.getText();
                        System.out.println(file1c);
                        tf92.addActionListener(new ActionListener(){
                            public void actionPerformed(ActionEvent e){ //D:\cricket.jpeg
                                //tf2.getText(); String fileneg="D:\cricket.jpeg";
                                String file2c=tf92.getText();
                                System.out.println(file2c);
                                BufferedImage imgA = null;
                                BufferedImage imgB = null;
                                // Try block to check for exception
                                try {

                                    // Reading file from local directory by
                                    // creating object of File class
                                    //System.out.println("enter input imag1 path");
                                    //String in=sc.next();
                                    File fileA
                                            = new File(file1c);
                                    //System.out.println("Enter image 2 path");
                                    //String o=sc.next();
                                    File fileB
                                            = new File(file2c);

                                    // Reading files
                                    imgA = ImageIO.read(fileA);
                                    imgB = ImageIO.read(fileB);
                                }

                                // Catch block to check for exceptions
                                catch (IOException ecom) {
                                    // Display the exceptions on console
                                    System.out.println(ecom);
                                }

                                // Assigning dimensions to image
                                int width1 = imgA.getWidth();
                                int width2 = imgB.getWidth();
                                int height1 = imgA.getHeight();
                                int height2 = imgB.getHeight();

                                // Checking whether the images are of same size or
                                // not
                                if ((width1 != width2) || (height1 != height2))

                                    // Display message straightaway
                                    System.out.println("Error: Images dimensions"
                                            + " mismatch");
                                else {

                                    // By now, images are of same size

                                    long difference = 0;

                                    // treating images likely 2D matrix

                                    // Outer loop for rows(height)
                                    for (int y = 0; y < height1; y++) {

                                        // Inner loop for columns(width)
                                        for (int x = 0; x < width1; x++) {

                                            int rgbA = imgA.getRGB(x, y);
                                            int rgbB = imgB.getRGB(x, y);
                                            int redA = (rgbA >> 16) & 0xff;
                                            int greenA = (rgbA >> 8) & 0xff;
                                            int blueA = (rgbA)&0xff;
                                            int redB = (rgbB >> 16) & 0xff;
                                            int greenB = (rgbB >> 8) & 0xff;
                                            int blueB = (rgbB)&0xff;

                                            difference += Math.abs(redA - redB);
                                            difference += Math.abs(greenA - greenB);
                                            difference += Math.abs(blueA - blueB);
                                        }
                                    }

                                    // Total number of red pixels = width * height
                                    // Total number of blue pixels = width * height
                                    // Total number of green pixels = width * height
                                    // So total number of pixels = width * height *
                                    // 3
                                    double total_pixels = width1 * height1 * 3;

                                    // Normalizing the value of different pixels
                                    // for accuracy

                                    // Note: Average pixels per color component
                                    double avg_different_pixels
                                            = difference / total_pixels;

                                    // There are 255 values of pixels in total
                                    double percentage
                                            = (avg_different_pixels / 255) * 100;

                                    JFrame fin=new JFrame("Compare Two Images");
                                    JButton but=new JButton("Difference Percentage-->"+percentage);
                                    but.setBounds(290,50,950,60);
                                    fin.add(but);
                                    fin.setLayout(null);
                                    fin.setVisible(true);
                                    // Lastly print the difference percentage
                                    System.out.println("Difference Percentage-->"
                                            + percentage);
                                }

                            }});

                    }});
            }
        });

    }
}