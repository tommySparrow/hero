package com.house.hero.java.io.file;

import java.io.File;

public class Demo01 {

    public static void main(String[] args) {

        //名称分隔符 /(windows)  /(linux 等)
        System.out.println(File.separator);
        //路径分隔符  ;
        System.out.println(File.pathSeparator);

        //路径表示形式
        String path ="E:\\xp\\test\\2.jpg";
        path="E:"+File.separator+"xp"+File.separator+"test"+File.separator+"2.jpg";
        //推荐方式
        path="E:/xp/test/2.jpg";
    }
}
