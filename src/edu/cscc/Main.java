package edu.cscc;

import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.Double.*;

/**
 * Lab 8: Calculate BMI and BMI classification from user input of weight in pounds and height in inches. Second coding....
 * Date 2019-10-15
 * Added input checks to verify positive number and try catch to remove non-integer text
 * @author Brian Pawletzki
 */

public class Main {

    private static Scanner input = new Scanner(System.in);
    private static final String INPUT_ERROR = "Input is not valid, try again";

    public static void main(String[] args) {
        double lbs = 0, inches = 0, meters, kgs, bmi;
        String classification;

        // Output title
        System.out.println("Calculate BMI");

        // Read inputs
        // Get valid input for lbs
        lbs = inputWeight();

        // Get valid input for inches
        inches = inputHeight();

        // Do calculations
        kgs = convertToKilograms(lbs);
        meters = convertToMeters(inches);
        bmi = calcBMI(kgs, meters);
        classification = bmiClassification(bmi);

        // Output results
        System.out.println("Your BMI is " + bmi);
        System.out.println("Your BMI classification is " + classification);
    }

    /**
     * Convert pounds to kilograms
     *
     * @param myLbs Description Takes a double with a value of pounds;
     * @return Description Returns the calculation of pounds / 2.2046, as a type of double
     */
    private static double convertToKilograms(double myLbs) {
        return myLbs / 2.2046;
    }

    /**
     * Convert inches to meters
     *
     * @param myInches Description Takes a double with a value of inches;
     * @return Description Returns the calculation of inches / 39.37, as a type of double;
     */
    private static double convertToMeters(double myInches) {
        return myInches / 39.37;
    }


    /**
     * Take weight in kilograms and height in meters and return the BMI
     *
     * @param myMeters Description Takes a double with a value of meters ;
     * @return Description Returns the calculation of kilograms / meters^2,  as a type of double;
     */
    private static double calcBMI(double myKgs, double myMeters) {
        return myKgs / Math.pow(myMeters, 2);
    }

    /**
     * Take the value for the BMI and return a String with the BMI classification
     *
     * @param bmi Description Takes a value of inches;
     * @return Description Returns the BMI classification, as a type of string;
     */
    private static String bmiClassification(double bmi) {
        String myClassification = "error";
        if (bmi >= 30) {
            myClassification = "Obese";
        } else if (bmi >= 25) {
            myClassification = "Overweight";
        } else if (bmi >= 18.5) {
            myClassification = "Normal";
        } else {
            myClassification = "Underweight";
        }

        return myClassification;
    }

    /**
     * Get user input for Weight
     * @return double weight
     */
    private static Double inputWeight() {
        // Get valid input for lbs
        return inputValues("Enter weight (lbs): ");
    }

    /**
     * Get user input for Height
     * @return double height
     */
    private static Double inputHeight() {
        // Get valid input for inches
        return inputValues("Enter height (inches):");
    }

    /**
     *  Generic method to prompt for numbers
     * @param prompt The prompt that means something to a human
     * @return double value
     */
    private static Double inputValues(String prompt) {
        // Generic method to query human
        boolean firstIteration = true;
        double value = 0;
        do {
            // If this is the first iteration do not show the error message.
            if (!firstIteration) {
                System.out.println(INPUT_ERROR);
            }
            System.out.print(prompt);
            // We are no longer first iteration.
            firstIteration = false;
            try {
                value = Double.parseDouble(input.nextLine());
            } catch (NumberFormatException e) {
                // If error occurs, change to 0
                value = 0;
            }
        } while (value <= 0);

        return value;
    }
}
