package com.company.example;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException, InvocationTargetException {

        /**
         * 1. Reflection
         * 2. Annotations
         */

        String filename = "C:\\your-project\\database-passwords.txt";

        String databaseUsername = "username";
        String databasePassword = "WiowadSDfa@414125$#%!iwiudhuh78278d7gqyu783byd378db2bu7832bbcew";

        //1. Open input stream, read all bytes, close stream, split properties file ....
        //2. Use some technology to do that instead of us

        //com.technology.MainClass.run(args);

        DatabaseConnection databaseConnection = new DatabaseConnection();
//        databaseConnection.username = databaseUsername;
//        databaseConnection.databasePassword = databasePassword;

        databaseConnection.connect();
        System.out.println();
        System.out.println();
        System.out.println();

        //-----------------------------------------------
        Class<DatabaseConnection> dbConnectionClass = DatabaseConnection.class;
//        Field;
//        Method;
//        Annotation;
//        Parameter;

        //getMethods() -> get all PUBLIC methods, including PARENT classes
        //getDeclaredMethods() -> get all methods, IN CLASS WE NEED
        System.out.println("--------METHODS--------");

        Method[] methods = dbConnectionClass.getDeclaredMethods();
        for (Method m : methods) {
            if (m.isAnnotationPresent(Run.class)) {
                System.out.println("@RUN " + m);
            } else {

                System.out.println(m);
            }
        }

        System.out.println();
        System.out.println("--------FIELDS--------");
        System.out.println();
        Field[] fields = dbConnectionClass.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field);
        }



        new DatabaseConnection();
        System.out.println();

//        Class<?> aClass = Class.forName("com.company.example.DatabaseConnection");
        Object instance = dbConnectionClass.newInstance();



        Class<?> prototype = Class.forName("com.company.example.DatabaseConnection");
        Method[] dbConnectionMethods = prototype.getDeclaredMethods();
        for (Method method : dbConnectionMethods) {
            if (method.isAnnotationPresent(Run.class)) {
                method.invoke(instance);
                System.out.println();
            }
        }


        /**
         * Retention Policy:
         * 1. Source - аннотация доступна только в исходном кода
         * Пример: декоративные аннотации
         * @Override
         *
         * 2. Class - аннотация присутствует в скомпилированном Byte Code, но
         * не доступна для поиска через Рефлексию
         *
         * 3. Runtime - аннотация присутствует в скомпилированном Byte Code
         * И
         * доступна через Рефлексию
         */

    }

}
