package com.company;

import com.company.engine.AnnotationProcessor;
import com.company.test.PersonRecorder;

import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        while (true) {
            AnnotationProcessor.run(PersonRecorder.class);
        }
    }
}
