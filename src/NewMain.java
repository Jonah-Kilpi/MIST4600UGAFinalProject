import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.HashSet;


public class NewMain {
    public static void main(String[] args) {

        Scanner scnr = new Scanner(System.in);
        Boutique boutique = new Boutique();
        boutique.addFeaturedProduct("Don't Tell Mom");
        boolean online = true;

        System.out.println();
        System.out.println("Please Select From the Options Below");
        System.out.println("1: Shopping Catalogue");
        System.out.println("2: Manager Login");
        System.out.println("3: Exit");
        System.out.println();
        while (online) {
            online = MenuNavigation.menuOptions(scnr, boutique);
        }
        


    }
}
