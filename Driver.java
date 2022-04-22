import java.util.InputMismatchException;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        BlueRayCollection blueRay = new BlueRayCollection();
        boolean running = true;
        do{
            printMenu();
            switch (getValidateUserInput()){
                case 0:
                    running = false;
                    break;
                case 1:
                    addToCollection(blueRay);
                    break;
                case 2:
                    blueRay.showAll();
                    break;
                default:
                    System.out.println("Invalid input, try again.");
            }
        }while(running);
    }

    //todo finish this.
    public static void addToCollection(BlueRayCollection blueRay){
        Scanner sc = new Scanner(System.in);
        System.out.println("What is the title?");
        String title = sc.nextLine();
        System.out.println("What is the director?");
        String director = sc.nextLine();
        boolean testPassed = false;
        int yearOfRelease=0;
        while (!testPassed){
            sc = new Scanner(System.in);
            System.out.println("What is its year of release?");
            try{
                yearOfRelease = Integer.parseInt(sc.nextLine());
                testPassed = true;
            }catch (InputMismatchException e){
                System.out.println("Please enter a year.");
            }
        }
        double cost=0;
        testPassed =  false;
        while(!testPassed){
            sc = new Scanner(System.in);
            System.out.println("What is the cost?");
            try{
                cost = Double.parseDouble(sc.nextLine());
                testPassed = true;
            }catch (InputMismatchException e){
                System.out.println("Please enter the cost of the blue-ray");
            }
        }
        blueRay.add(title,director,yearOfRelease,cost);
    }

    public static void printMenu(){
        System.out.println("0. Quit");
        System.out.println("1. Add BlueRay to collection");
        System.out.println("2. See collection");
    }

    public static int getValidateUserInput(){
        boolean isInputValid = false;
        while(!isInputValid){
            Scanner sc = new Scanner(System.in);
            try{
                return Integer.parseInt(sc.next());
            }catch (InputMismatchException e){
                System.out.println("Please enter a number from 0-2");
            }catch (Exception e){
                System.out.println("Please try again."+e.getMessage());
            }
        }
        //if the while loop was somehow broken out of.
        throw new IllegalStateException("While loop was broken out of.");
    }
}
