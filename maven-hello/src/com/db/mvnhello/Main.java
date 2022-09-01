package com.db.mvnhello;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int noStudents = 3;
        Student students[] = new Student[noStudents];
        int k = 0;
        students[k++] = new Student("Vasile");
        students[k++] = new Student("Ionel");
        students[k++] = new Student("Maria");
        Teacher teacher1 = new Teacher("Gabi");
        Teacher teacher2 = new Teacher("Tibi");
        Pair<Student, Teacher>[] pairs = new ImmutablePair[noStudents];
        for (int i = 0; i< noStudents; i++) {
            pairs[i] = new ImmutablePair<>(students[i], Math.random() < 0.5 ? teacher1 : teacher2);
        }
        System.out.println(Arrays.asList(pairs));

    }
}

class Student {
    private String nume;
    private float grade;

    public Student(String nume) {
        this.nume = nume;
    }

    public String getNume() {
        return nume;
    }

    public float getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "nume='" + nume + '\'' +
                ", grade=" + grade +
                '}';
    }
}

class Teacher {
    private String nume;

    public Teacher(String nume) {
        this.nume = nume;
    }

    public String getNume() {
        return nume;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "nume='" + nume + '\'' +
                '}';
    }
}