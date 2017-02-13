package Pojo;

public class Match {
    private String name;
    private Double prob;

    public Match(String name, Double prob) {
        this.name = name;
        this.prob = prob;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getProb() {
        return prob;
    }

    public void setProb(Double prob) {
        this.prob = prob;
    }
}
