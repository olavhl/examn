package ExercisePackage;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ExerciseTest {

    Exercise testExercise;

    @Before
    public void setup() {
        testExercise = new Balance("Headstand","Mat", 7, 2, 8,4);
    }

    // Checking if intensity is between 0 and 10
    @Test
    public void intensityTest(){

        int high = 10;
        int low = 0;

        assertTrue("Error, intensity is too high", high >= testExercise.intensity);
        assertTrue("Error, intensity is too low",  low  <= testExercise.intensity);
    }

    // Checking if name is empty
    @Test
    public void stringNotEmpty() {
        stringIsEmpty(testExercise.name);
        stringIsEmpty(testExercise.equipment);
    }

    @Test
    public void intNotEmpty() {
        intIsEmpty(testExercise.intensity);
        intIsEmpty(testExercise.duration);
        intIsEmpty(testExercise.repetitions);
        intIsEmpty(testExercise.sets);
    }

    // Method to check if a string is empty
    public void stringIsEmpty(String a) {

        boolean nameNotEmpty = true;

        if (a.equals("")) {
            nameNotEmpty = false;
        }
        assertTrue("Check if string is empty",nameNotEmpty);
    }

    // Method to check if an int is empty
    public void intIsEmpty(int a) {

        boolean intNotEmpty = true;

        if (a == 0) {
            intNotEmpty = false;
        }
        assertTrue("Check if int is empty",intNotEmpty);
    }

    @Test
    public void negativeNumbers() {
        int lowNumber = 0;

        assertFalse("Negative numbers is not allowed",  lowNumber  > testExercise.intensity ||
                lowNumber > testExercise.sets || lowNumber > testExercise.repetitions || lowNumber > testExercise.duration);
    }

    @Test
    public void alphabeticStrings() {
        boolean isNAN;

        // Creates a regex to include what is allowed in the strings
        String regex = "^[A-Za-z\\s-]+$";

        isNAN = testExercise.name.matches(regex);
        assertTrue("Checking if name and equipment only contains letters and space", isNAN);

        isNAN = testExercise.equipment.matches(regex);
        assertTrue("Checking if name and equipment only contains letters and space", isNAN);
    }

    @Test
    public void testPrint() {
        // Expecting print to come from balance since type.equals(balance)
        String output = "Exercise: Headstand\nIntensity: 7" +
                "\nDuration: 2\nRepetitions: 8 x 4\nEquipment: Mat";

        assertEquals("Expecting print to come from balance.java", output, testExercise.print());
    }

    @Test
    public void getTypeTest() {
        // Expecting getType to be balance
        assertEquals("getType comes from balance.java", "Balance", testExercise.getType());
    }

}