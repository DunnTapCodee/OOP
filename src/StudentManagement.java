public class StudentManagement {
    Student[] students = new Student[100];
    int numOfStudents = 0;

    public void addStudent(Student newStudent){
        students[numOfStudents] = newStudent;
        numOfStudents++;
    }

    public String studentByGroup(){
        StringBuilder result = new StringBuilder(100);
        boolean[] printedGroups = new boolean[numOfStudents];

        for (int i = 0; i < numOfStudents; i++)
        {
            if ( !printedGroups[i] ){
                for (int j = i; j < numOfStudents; j++){
                    if (students[j].getGroup().equals(students[i].getGroup()))
                    {
                        result.append(students[j].getInfo());
                        printedGroups[i] = true;
                    }
                }
            }
        }
        return result.toString();
    }

    public static boolean sameGroup(Student s1, Student s2){
        return s1.getGroup().equals(s2.getGroup());
    }

    public static void main(String[] args){

    }

}
