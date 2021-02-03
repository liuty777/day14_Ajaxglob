package com.atguigu.test;

import com.atguigu.bean.Student;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestJsonStringToJaveObj {
    @Test
    public void test01(){
        Student stu = new Student(1001,"zs");
        //将stu转换为jsonString
        Gson gson = new Gson();
        String jsonString = gson.toJson(stu);
        //jsonString    {"id":1001,"stuName":"zs"}
        System.out.println(jsonString);
        //将jsonString->student
        Student student = gson.fromJson(jsonString,Student.class);
        //Student{id=1001,stuName='zs'}
        System.out.println(student);
        System.out.println(student.getId());//1001
        System.out.println(student.getStuName());//zs



    }

    /**
     * List<Student> jsonString
     */
    @Test
    public void test02() {
        List<Student> list = new ArrayList<>();
        list.add(new Student(1001, "zs"));
        list.add(new Student(1002, "cxk"));
        list.add(new Student(1003, "ysq"));
        //将list->jsonString String s="[{"":"","":""},{},{}]";
        Gson gson = new Gson();
        String jsonString = gson.toJson(list);
        System.out.println(jsonString);


        //将jsonString -> list<Student>
        /*ArrayList arrayList = gson.fromJson(jsonString,ArrayList.class);
        System.out.println(arrayList.get(0));
        这是错误的转法  jsonString不能调用getId()等方法;*/
        //这个方法是正确的转法
        List<Student> listRs = gson.fromJson(jsonString, new TypeToken<List<Student>>() {
        }.getType());
        for (Student student : listRs) {
            System.out.println(student.getStuName());
        }
    }
        @Test
        public void test03(){
            Map<String,Student> map = new HashMap<>();
            map.put("zs",new Student(1001,"zs"));
            map.put("cxk",new Student(1002,"cxk"));
            map.put("ysq",new Student(1003,"ysq"));
            //将map->jsonString
            Gson gson = new Gson();
            String s = gson.toJson(map);
            System.out.println(s);
            //jsonString->map
            Map<String,Student> mapRs = gson.fromJson(s,new TypeToken<Map<String,Student>>(){}.getType());
            System.out.println(mapRs);
            System.out.println(mapRs.get("cxk").getStuName());
            System.out.println(mapRs.get("ysq").getId());



        }








}



