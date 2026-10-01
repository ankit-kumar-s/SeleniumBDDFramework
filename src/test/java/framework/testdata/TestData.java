package framework.testdata;

public class TestData {

    private String username;
    private String password;
    private String productName;
    private String firstName;
    private String lastName;
    private String postalCode;

    public TestData(String username, String password, String productName, String firstName, String lastName, String postalCode){
        this.username = username;
        this.password = password;
        this.productName = productName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.postalCode = postalCode;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getProductName() {
        return productName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPostalCode() {
        return postalCode;
    }

}