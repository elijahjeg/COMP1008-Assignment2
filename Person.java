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
        String idRegex = getIdRegex();
        String idFormat = idRegex.substring(0, 2) + "1234";// Either I- or S- then 1234

        if (!id.matches(getIdRegex())){ // Use abstract method since format could be S-1234 or I-1234
            throw new IllegalArgumentException(
                "ID must match the the following format: '" + idFormat + "'"
            );
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

    // Abstract method will be implemented in subclasses
    public abstract String getDetails();

    // Abstract protected method to determine the regex for ID
    protected abstract String getIdRegex();

}
