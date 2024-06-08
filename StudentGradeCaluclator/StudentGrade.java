package com.StudentGradeCaluclator;

import java.util.Scanner;

public class StudentGrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter marks obtained in each subject (out of 100):");
        System.out.print("Subject 1: ");
        int subject1Marks = scanner.nextInt();
        System.out.print("Subject 2: ");
        int subject2Marks = scanner.nextInt();
        System.out.print("Subject 3: ");
        int subject3Marks = scanner.nextInt();

        // Calculate Total Marks
        int totalMarks = subject1Marks + subject2Marks + subject3Marks;

        // Calculate Average Percentage
        int totalSubjects = 3;
        double averagePercentage = (double) totalMarks / totalSubjects;

        char grade;
        if (averagePercentage >= 90) {
            grade = 'A';
        } else if (averagePercentage >= 80) {
            grade = 'B';
        } else if (averagePercentage >= 70) {
            grade = 'C';
        } else if (averagePercentage >= 60) {
            grade = 'D';
        } else if (averagePercentage >= 50) {
            grade = 'E';
        } else {
            grade = 'F';
        }

        System.out.println("\nResults:");
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);

        scanner.close();
    }
}
