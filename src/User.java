import java.util.ArrayList;
import java.util.Random;
public class User {
    private String username;
    private String password;
    private String email;
    private int birthYear;
    private int birthMonth;
    private int birthDay;
    private boolean isDOBSet;
    private boolean isMember;
    private String membershipID;
    private static ArrayList<String> allMembershipIDs = new ArrayList<String>();

    public User(String username, String password, String email, boolean isMember) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.isDOBSet = false;
        this.isMember = isMember;
        if (isMember) {
            addMembership();
        }
    }

    public User(String username, String password, String email, boolean isMember, int birthYear, int birthMonth, int birthDay) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.birthYear = birthYear;
        this.birthMonth = birthMonth;
        this.birthDay = birthDay;
        this.isDOBSet = true;
        this.isMember = isMember;
        if (isMember) {
            addMembership();
        }
    }

    public double applyDiscount(double price) {
        double discount = 0.10;
        return price * (1 - discount);
    }

    public boolean isMember() {
        return isMember;
    }

    public void addMembership() {
        this.isMember = true;
        this.membershipID = generateMembershipID();
        allMembershipIDs.add(this.membershipID);
        // System.out.println("Your membership ID is " + this.membershipID);
    }

    public void removeMembership() {
        this.isMember = false;
        allMembershipIDs.remove(this.membershipID);
        this.membershipID = null;
    }

    private static String generateMembershipID() {
        Random random = new Random();
        int number = random.nextInt(9000) + 1000;
        String generatedID = String.valueOf(number);
        while (allMembershipIDs.contains(generatedID)) {
            number = random.nextInt(9000) + 1000;
            generatedID = String.valueOf(number);
        }
        return generatedID;
    }

    public static boolean isMembershipValid(String membershipID) {
        return allMembershipIDs.contains(membershipID);
    }

    public void printMembershipID() {
        if (this.isMember && this.membershipID != null) {
            System.out.println("Your membership ID is " + this.membershipID);
        }
        else {
            System.out.println("You are not a member.");
        }
    }
}
