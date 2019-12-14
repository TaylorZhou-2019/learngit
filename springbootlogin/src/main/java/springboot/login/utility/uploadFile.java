package springboot.login.utility;
import java.awt.image.BufferedImage;
import java.io.*;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;

public class uploadFile {
    public static String uploadFile(String fileData){
//        //在自己的项目中构造出一个用于存放用户照片的文件夹
//        String imgPath = this.getServletContext().getRealPath("/uploads/");
//        //如果此文件夹不存在则创建一个
//        File f = new File(imgPath);
//        if(!f.exists()){
//            f.mkdir();
//        }
//        //拼接文件名称，不存在就创建
////        imgPath = imgPath + "/" + fileName + ".jpg";
        String imgPath = "/Users/a_piao/Desktop/springbootlogin/src/main/resources/static/data/picture3.jpg";
        File f = new File(imgPath);
        if(!f.exists()){
            f.mkdir();
        }

        //使用BASE64对图片文件数据进行解码操作
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            //通过Base64解密，将图片数据解密成字节数组
            byte[] bytes = decoder.decodeBuffer(fileData);
            //构造字节数组输入流
            ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
            //读取输入流的数据
            BufferedImage bi = ImageIO.read(bais);
            //将数据信息写进图片文件中
            ImageIO.write(bi, "jpg", f);// 不管输出什么格式图片，此处不需改动
            bais.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        return imgPath;
    }
}
