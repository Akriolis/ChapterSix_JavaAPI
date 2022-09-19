import java.util.ArrayList;
import java.util.Scanner;

public class TestCode {

    private ArrayList<Integer> locationCells = new ArrayList<>(7);

    private int numOfHits = 0;

    private int numOfGuesses = 0;

    boolean isAlive = true;

    public void setLocationCells (ArrayList<Integer> x) {
        locationCells = x;
    }

    public ArrayList<Integer> locations (){

        int randomInt = (int) (Math.random() * 5);
        ArrayList<Integer> locations = new ArrayList<Integer>();
        locations.add(randomInt);
        locations.add(randomInt+1);
        locations.add(randomInt+2);
        return locations;

    }


    public String userGuess() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Type your guess for a cell");
        String userInput = scanner.nextLine();
        return userInput;
    }

    public String checkYourself(String userGuess) {
        String result = "miss";
        int index = locationCells.indexOf(userGuess);

        /*while (isAlive) {
            numOfGuesses++;
            for (String cell : locationCells) {
                if (userGuess == cell) {
                    result = "hit";
                    locationCells.remove(cell);
                    numOfHits++;

                } else if (locations().isEmpty()) {
                    result = "kill";

                }
            }
        }return result;*/

        if (index >= 0){
            locationCells.remove(index);
            if (locationCells.isEmpty()){
                result = "kill";
            } else{
                result = "hit";
            }
        } return result;
    }
}