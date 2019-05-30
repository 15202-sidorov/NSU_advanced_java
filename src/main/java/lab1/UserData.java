package lab1;

public class UserData {

    public UserData(String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }

    public void setAlterationsCount(int alterationsCount) {
        this.alterationsCount = alterationsCount;
    }
    public void increaseAlterationsCount() { this.alterationsCount++; }

    public int getAlterationsCount() {
        return this.alterationsCount;
    }

    private final String username;
    private int alterationsCount = UserData.ALTERATIONS_COUNT_START;

    private static final int ALTERATIONS_COUNT_START = 0;
}
