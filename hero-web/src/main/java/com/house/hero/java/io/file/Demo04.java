package com.house.hero.java.io.file;

import java.io.File;

public class Demo04 {
    public static void main(String[] args) {
        String path ="E:/xp/test/parent/p/test";
        File src =new File(path);
        //上级目录存在,才会创建下级目录
//        src.mkdir();
        //目录不存在就会创建目录
        src.mkdirs();
    }
}
