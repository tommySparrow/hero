package com.house.hero.java.io.chario;

import java.io.*;

/**
 * 纯文本读取
 * @author User
 */
public class ReaderDemo {

    public static void main(String[] args) throws IOException {

        //建立连接
        File file = new File("E:/xp/test/test.txt");
        //选择流
        Reader reader = null;
        try {
            reader = new FileReader(file);
            //读取操作
            char[] flush =new char[1024];
            int len =0;
            while(-1!=(len=reader.read(flush))){
                //字符数组转成 字符串
                String str =new String(flush,0,len);
                System.out.println(str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (null != reader) {
                reader.close();
            }
        }
    }
}
