import java.util.ArrayList;

public class Startup {

    private ArrayList<String> locationCells;
    private String name;

    public void setLocationCells (ArrayList<String> x) {
        locationCells = x;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public String checkYourself(String userGuess) {
        String result = "miss";
        int index = locationCells.indexOf(userGuess);
        if (index >= 0) {
            locationCells.remove(index);

            if (locationCells.isEmpty()) {
                result = "kill";
                System.out.println("Ouch! you sunk " + name + " :( ");
            } else {
                result = "hit";
            }
        }
        return result;
    }
}
