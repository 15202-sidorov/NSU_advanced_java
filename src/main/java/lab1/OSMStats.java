package lab1;

import java.util.HashMap;

import lab1.UserData;

public class OSMStats {

    public void setUserStat(UserData userData) {
        this.stats.put(userData.getUsername(), userData);
    }

    public HashMap<String, UserData> getUsersStats() {
        return stats;
    }

    public void increaseUserAlterations(String username) {
        if (!stats.containsKey(username)) {
            stats.put(username, new UserData(username));
        }
        stats.get(username).increaseAlterationsCount();
    }

    private HashMap<String, UserData> stats = new HashMap<String, UserData>();
}
