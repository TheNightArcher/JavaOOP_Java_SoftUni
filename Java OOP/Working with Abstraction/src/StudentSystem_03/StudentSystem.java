package StudentSystem_03;

import java.util.HashMap;
import java.util.Map;

public class StudentSystem {
    private final Map<String, Student> studentsInformation;

    public StudentSystem() {
        this.studentsInformation = new HashMap<>();
    }

    public void ParseCommand(String[] command) {

        if (command[0].equals("Create")) {
            String name = command[1];
            int age = Integer.parseInt(command[2]);
            double grade = Double.parseDouble(command[3]);

            if (!studentsInformation.containsKey(name)) {
                Student student = new Student(name, age, grade);
                studentsInformation.put(name, student);
            }
        } else if (command[0].equals("Show")) {
            String name = command[1];
            if (studentsInformation.containsKey(name)) {

                Student student = studentsInformation.get(name);
                String view = String.format("%s is %s years old.", student.getName(), student.getAge());

                view = getRating(student.getGrade(), view);

                System.out.println(view);
            }
        }
    }

    private String getRating(double grade, String view) {
        if (grade >= 5.00) {
            view += " Excellent student.";
        } else if (grade >= 3.50) {
            view += " Average student.";
        } else {
            view += " Very nice person.";
        }
        return view;
    }
}
