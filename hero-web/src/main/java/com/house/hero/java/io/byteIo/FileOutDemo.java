package com.house.hero.java.io.byteIo;

import java.io.*;

/**
 * 写出文件
 1、建立联系   File对象  目的地
 2、选择流     文件输出流  OutputStream FileOutputStream
 3、操作  :  write() +flush
 4、释放资源 :关闭
 * @author user
 *
 */
public class FileOutDemo {

    public static void main(String[] args) throws IOException {
        //1、建立联系   File对象  目的地
        File dest = new File("E:/xp/test/test.txt");
        //2、选择流   文件输出流  OutputStream FileOutputStream
        OutputStream os =null;

        try {
            //以追加形式 写出文件 必须为true 否则为覆盖
            os = new FileOutputStream(dest,true);
            //3、操作
            String str="this is for outPutStream \r\n";
            //字符串转字节数组
            byte[] data =str.getBytes();
            os.write(data,0,data.length);

            os.flush(); //强制刷新出去
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            if (null != os) {
                os.close();
            }
        }
    }
}
