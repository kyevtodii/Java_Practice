public class Customer
{
    private final String name;
    private final String phone;
    private final String eMail;

    public Customer(String name, String phone, String eMail)
    {
        this.name = name;
        if (!eMail.matches("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")) {
            throw new IllegalArgumentException("Wrong email format!");
        }
        this.eMail = eMail;
        if (!phone.matches("\\+\\d{11}")) {
            throw new IllegalArgumentException("Wrong phone number format!");
        }
        this.phone = phone;
    }

    public String toString()
    {
        return name + " - " + eMail + " - " + phone;
    }
}
