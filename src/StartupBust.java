import java.util.ArrayList;

public class StartupBust {
    // declare and initialize the variables
    private GameHelper helper = new GameHelper();
    private ArrayList<Startup> startups = new ArrayList<Startup>();
    private int numOfGuesses = 0;

    // make three Startup object
    public void setUpGame() {
        Startup one = new Startup();
        one.setName("poniez");
        Startup two = new Startup();
        two.setName("hacqi");
        Startup three = new Startup();
        three.setName("cabista");
        startups.add(one);
        startups.add(two);
        startups.add(three);

        // print brief instructions for user
        System.out.println("Your goal is to sink three Startups");
        for (Startup startup : startups) {
            System.out.println(startup.getName());
        }
        System.out.println("Try to sink them all in the fewest number of guesses");

        // call the setter method
        for (Startup startup : startups) {
            ArrayList<String> newLocation = helper.placeStartup(3);
            startup.setLocationCells(newLocation);
        }
    }

    public void startPlaying(){
        while (!startups.isEmpty()){
            String userGuess = helper.getUserInput("Enter a guess");
            CheckUserGuess(userGuess);
        }
        finishGame();
    }

    private void CheckUserGuess (String userGuess){
        numOfGuesses++;
        String result = "miss";

        for (Startup startupToTest: startups){
            result = startupToTest.checkYourself(userGuess);

            if (result.equals("hit")){
                break;
            }
            if (result.equals("kill")){
                startups.remove(startupToTest);
                break;
            }
        }
        System.out.println(result);
    }

    private void finishGame(){
        System.out.println("All Startups are dead! Your stock is now worthless");
        if (numOfGuesses <= 18){
            System.out.println("It only took you " + numOfGuesses + " guesses.");
            System.out.println("You got out before your options sank.");
        } else{
            System.out.println("Took you long enough. " +numOfGuesses + " guesses.");
            System.out.println("Fish are dancing with your options");
        }
    }


}