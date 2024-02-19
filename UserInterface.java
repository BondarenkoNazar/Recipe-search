
import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private Scanner fileReader;
    private Scanner scanner;
    private RecipeList recipes;
    
    public UserInterface(Scanner fileReader, Scanner scanner){
        this.fileReader = fileReader;
        this.scanner = scanner;
        this.recipes = new RecipeList();
    }
    
    public void start(){
        
        this.input();
        this.doCommands();
    
    }
    
    public void input(){
            
        while (fileReader.hasNextLine()){
            
            String name = fileReader.nextLine();
            int cookingTime = Integer.valueOf(fileReader.nextLine());
            ArrayList<String> ingredients = new ArrayList<>();
            
            String line = fileReader.nextLine().trim();
            
            while(!(line.isEmpty())){
                ingredients.add(line);
                
                if (fileReader.hasNextLine()){
                    line = fileReader.nextLine().trim();
                } else{
                    break;
                }
            }
            
            this.recipes.add(name, cookingTime, ingredients);
        }
    }
    
    public void doCommands(){
        
        boolean shouldLoop = true;
        
        while (shouldLoop){
            
            System.out.println("Commands:");
            System.out.println("list - lists the recipes");
            System.out.println("stop - stops the program");
            System.out.println("find name - searches recipes by name");
            System.out.println("find cooking time - searches recipes by cooking time");
            System.out.println("find ingredient - searches recipes by ingredient");
            System.out.println("");
            
            String command = scanner.nextLine().trim();
            
            switch(command){
                case "list":
                    System.out.println("Recipes:");
                    this.recipes.list();
                    break;
                case "stop":
                    shouldLoop = false;
                    break;
                case "find cooking time":
                    System.out.println("Max cooking time:");
                    int time = Integer.valueOf(scanner.nextLine());
                    System.out.println("Recipes:");
                    this.recipes.findCookingTime(time).list();
                    break;
                case "find name":
                    System.out.println("Find name");
                    String word = scanner.nextLine();
                    System.out.println("Recipes:");
                    this.recipes.findName(word).list();
                    break;
                case "find ingredient":
                    System.out.println("Ingredient:");
                    String ingredient = scanner.nextLine();
                    System.out.println("Recipes:");
                    this.recipes.findIngredient(ingredient).list();
                    break;
                default:
                    System.out.println("Command not found");
                    
            }
        }
    }
}
