import java.util.Scanner;

public class StudentGradeTracker1 {
    
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        
        // Ask the teacher for the number of students
        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();
        
        // Create an array to store student grades
        int[] grades = new int[numStudents];
        
        // Ask for the grades of each student
        for (int i = 0; i < numStudents; i++) {
            System.out.print("Enter grade for student " + (i + 1) + ": ");
            grades[i] = scanner.nextInt();
        }
        
        // Calculate the average, highest, and lowest scores
        double average = calculateAverage(grades);
        int highest = findHighest(grades);
        int lowest = findLowest(grades);
        
        // Display the results
        System.out.println("\nResults:");
        System.out.println("Average grade: " + average);
        System.out.println("Highest grade: " + highest);
        System.out.println("Lowest grade: " + lowest);
        
        // Close the scanner
        scanner.close();
    }

    // Method to calculate the average grade
    public static double calculateAverage(int[] grades) {
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.length;
    }

    // Method to find the highest grade
    public static int findHighest(int[] grades) {
        int highest = grades[0];
        for (int grade : grades) {
            if (grade > highest) {
                highest = grade;
            }
        }
        return highest;
    }

    // Method to find the lowest grade
    public static int findLowest(int[] grades) {
        int lowest = grades[0];
        for (int grade : grades) {
            if (grade < lowest) {
                lowest = grade;
            }
        }
        return lowest;
    }
}

