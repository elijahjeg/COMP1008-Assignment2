public abstract class Person {
    // Declare fields
    private String name;
    private String id;
    private String email;


    // Define fields in constructor using setter methods
    Person(String name, String id, String email){
        setName(name);
        setId(id);
        setEmail(email);
    }

    // Getter methods
    String getName(){
        return name;
    }

    String getId(){
        return id;
    }

    String getEmail(){
        return email;
    }

    // Setter methods with validation
    void setName(String name){
        if (name.isEmpty()){
            throw new IllegalArgumentException("Name cannot be empty");
        }

        this.name = name;
    }

    void setId(String id){
        if (!id.matches("S-\\d{4}")){
            throw new IllegalArgumentException("ID must match the the following format: 'S-1234'");
        }
        this.id = id;
    }

    void setEmail(String email){
        // This pattern matches email name and domain name ensuring a . is used
        if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]+$")){
            throw new IllegalArgumentException("Invalid email");
        }
        this.email = email;
    }
}
