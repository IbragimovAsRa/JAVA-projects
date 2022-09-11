package models;

public class User {
    String login;
    String password;
    String mail;

    public User(String login, String password, String mail) {
        this.login = login;
        this.password = password;
        this.mail = mail;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMail() {
        return mail;
    }

    public String getPassword() {
        return password;
    }

    public String getLogin() {
        return login;
    }
}
