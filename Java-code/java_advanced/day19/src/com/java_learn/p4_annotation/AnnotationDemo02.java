package com.java_learn.p4_annotation;

/**
 * @author tjy
 * @version 1.0
 * @date 2025/7/26 13:37
 */
@MyAnnotation(show1 = "A", show2 = {"B", "C", "D"})
@MyAnnotation2("M")
public class AnnotationDemo02 {
    @MyAnnotation(show1 = "B", show2 = "Q")
    public void show() {

    }
}
















