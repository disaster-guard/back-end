package Pojo;

public class Age {
    private String status;
    private String gender;
    private String age;
    private String ethnicity;

    public Age(String status, String gender, String age, String ethnicity) {
        this.status = status;
        this.gender = gender;
        this.age = age;
        this.ethnicity = ethnicity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEthnicity() {
        return ethnicity;
    }

    public void setEthnicity(String ethnicity) {
        this.ethnicity = ethnicity;
    }
}
