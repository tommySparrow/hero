package com.house.hero.java.io.file;

import java.io.File;
import java.io.IOException;

public class Demo03 {

    public static void main(String[] args) {

        test2();
        try {
            test3();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //创建 删除文件
    private static void test3() throws IOException {
        String path="E:/xp/test/200.jpg";
        File file = new File(path);

        if (!file.exists()) {
            boolean flag =  file.createNewFile();
            System.out.println(flag?"创建成功":"创建失败");
        }
        boolean flag =  file.delete();
        System.out.println(flag?"成功":"失败");
    }

    /**
     * 判断信息
     * 长度 length()
     */
    private static void test2() {

        File file = new File("E:/xp/test/2.txt");

        //是否存在
        System.out.println(file.exists());
        //是否可读 写 canWrite() canRead()
        System.out.println(file.canRead());

        System.out.println("============");
        //isFile()
        //isDirectory()
        if (file.isFile()) {
            System.out.println("是文件");
        } else if (file.isDirectory()){
            System.out.println("是文件夹");
        } else {
            System.out.println("文件不存在");
        }

        System.out.println("文件长度:"+ file.length());
    }
}
