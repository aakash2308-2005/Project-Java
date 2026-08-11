import java.util.Scanner;

class Main{
    public static void main(String args[])
    {
        boolean stop = false;
        Scanner sc = new Scanner(System.in);
        Library library = new Library();

        while (!stop)
        {
            System.out.println("\n\n===== LIBRARY MANAGEMENT SYSTEM =====\n\n");
            System.out.println(
                "1. Add Book\n2. View All Books\n3. Search Book\n4. Register Member\n5. View Members\n" +
                "6. Borrow Book\n7. Return Book\n8. View Borrowed Books\n9. Exit\n\n");
            System.out.println("Enter choice: ");

            int choice = sc.nextInt();

            switch(choice)
            {
                case 1:
                    library.addBook();
                    break;

                case 2:
                    library.viewAllBooks();
                    break;

                case 3:
                    library.searchBook();
                    break;

                case 4:
                    library.registerMember();
                    break;

                case 5:
                    library.viewMembers();
                    break;

                case 6:
                    library.borrowBook();
                    break;

                case 7:
                    library.returnBook();
                    break;

                case 8:
                    library.viewBorrowedBooks();
                    break;

                case 9:
                    stop = true;
                    System.out.println("GoodBye!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again!");
                    break;

            }

        }
    }
}