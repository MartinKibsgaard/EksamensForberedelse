package KædedeStrukturer;

public class Contact {
    private String name;
    private String phone;
    private String email;

    public Contact(String name, String phone, String email) {
        if (name == null || phone == null || email == null) {
            throw new IllegalArgumentException("Name, phone, and email must not be null");
        }
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Phone: " + phone + ", Email: " + email;
    }
}
