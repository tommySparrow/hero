package com.house.hero.java.io.byteIo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 文件的读取
 * 1、建立联系   File对象
 2、选择流     文件输入流  InputStream FileInputStream
 3、操作  : byte[] car =new byte[1024];  +read+读取大小输出
 4、释放资源 :关闭
 * @author user
 *
 */
public class FileReadDemo {

    public static void main(String[] args) throws IOException {

        //1建立联系
        File file = new File("E:/xp/test/2.txt");

        //2选择流
        FileInputStream inputStream = null;
        try {
            //选择流读取
             inputStream = new FileInputStream(file);
            //3、操作 不断读取 缓冲数组
            byte[] car =new byte[1024];
            int len =0;
            //循环读取
            StringBuilder sb =new StringBuilder();
            while(-1!=(len=inputStream.read(car))){
                //输出  字节数组转成字符串
                String info =new String(car,0,len);
                sb.append(info);
            }
            System.out.println(sb.toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            //4、释放资源
            if (null != inputStream) {
                inputStream.close();
            }
        }
    }
}
