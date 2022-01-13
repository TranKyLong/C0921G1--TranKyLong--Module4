package app.model;

public class LoginAccount {
    private String id;
    private String password;
    private String contactNumber;
    private String fullName;
    private int age;
    private int gender; //1 là nam, khac 1 la nữ
    private String mail;


    public LoginAccount() {
    }

    public LoginAccount(String id, String password, String contactNumber, String fullName, int age, int gender, String mail) {
        this.id = id;
        this.password = password;
        this.contactNumber = contactNumber;
        this.fullName = fullName;
        this.age = age;
        this.gender = gender;
        this.mail = mail;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoginAccount that = (LoginAccount) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
