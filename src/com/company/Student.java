package com.company;

import java.util.Arrays;

public class Student {

    public static final int DEFAULT_MARK_SIZE = 30;

    private String studentName; // имя студента
    private int[][] allMarks; // массив вида [семестр][оценки]
    private int currSem; // текущий семестр студента

    /**
     * Конструктор студента
     */
    public Student(String studentName, int currSemester) {
        this.studentName = studentName;
        this.currSem = currSemester;
        allMarks = new int[currSemester][DEFAULT_MARK_SIZE];
    }

    /**
     * Добавление оценок за семестр(из объекта Semester) в массив allMarks(объекта Student)
     */
    public void setMarksForSemesterToStudent(Semester sem) {
        if (allMarks[0].length <= sem.getCount()) {
            for (int k = 0; k < currSem; k++) {
                allMarks[k] = Arrays.copyOf(allMarks[k], allMarks[k].length * 2 + sem.getCount());
            }
        }
        for (int i = 0; i < sem.getCount(); i++) {
            allMarks[sem.getSemester()-1][i] = sem.getMark()[i];
        }
    }

    /**
     * Вычисление средней оценки за семестр
     */
    public double getAverageMarkForSemester(int sem) {
        double sum = 0;
        int count = 0;
        for (int i = 0; i < allMarks[sem-1].length; i++) {
            if (allMarks[sem-1][i] != 0) {
                sum += allMarks[sem-1][i];
                count++;
            }
        }
        return sum/count;
    }

    /**
     * Вычисление средней оценки за все время обучения
     */
    public double getAverageMarkForAllSemesters() {
        double sum = 0;
        for (int i = 1; i <= currSem; i++) {
            sum += getAverageMarkForSemester(i);
        }
        return sum/currSem;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    public String getStudentName() {
        return studentName;
    }

    public void setCurrSem(int currSem) {
        this.currSem = currSem;
    }
    public int getCurrSem() {
        return currSem;
    }

    public void setAllMarks(int[][] marks) {
        for (int i = 0; i < currSem; i++) {
            allMarks[i] = Arrays.copyOf(marks[i], 2 * marks[i].length);
        }
    }
    public int[][] getAllMarks() {
        return allMarks;
    }

}
