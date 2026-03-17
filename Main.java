class Main {
    public static void main (String[] args){
        // Create Studentand instructor objects and test polymorphism
        Person student1 = new Student("Elijah Jegede", "S-1238", "abc@gmail.com");
        Person student2 = new Student("Jane Doe", "S-6789", "email@hotmail.com");
        Person instructor = new Instructor("Alex Smith", "I-2043", "name@domain.com");

        // Test the getDetails() method
        System.out.println(student1.getDetails());
        System.out.println(student2.getDetails());
        System.out.println(instructor.getDetails());
    }
}