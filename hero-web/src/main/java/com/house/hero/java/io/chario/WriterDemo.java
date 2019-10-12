package com.house.hero.java.io.chario;

import java.io.*;

/**
 * 写出
 *
 * @author User
 */
public class WriterDemo {

    public static void main(String[] args) {
        //创建连接
        File dest = new File("e:/xp/test/char.txt");
        //选择流
        Writer wr = null;
        try {
            //追加文件，而不是覆盖文件
            wr = new FileWriter(dest);
            //写出
            String msg = "追加.....锄禾日当午\r\n码农真辛苦\r\n";
            wr.write(msg);

            wr.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != wr) {
                    wr.close();
                }
            } catch (Exception e2) {
            }
        }
    }
}
