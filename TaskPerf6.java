/* Juan Carlos T. Matias
IT201A */

import java.util.*;
import java.nio.file.*;
import java.io.*;
import static java.nio.file.StandardOpenOption.*;


public class TaskPerf6 {

    // Variables Area

    static Scanner s = new Scanner(System.in);
    static String filePath = "D:\\VS Studio Code Workshop\\2ND SEM MIDTERMS\\06TaskPerformance1\\src\\records.txt";

    static String choice, username, password, user, pass;
    static String choice2 = "Again";
    static String tempor = null;
    static boolean found = false;

    public static void Account() {      // Account Register or Login choice method

        try {

            System.out.println("Welcome to the Account Form! Enter your choice");
            System.out.print("Register | Login | Any Key to Exit: ");
            choice = s.nextLine();
            
            if (choice.equalsIgnoreCase("Register")) {
                RegisterAccount();
            }

            else if (choice.equalsIgnoreCase("Login")) {
                LoginAccount();
            }

            else {
                System.out.println("Your choice was invalid...");
            }

        } 
        
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static void RegisterAccount() {      // Register Method

        try {

            Path records = Paths.get(filePath.toString());
            OutputStream os = new BufferedOutputStream(Files.newOutputStream(records, APPEND));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));

                while (choice2.equalsIgnoreCase("Again")) {

                    System.out.print("Enter username: ");
                    username = s.nextLine();
                    System.out.print("Enter password: ");
                    password = s.nextLine();

                    bw.write(username + "," + password);
                    bw.newLine();

               

                    System.out.println("Account creation successful!");
                    System.out.print("Type Again to register another account. Type anything to quit: ");
                    choice2 = s.nextLine();

                

                }

            System.out.println("Thank you for Registering! Run the program again to Login!");
            bw.close();
            
        } 
        
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static void LoginAccount() {     // Login Method
        try {
            
            Path records = Paths.get(filePath.toString());
            InputStream is = Files.newInputStream(records);
            BufferedReader br = new BufferedReader(new InputStreamReader(is)); 

            System.out.print("Enter Username: ");       // Asks user for username and password
            username = s.nextLine();
            System.out.print("Enter Password: ");
            password = s.nextLine();

            while ((tempor = br.readLine()) != null) {
                String[] account = tempor.split(",");
                user = account[0];
                pass = account[1];

                if(user.equals(username) && pass.equals(password)) {        // If the entered username and password matched with the contents of the text file.
                    System.out.println("The Account you logged in was: " + username);
                    found = true;
                }
            }           
        } 

        catch (Exception e) {
            System.out.println(e.getMessage());
        }

            if (found == true) {
                System.out.println("Thank you for logging in!");
                System.exit(0);
            }

            else {
                System.out.println("Log in failed. Either username or password was invalid!");
                System.exit(0);
            }
    }

    public static void main(String[] args) {

        Account();

    }
    
}