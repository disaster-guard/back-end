package Pojo;

public class Credentials {
    private String name;
    private String password;
    private String email;

    public Credentials(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        String str = "";
        str += this.getName();
        str += ",";
        str += this.getPassword();
        str += ",";
        str += this.getEmail();
        return str;
    }
}
