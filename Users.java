package streamExamples;

import java.util.List;

public class Users {

    private String name;
    private String phoneNo;
    private List<String> emailId;

    public Users(String name, String phoneNo, List<String> emailId) {
        this.name = name;
        this.phoneNo = phoneNo;
        this.emailId = emailId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public List<String> getEmailId() {
        return emailId;
    }

    public void setEmailId(List<String> emailId) {
        this.emailId = emailId;
    }
}
