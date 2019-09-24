package com.house.hero.java.builder;

/**
 * 建造者模式
 * @author User
 */
public class Person {

    // 必须的参数
    private int id;
    private String name;
    private int age;

    // 可选参数
    private String city;
    private String hoby;
    private String job;
    private String sex;

    // 私有构造函数
    private Person(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.age = builder.age;
        this.city = builder.city;
        this.hoby = builder.hoby;
        this.job = builder.job;
        this.sex = builder.sex;
    }

    public static class Builder {
        // 必须的参数
        private int id;
        private String name;
        private int age;

        // 可选参数
        private String city;
        private String hoby;
        private String job;
        private String sex;

        // 设置必须的参数
        public Builder(int id, String name, int age) {
            this.id = id;
            this.name = name;
            this.age = age;
        }

        // 设置可选参数, 返回Builder对象可以让调用者使用级联
        public Builder setCity(String city) {
            this.city = city;
            return this;
        }

        public Builder setHoby(String hoby) {
            this.hoby = hoby;
            return this;
        }

        public Builder setJob (String job) {
            this.job = job;
            return this;
        }

        public Builder setSex(String sex) {
            this.sex = sex;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }

    public static void main(String[] args) {
        Person.Builder builder = new Person.Builder(1, "xing", 25);
        Person person = builder.setCity("beijing").setSex("1").build();
        System.out.println(person);
    }
}
