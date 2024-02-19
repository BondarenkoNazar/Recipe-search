
import java.util.ArrayList;


public class RecipeList {
    
    private ArrayList<Recipe> recipes;
    
    public RecipeList(){
        this.recipes = new ArrayList<>();
    }
    
    public void size(){
        System.out.println(recipes.size());
    }
    
    public void add(String name, int cookingTime, ArrayList<String> ingredients){
        this.recipes.add(new Recipe(name, cookingTime, ingredients));
    }
    
    public void add(Recipe recipe){
        this.recipes.add(recipe);
    }
    
    public void list(){
        for (Recipe recipe: recipes){
            System.out.println(recipe.toString());
        }
    }
    
    public RecipeList findCookingTime(int time){
        RecipeList recipeList = new RecipeList();
        
        for (Recipe recipe: recipes){
            if (recipe.getCookingTime() <= time){
                recipeList.add(recipe);
            }
        }
        
        return recipeList;
    }
    
    public RecipeList findName(String name){
        RecipeList recipeList = new RecipeList();
        
        for (Recipe recipe: recipes){
            if (recipe.getName().contains(name)){
                recipeList.add(recipe);
            }
        }
        
        return recipeList;
    }
    
    public RecipeList findIngredient(String ingredient){
        RecipeList recipeList = new RecipeList();
        
        for (Recipe recipe: recipes){
            if (recipe.getIngredients().contains(ingredient)){
                recipeList.add(recipe);
            }
        }
        
        return recipeList;
    }
}
