package com.company;

public class Main {

    public static void main(String[] args) throws Exception {

        Semester first = new Semester(1, new int[]{1, 5}); //создаем экземпляр класса Semester (1 семестр)

        first.addMarks(new int[]{4, 3, 4, 4, 5, 5});               //добавили оценки к существующим
        System.out.println(first.getCount());                      //кол-во оценок

        System.out.println("---------------------------------------------------------");

        System.out.println(first.averageMark());                   //вывод среднего балла за 1 семестр

        System.out.println("---------------------------------------------------------");

        Student student = new Student("Вакулин Дмитрий", 3);                // создаем объект student (экз. класса Student).
        student.setMarksForSemesterToStudent(new Semester(2, new int[]{5, 5, 5, 5, 4}));  // записываем оценки за 2 семестр непосредственно в объект student
        Semester third = new Semester(3, new int[]{5, 5, 3, 3, 2, 4});                    // оценки за 3 семестр записали пока в объект thrid (3 семестр)

        student.setMarksForSemesterToStudent(first);                                              //передаем оценки за 1 сем. в объект student
        student.setMarksForSemesterToStudent(third);                                              //передаем оценки за 3 сем. в объект student

        System.out.println(student.getAverageMarkForSemester(1));                                 //вычисляем средний балл за 1 семестр отдельно
        System.out.println(student.getAverageMarkForSemester(2));                                 //вычисляем средний балл за 2 семестр отдельно
        System.out.println(student.getAverageMarkForSemester(3));                                 //вычисляем средний балл за 3 семестр отдельно

        System.out.println("---------------------------------------------------------");

        System.out.println(student.getAverageMarkForAllSemesters());                              //выводим средний балл за все время обучения (т.е до текущего семестра currSem)

        System.out.println("---------------------------------------------------------");

        
    }
}
