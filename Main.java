import java.util.Scanner;

class Main {
    public static void main (String[] args){
        // Create a new scanner object for input
        Scanner scanner = new Scanner(System.in);

        // Create Student and instructor objects and test polymorphism
        Person student1 = new Student("Elijah Jegede", "S-1238", "abc@gmail.com");
        Person student2 = new Student("Jane Doe", "S-6789", "email@hotmail.com");
        Person instructor = new Instructor("Alex Smith", "I-2043", "name@domain.com");

        // Test the getDetails() method
        System.out.println(student1.getDetails());
        System.out.println(student2.getDetails());
        System.out.println(instructor.getDetails());

        System.out.println("---------");
        // Create a student
        boolean stop = false;
        String name;
        String id;
        String email;
        Student userStudent;
        while (!stop){
            // Get user input; trim to remove any whitespace
            System.out.println("Enter student's name: ");
            name = scanner.nextLine().trim();

            System.out.println("Enter student ID: ");
            id = scanner.nextLine().trim();

            System.out.println("Enter student's email: ");
            email = scanner.nextLine().trim();
    
            try {
                userStudent = new Student(name, id, email);
                stop = true; // We got valid input, now we can display it
                System.out.println("------------");
                System.out.println(userStudent.getDetails());
            }

            catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }
}