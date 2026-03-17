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
            System.out.println(
                "Choose one of the following options:\n" +
                "   [1] Add a new student\n" +
                "   [2] Remove a student by ID\n" +
                "   [3] Display all students\n" +
                "   [4] Search a student by ID or name\n" +
                "   [5] Quit"
            );
            
            // Trim any whitespace
            String option = scanner.nextLine().trim();

            switch (option){
                case ("1"):
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
                    break;
                default: // If anything other than a valid option is entered let the user know
                    System.out.println("You must enter an option between 1 and 5");
            }
        }
    }
}