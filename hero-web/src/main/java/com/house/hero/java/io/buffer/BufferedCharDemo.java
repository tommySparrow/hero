package com.house.hero.java.io.buffer;

import java.io.*;

/**
 * @author User
 */
public class BufferedCharDemo {

    public static void main(String[] args) {

        //创建源 仅限于 字符的纯文本
        File src = new File("E:/xp/test/Demo03.java");
        File dest = new File("E:/xp/test/char.txt");

        //选择流
        BufferedReader reader = null;
        BufferedWriter wr = null;

        try {

            reader = new BufferedReader(new FileReader(src));
            wr = new BufferedWriter(new FileWriter(dest));

            //读取操作1
			/*
			char[] flush =new char[1024];
			int len =0;
			while(-1!=(len=reader.read(flush))){
				wr.write(flush, 0, len);
			}*/

            //读取操作2
            String line = null;
            while (null != (line = reader.readLine())) {
                wr.write(line);
            }
            wr.flush();//强制刷出
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("源文件不存在");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("文件读取失败");
        } finally {
            try {
                if (null != wr) {
                    wr.close();
                }
            } catch (Exception e2) {
            }
            try {
                if (null != reader) {
                    reader.close();
                }
            } catch (Exception e2) {
            }
        }
    }
}
