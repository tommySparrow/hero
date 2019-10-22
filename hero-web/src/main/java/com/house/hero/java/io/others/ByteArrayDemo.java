package com.house.hero.java.io.others;

import java.io.*;

/**
 * * 字节数组 节点流
 * * 数组的长度有限 ，数据量不会很大
 *
 * @author User
 */
public class ByteArrayDemo {
    public static void main(String[] args) throws IOException {
        read(write());
    }

    public static byte[] write() throws IOException {
        //目的地
        byte[] dest;
        //选择流   不同点(不能使用多态)
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        //操作 写出
        String msg = "操作与 文件输入流操作一致";
        byte[] info = msg.getBytes();
        bos.write(info, 0, info.length);
        //获取数据
        dest = bos.toByteArray();
        //释放资源
        bos.close();
        return dest;
    }

    /**
     * 输入流  操作与 文件输入流操作一致
     * 读取字节数组
     *
     * @throws IOException
     */
    public static void read(byte[] src) throws IOException {

        //选择流
        InputStream is = new BufferedInputStream(new ByteArrayInputStream(src));
        //操作
        byte[] flush = new byte[1024];
        int len = 0;
        while (-1 != (len = is.read(flush))) {
            System.out.println(new String(flush, 0, len));
        }
        //释放资源
        is.close();
    }
}
