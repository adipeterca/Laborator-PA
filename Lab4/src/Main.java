import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import SAT.*;

public class Main {
    public static void main(String[] args) {
        // main2();

        Student s0 = new Student("S0");
        Student s1 = new Student("S1");
        Student s2 = new Student("S2");
        Student s3 = new Student("S3");

        School h0 = new School("H0", 1);
        School h1 = new School("H1", 2);
        School h2 = new School("H2", 2);

        s0.addSchoolPreference(h0.getName());
        s0.addSchoolPreference(h1.getName());
        s0.addSchoolPreference(h2.getName());

        s1.addSchoolPreference(h0.getName());
        s1.addSchoolPreference(h1.getName());
        s1.addSchoolPreference(h2.getName());

        s2.addSchoolPreference(h0.getName());
        s2.addSchoolPreference(h1.getName());

        s3.addSchoolPreference(h1.getName());
        s3.addSchoolPreference(h2.getName());

        h0.addStudentPreference(s3.getName());
        h0.addStudentPreference(s0.getName());
        h0.addStudentPreference(s1.getName());
        h0.addStudentPreference(s2.getName());

        h1.addStudentPreference(s0.getName());
        h1.addStudentPreference(s2.getName());
        h1.addStudentPreference(s1.getName());

        h2.addStudentPreference(s0.getName());
        h2.addStudentPreference(s1.getName());
        h2.addStudentPreference(s3.getName());


        Stream<Student> studentStream = Stream.of(s0, s1, s2, s3);
        Stream<School> schoolStream = Stream.of(h0, h1, h2);

        List<Student> studentList = new LinkedList<>();
        studentList.add(s2);
        studentList.add(s3);
        studentList.add(s0);
        studentList.add(s1);

        studentList.sort(new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s1.getName().compareTo(s2.getName());
            }
        });

        Set<School> schoolSet = new TreeSet<>();
        schoolSet.add(h0);
        schoolSet.add(h1);
        schoolSet.add(h2);

        Map<Student, List<String>> studentMap = new HashMap<>();

        studentMap.put(s0, s0.getPreferences());
        studentMap.put(s1, s1.getPreferences());
        studentMap.put(s2, s2.getPreferences());
        studentMap.put(s3, s3.getPreferences());

        Map<School, List<String>> schoolMap = new TreeMap<>();

        schoolMap.put(h0, h0.getPreferences());
        schoolMap.put(h1, h1.getPreferences());
        schoolMap.put(h2, h2.getPreferences());

        for (Student s : studentList) {
            System.out.print("Preferences for " + s.getName() + " : ");
            List<String> schoolListForStudent = studentMap.get(s);
            for (String i : schoolListForStudent) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

        System.out.println("--------------------------------");

        for (School s : schoolSet) {
            System.out.print("Preference for " + s.getName() + " : ");
            List<String> studentListForSchool = schoolMap.get(s);
            for (String i : studentListForSchool) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

    }

    static void main2() {
        int sum = Arrays.asList(1, 2, 3, 5, 10).stream().filter(x -> x > 3 && x < 10).mapToInt(Integer::intValue).sum();
        System.out.print(sum);

    }
}
