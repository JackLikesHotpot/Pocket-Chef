package group22.seproject;

//An UnregisteredUser can do everything a user can do with only one other method - creating a registered user account.

public class UnregisteredUser extends User {

    public UnregisteredUser(){
    }

    // TODO: FIND A WAY TO REMOVE THE UNREGISTEREDUSER INSTANCE AFTER A NEW REGISTEREDUSER INSTANCE IS MADE
    public boolean createAccount(String userName, String password, String email){

        RegisteredUser regUser = new RegisteredUser(userName, password, email);
        return true;
    }
}