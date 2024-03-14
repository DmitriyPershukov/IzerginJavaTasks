package demomatrixmanipulations;

import matrixmanipulations.MatrixManipulations;
        
public class DemoMatrixManipulations {

    public static void main(String[] args) {
        MatrixManipulations m = new MatrixManipulations(5);
        System.out.println(m);
        m.task1();
        System.out.println(m);
        m.task2();
        System.out.println(m);
        m.task3();
        System.out.println(m);
        m.task4(3, 2);
        System.out.println(m);
        System.out.println(m.task5());
        m.task6();
        System.out.println(m);
        System.out.println(m.task7());
        System.out.println(m.task8());
        m.task9();
        System.out.println(m);
    }   
}
