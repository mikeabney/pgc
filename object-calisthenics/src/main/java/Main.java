

class DisplayBowlerScoreChallenge {
    public static void main(String[] args) {
        Players Players = new Players();

        System.out.println("--- Welcome to Silly Bowling ---");
        System.out.print("Provide a Bowler Name (use a blank name to start bowling)");
        String addAnother = System.console().readLine();
        while(addAnother.length() > 0){
            Players.AddPlayer(addAnother);
            System.out.println("Bowlers so far:" + Players.getAllPlayerNames());
            addAnother = System.console().readLine();
        }
        System.out.println("Ready to bowl!");
        Game game = new Game(Players);

    }
}