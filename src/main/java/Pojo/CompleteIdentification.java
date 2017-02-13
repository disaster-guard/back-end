package Pojo;

public class CompleteIdentification {
    private User userModel;
    private Age ageModel;

    public CompleteIdentification(User userModel, Age ageModel) {
        this.userModel = userModel;
        this.ageModel = ageModel;
    }

    public User getUserModel() {
        return userModel;
    }

    public void setUserModel(User userModel) {
        this.userModel = userModel;
    }

    public Age getAgeModel() {
        return ageModel;
    }

    public void setAgeModel(Age ageModel) {
        this.ageModel = ageModel;
    }
}
