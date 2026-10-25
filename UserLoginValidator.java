public class Main {
    public static void main(String[] args) { 
 
        String username = "johnfolbillutiskolarngbayan@gmail.com"; 
 
 
        String password = "04302003"; 
        boolean accountLocked = false; 
 
        String enteredUsername = "johnfolbillutiskolarngbayan@gmail.com"; 
        String enteredPassword = "04302001"; 
 
        System.out.println("=== Login Validator ==="); 
 
        if (enteredUsername.equals(username)) { 
            System.out.println("Username is correct."); 
 
            if (enteredPassword.equals(password)) { 
                System.out.println("Password is correct."); 
 
                if (!accountLocked) { 
                    System.out.println("Login successful!"); 
                } else { 
                    System.out.println("Login failed: Account is locked."); 
                } 
 
            } else { 
                System.out.println("Login failed: Incorrect password."); 
            } 
 
        } else { 
            System.out.println("Login failed: Incorrect username."); 
        } 
    } 
}