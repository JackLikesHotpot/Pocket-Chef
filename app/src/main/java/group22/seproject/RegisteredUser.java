package group22.seproject;

import java.util.ArrayList;

public class RegisteredUser extends User {
    private String userName; //either make these variables public to access them from Admin class or add them in as attributes
    private String password;
    private String email;
    private ArrayList<Recipe> ownedRecipes = new ArrayList<Recipe>();

    public RegisteredUser(String userName, String password, String email) {
        this.userName = userName;
        this.password = password;
        this.email = email;
    }

    public boolean login(String userName, String password){
        // code to fetch some file
        // if userName and password match those in the file: log in, else: login failed
        return true;
    }

    public boolean addRecipe(String recipeName, ArrayList<Ingredient> ingredients, ArrayList<String> instructions, double totalcalories, double duration) throws Exception {
        //Recipe recipe = new Recipe(recipeName, ingredients, instructions, totalcalories, duration);

        //RecipeBook.getInstance().addRecipeEntry(recipe);



        //TODO: CODE THAT WILL LOOP THROUGH ADDED INGREDIENTS TO SEE IF ANY ARE NEW TO SYSTEM. IF SO, ADDS INGREDIENT TO RECIPEBOOK.

        return true;
    }

    public boolean removeRecipe(String recipe){ // ORIGINALLY A TYPE RECIPE ARGUMENT, BETTER TO BE STRING???????
        for(int i = 0; i < ownedRecipes.size(); i++) {
            if(ownedRecipes.get(i).getName().equals(recipe)) {
                ownedRecipes.remove(i);
                //TODO: REMOVE FROM RECIPEBOOK TOO
            }
        }
        return true;}

    public boolean editRecipe(Recipe recipe) {return true;}

    public boolean rateRecipe(Recipe recipe, int rating) {return true;}

    private Review writeReview(Recipe recipe, String review) {
        return new Review();}

    public String getUsername(){
        return userName;
    }
}