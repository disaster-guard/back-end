package Pojo;

import java.util.List;

public class User {
    private String status;
    private List<Match> matches;

    public User(String status, List<Match> matches) {
        this.status = status;
        this.matches = matches;
    }

    public List<Match> getMatches() {
        return matches;
    }

    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
