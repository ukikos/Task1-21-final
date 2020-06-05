package com.company;

import java.util.Arrays;

public class Semester {

    public static final int DEFAULT_START_SIZE = 20;

    /**
     * Порядковый номер семестра
     */
    private int semester;

    /**
     * Массив оценок за семестр
     */
    private int[] mark;

    /**
     * Кол-во оценок
     */
    private int count;

    /**
     * Конструктор без записи оценок
     */
    public Semester(int semester) {
        this.semester = semester;
        mark = new int[DEFAULT_START_SIZE];
        count = 0;
    }

    /**
     * Конструктор с записью оценок
     */
    public Semester(int semester, int[] marks) {
        this.semester = semester;
        mark = Arrays.copyOf(marks, 2 * marks.length);
        count = marks.length;
    }

    /**
     * Конструктор без параметров
     */
    public Semester() {
        semester = 0;
        mark = new int[DEFAULT_START_SIZE];
        count = 0;
    }

    /**
     * Вывод оценок за семестр
     */
    public void printMarks() {
        System.out.print("Семестр - " + semester + ":\nОценки: ");
        for (int i = 0; i < count; i++) {
            System.out.print(mark[i]);
            if (i != count - 1) {
                System.out.print(", ");
            } else {
                System.out.print(".\n");
            }
        }
    }

    /**
     * Добавить оуенки в массив mark
     */
    public void addMarks(int[] marks) throws Exception {
        if (marks.length == 0) {
            throw new Exception("Вы не ввели оценки");
        } else {
            if (count >= mark.length || mark.length <= count + marks.length) {
                mark = Arrays.copyOf(mark, count * 2 + marks.length);
            }
            for (int i = 0; i < marks.length; i++) {
               mark[count] = marks[i];
               count++;
            }
        }
    }

    /**
     * Рассчет среднего балла за семестр
     */
    public double averageMark() {
        double sumMark = 0;
        for (int i = 0; i < count; i++) {
            sumMark += mark[i];
        }
        return sumMark/count;
    }

    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }

    public int getSemester() {
        return semester;
    }
    public void setSemester(String subject) {
        this.semester = semester;
    }

    public int[] getMark() {
        return mark;
    }
    public void setMark(int[] marks) {
        mark = Arrays.copyOf(marks, 2 * marks.length);
        count = marks.length;
    }

}
