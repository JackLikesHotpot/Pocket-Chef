package group22.seproject;

public class Admin extends RegisteredUser {

    public Admin(String userName, String password, String email){
        super(userName, password, email);
    }


    public boolean verifyReview(Review review) {
        return true;
    }

    public boolean approveRecipe(Recipe recipe) {
        return true;
    }
}
