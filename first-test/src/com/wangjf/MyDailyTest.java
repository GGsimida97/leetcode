package com.wangjf;

import com.wangjf.jz3.TestObject;

import java.lang.reflect.Field;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyDailyTest {
    public static void main(String[] args) throws Exception {
        Class<TestObject> testObjectClass = TestObject.class;
        TestObject testObject = (TestObject) testObjectClass.newInstance();
        Field name = testObjectClass.getDeclaredField("name");
        System.out.println(name);


    }
}
