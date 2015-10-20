import java.util.List;

public class Players {
    public List<Player> players;

    public void AddPlayer(String entry){
        Player player = new Player();
        player.AddName(entry);
        players.add(player);
    }

    public String getPlayerNameByNumber(int playerNumber) {
        Player currentPlayer = players.get(playerNumber);
        return currentPlayer.getDisplayName();
    }

    public String getAllPlayerNames() {
        String playerString = "";
        for(Player player: players){
            playerString += player.getDisplayName();
        }
        return playerString;
    }
}
