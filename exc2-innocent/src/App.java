public class App {

    public static void main(String[] args) {

        //Creem l'array d'estudiants:
        Student students[] = init();

        //Imprimeix tots els estudiants
        //de forma desordenada
        printStudents(students, "Llista desordenada:");


        //Ordenem els estudiant per nom
        sortByName(students);
        //Imprimim
        printStudents(students, "Llista ordenada per nom:");


        //Ordenem els estudiant per edat
        sortByAge(students);
        //Imprimim
        printStudents(students, "Llista ordenada per edat:");


        //Ordenem els estudiant per número
        //d'assignatures matriculades
        sortByAmountOfEnrolledSubjects(students);
        //Imprimim
        printStudents(students, "Llista ordenada per assignatures:");
    }

    static void sortByName(Student[] students){
        Arrays.quickSortByName(students, 0, students.length - 1);
    }

    static void sortByAge(Student[] students){
        Arrays.quickSortByAge(students, 0, students.length - 1);
    }

    static void sortByAmountOfEnrolledSubjects(Student[] students){
        Arrays.quickSortByAmountOfEnrolledSubjects(students,
                0, students.length - 1);
    }


    //Mètode que dóna format a la impressió
    //per pantalla d'una llista d'estudiants
    static void printStudents(Student [] students,
                              String message){
        String lineSeparator = "\n****";
        System.out.println(lineSeparator
                + " " + message);
        for(Student s: students)
            System.out.println(s.toString());
        System.out.println();
    }

    //Mètode que genera un array d'estudiants
    static public Student[] init() {

        Student students[] = new Student[10];

        Student s0 = new Student();
        s0.name = "Laura";
        s0.age = 25;
        s0.amountOfEnrolledSubjects = 6;
        students[0] = s0;

        Student s1 = new Student();
        s1.name = "Joan";
        s1.age = 29;
        s1.amountOfEnrolledSubjects = 7;
        students[1] = s1;

        Student s2 = new Student();
        s2.name = "Carme";
        s2.age = 38;
        s2.amountOfEnrolledSubjects = 4;
        students[2] = s2;

        Student s3 = new Student();
        s3.name = "Oriol";
        s3.age = 21;
        s3.amountOfEnrolledSubjects = 9;
        students[3] = s3;

        Student s4 = new Student();
        s4.name = "Sergi";
        s4.age = 36;
        s4.amountOfEnrolledSubjects = 7;
        students[4] = s4;

        Student s5 = new Student();
        s5.name = "Laia";
        s5.age = 31;
        s5.amountOfEnrolledSubjects = 5;
        students[5] = s5;

        Student s6 = new Student();
        s6.name = "Abril";
        s6.age = 41;
        s6.amountOfEnrolledSubjects = 4;
        students[6] = s6;

        Student s7 = new Student();
        s7.name = "Jordi";
        s7.age = 30;
        s7.amountOfEnrolledSubjects = 7;
        students[7] = s7;

        Student s8 = new Student();
        s8.name = "Carla";
        s8.age = 32;
        s8.amountOfEnrolledSubjects = 6;
        students[8] = s8;

        Student s9 = new Student();
        s9.name = "Ritxi";
        s9.age = 28;
        s9.amountOfEnrolledSubjects = 3;
        students[9] = s9;

        return students;
    }
}
