

import java.nio.file.Paths;
import java.util.Scanner;

public class RecipeSearch {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Write file name");
        
        String fileName = scanner.nextLine();
        
        try (Scanner fileReader = new Scanner(Paths.get(fileName))){
           UserInterface userInterface = new UserInterface(fileReader, scanner);
           userInterface.start();
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
