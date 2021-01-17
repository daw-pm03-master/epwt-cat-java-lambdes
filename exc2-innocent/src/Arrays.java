public class Arrays {

    /**
     * quickSortByName ordena els alumnes
     * alfabèticament pel seu nom,
     * de forma ascendent
     */
    public static void quickSortByName(Student[] arr, int start, int end) {

        int partition = partitionByName(arr, start, end);

        if (partition - 1 > start) {
            quickSortByName(arr, start, partition - 1);
        }
        if (partition + 1 < end) {
            quickSortByName(arr, partition + 1, end);
        }
    }

    /*
    * Mètode auxiliar de quickSortByName
    * La comparació entre String que determina
    * l'ordre es troba a l'if
    * Els String es comparen amb el mètode
    * compareTo()
    * string1.compareTo(string2)
    * dóna negatiu si string1 és més petit que string2
    * dóna 0 si els dos strings són iguals
    * dóna positiu si string1 és més gran que string2
     */
    public static int partitionByName(Student[] arr, int start, int end) {
        Student pivot = arr[end];

        for (int i = start; i < end; i++) {
            //Dins de l'if està la condició de comparació:
            if (arr[i].name.compareTo(pivot.name) < 0) {
                Student temp = arr[start];
                arr[start] = arr[i];
                arr[i] = temp;
                start++;
            }
        }

        Student temp = arr[start];
        arr[start] = pivot;
        arr[end] = temp;

        return start;
    }

    /**
     * quickSortByAge ordena els alumnes
     * de forma ascendent segons l'edat
     */
    public static void quickSortByAge(Student[] arr, int start, int end) {

        int partition = partitionByAge(arr, start, end);

        if (partition - 1 > start) {
            quickSortByAge(arr, start, partition - 1);
        }
        if (partition + 1 < end) {
            quickSortByAge(arr, partition + 1, end);
        }
    }

    /*
     * Mètode auxiliar de quickSortByAge
     * La comparació entre enters que determina
     * l'ordre es troba a l'if
     */
    public static int partitionByAge(Student[] arr, int start, int end) {
        Student pivot = arr[end];

        for (int i = start; i < end; i++) {
            //Dins de l'if està la condició de comparació:
            if (arr[i].age < pivot.age) {
                Student temp = arr[start];
                arr[start] = arr[i];
                arr[i] = temp;
                start++;
            }
        }

        Student temp = arr[start];
        arr[start] = pivot;
        arr[end] = temp;

        return start;
    }

    /**
     * quickSortByAmountOfEnrolledSubjects
     * ordena els alumnes de forma ascendent
     * segons el número d'assignatures
     * matriculades
     */
    public static void quickSortByAmountOfEnrolledSubjects(Student[] arr, int start, int end) {

        int partition = partitionByAmountOfEnrolledSubjects(arr, start, end);

        if (partition - 1 > start) {
            quickSortByAmountOfEnrolledSubjects(arr, start, partition - 1);
        }
        if (partition + 1 < end) {
            quickSortByAmountOfEnrolledSubjects(arr, partition + 1, end);
        }
    }

    /*
     * Mètode auxiliar de
     * quickSortByAmountOfEnrolledSubjects
     * La comparació entre enters que determina
     * l'ordre es troba a l'if
     */
    public static int partitionByAmountOfEnrolledSubjects(Student[] arr, int start, int end) {
        Student pivot = arr[end];

        for (int i = start; i < end; i++) {
            //Dins de l'if està la condició de comparació:
            if (arr[i].amountOfEnrolledSubjects <
                    pivot.amountOfEnrolledSubjects) {
                Student temp = arr[start];
                arr[start] = arr[i];
                arr[i] = temp;
                start++;
            }
        }

        Student temp = arr[start];
        arr[start] = pivot;
        arr[end] = temp;

        return start;
    }
}
