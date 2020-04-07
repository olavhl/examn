package ExercisePackage;

import java.util.ArrayList;

public class Person {


    public ArrayList<Exercise> exercises = new ArrayList<>();
    public String preferredExercise;
    public int acceptableIntensity;
    public Object acceptableProgram;

    public Person(String preferredExercise, int acceptableIntensity) {
        this.acceptableIntensity = acceptableIntensity;
        this.preferredExercise = preferredExercise;
    }

}
