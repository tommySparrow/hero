package com.house.hero.java.io.file;

import java.io.File;

/**
 *  相对路径与绝对路径构造 File对象
 * 1、相对路径
 File(String parent, String child)  ==>File("E:/xp/test","2.jpg")
 File(File parent, String child)     ==> File(new File("E:/xp/test"),"2.jpg")
 2、绝对路径
 File(String name);
 * @author user
 */
public class Demo02 {

    public static void main(String[] args) {
        String parentPath ="E:/xp/test";
        String name ="2.jpg";
        //相对路径
        File file = new File(parentPath, name);
        //输出
        System.out.println(file.getPath());
        System.out.println(file.getName());
        //绝对路径
        file = new File("E:/xp/test/2.jpg");
        //输出
        System.out.println(file.getPath());
        System.out.println(file.getName());
    }
}
