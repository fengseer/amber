package org.amber;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;

/**
 * .
 *
 * @author: haifeng
 * @date: 2019-04-17 15:26
 */

public class UserTest {

    public static void main(String[] args) {
        U h1 = new U("h2", 12);
        U h2 = new U("h1", 11);
        ArrayList<Object> objects = new ArrayList<>();
        objects.add(h1);
        objects.add(h2);
        System.out.println(JSON.toJSONString(objects));
    }

    private static class U {
        private String name;
        private int age;

        public U(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public U() {
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
