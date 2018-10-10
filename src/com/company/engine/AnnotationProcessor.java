package com.company.engine;

import com.company.engine.annotations.ConsoleInput;
import com.company.engine.annotations.MaxCount;
import com.company.engine.annotations.StartMethod;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Scanner;

public class AnnotationProcessor {

    //PersonRecorder
    public static void run(Class<?> clazz) throws IllegalAccessException, InstantiationException, InvocationTargetException {

        Object instance = clazz.newInstance();

        //1. read value from annotation
        //2. set value to the field
//        Field maxCount;
        maxCountProcessor(clazz, instance);

        // 1. Print display message
        // 2. Read console input
        String consoleInput = readConsoleInput(clazz);

        //start method
//        Method startMethod;
        runMethod(clazz, instance, consoleInput);
    }

    private static void maxCountProcessor(Class<?> clazz, Object instance) throws IllegalAccessException {

        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.isAnnotationPresent(MaxCount.class)) {
                MaxCount maxCount = field.getAnnotation(MaxCount.class);

                field.setAccessible(true); // разрешение на чтение и запись приватных полей
                field.set(instance, maxCount.count()); //10
            }
        }
    }

    private static String readConsoleInput(Class<?> clazz) {

        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method method : declaredMethods) {
            Parameter [] parameters = method.getParameters();

            for (Parameter parameter : parameters) {
                if (parameter.isAnnotationPresent(ConsoleInput.class)) {
                    ConsoleInput consoleInput = parameter.getAnnotation(ConsoleInput.class);

                    System.out.println(consoleInput.displayMessage());
                    String input = new Scanner(System.in).nextLine();
                    return input;
                }
            }
        }
        return "";
    }

    private static void runMethod(Class<?> clazz, Object instance, String consoleInput) throws InvocationTargetException, IllegalAccessException {
        Method [] methods = clazz.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(StartMethod.class)) {
                method.invoke(instance, consoleInput);
            }
        }
    }

}
