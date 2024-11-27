import java.io.*;
import java.util.*;

public class MathQuiz {

    public static void main(String[] args) {
        String inputFilePath ="C:\\User\\LENOVO\\OneDrive\\Desktop\\my java file\\expressions.txt"; 
        String outputFilePath = "score.txt";
        
        // Initialize score
        int correctAnswers = 0;
        int totalQuestions = 0;

        try {
            // Step 1: Reading expressions from input file
            File inputFile = new File(inputFilePath);
            Scanner fileScanner = new Scanner(inputFile);

            // Step 2: Process each line in the file (each math expression)
            while (fileScanner.hasNextLine()) {
                String expression = fileScanner.nextLine().trim();
                
                // Ensure the expression is valid (simple validation: must contain a comma)
                if (expression.contains(",")) {
                    String[] parts = expression.split(",");
                    String question = parts[0].trim();
                    String correctAnswer = parts[1].trim();
                    
                    // Step 3: Ask the user for input (compare it with the correct answer)
                    totalQuestions++;
                    System.out.println("Question: " + question);
                    System.out.print("Your answer: ");
                    Scanner inputScanner = new Scanner(System.in);
                    String userAnswer = inputScanner.nextLine().trim();

                    // Step 4: Check if the user's answer is correct
                    if (userAnswer.equals(correctAnswer)) {
                        System.out.println("Correct!");
                        correctAnswers++;
                    } else {
                        System.out.println("Incorrect. The correct answer is " + correctAnswer);
                    }
                }
            }
            fileScanner.close();
            
            // Step 5: Display score to the user
            System.out.println("\nYour score: " + correctAnswers + "/" + totalQuestions);

            // Step 6: Write the score to an output file
            File outputFile = new File(outputFilePath);
            FileWriter writer = new FileWriter(outputFile, true); // 'true' for append mode
            writer.write("Score: " + correctAnswers + "/" + totalQuestions + "\n");
            writer.close();
            System.out.println("Score has been recorded in the output file.");
            
        } catch (FileNotFoundException e) {
            System.out.println("Error: Input file not found.");
        } catch (IOException e) {
            System.out.println("Error: Writing to the output file failed.");
        }
    }
}
