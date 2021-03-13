package SAT;

import java.util.*;

/**
 * Class describing a Student.
 */
public class Student {
    String name;
    /**
     * A list of preferences for schools for a given student.
     * The head of the list is the school with the top priority, while the last element of the least is the school with the least priority.
     * Schools must be added in order of their importance.
     */
    List<String> preferences;

    public Student(String name) {
        if (name == null) {
            System.out.println("Cannot instantiate a student without a name!");
            return;
        }
        this.name = name;
        this.preferences = new LinkedList<>();
    }

    public String getName() {
        return this.name;
    }

    public void addSchoolPreference(String school) {
        this.preferences.add(school);
    }

    public int getPreferenceForSchool(String school) {
        return this.preferences.indexOf(school);
    }

    public List<String> getPreferences() {
        return this.preferences;
    }
}
