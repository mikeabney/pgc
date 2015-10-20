
public class Player {
    private Name name;

   public void AddName(String entry) {
        this.name = new Name(entry);
    }

    public String getDisplayName() {
        return this.name.value;
    }
}
