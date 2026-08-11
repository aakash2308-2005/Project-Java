import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Scanner;

class Library{
    Scanner sc = new Scanner(System.in);
    private List<Book> collectionOfBooks = new ArrayList<>();
    private List<Member> collectionOfMembers = new ArrayList<>();
    private Set<String> collectionOfBookIds = new HashSet<>();
    private Set<String> collectionOfMemberIds = new HashSet<>();

    public void addBook()
    {
        System.out.println("Enter Book ID: ");
        String bookId = sc.next();

        if (collectionOfBookIds.contains(bookId))
        {
            System.out.println("Book Id already exists!\n");
            return;
        }

        Book book = new Book();

        System.out.println("Enter Title: ");
        sc.nextLine();
        String title = sc.nextLine();

        System.out.println("Enter Author: ");
        String author = sc.nextLine();

        book.setBookId(bookId);
        book.setTitle(title);
        book.setAuthor(author);

        collectionOfBooks.add(book);
        collectionOfBookIds.add(bookId);

        System.out.println("Book added successfully.\n");

    }

    public void viewAllBooks()
    {
        System.out.println("===== ALL BOOKS =====");

        int size = collectionOfBooks.size();

        if (size == 0)
        {
            System.out.println("No books available.");
            return;
        }
        else
        {
            System.out.println("ID           TITLE                AUTHOR              STATUS");

            for (Book book : collectionOfBooks)
            {
                System.out.println(book.getBookId() + "    " + book.getTitle() + "   " + book.getAuthor() + "   " + book.getAvailabilityStatus());
            }
        }
    }

    public void searchBook()
    {
        System.out.println("Search by BookId/Title/Author");
        String search = sc.next();

        if (search.toLowerCase().equals("bookid"))
        {
            System.out.println("BookId: ");
            String id = sc.next();
            boolean found = false;
            for (Book book : collectionOfBooks)
            {
                if (book.getBookId().equals(id))
                {
                    found = true;
                    System.out.println("ID           TITLE              AUTHOR");
                    System.out.println(book.getBookId() + "    " + book.getTitle() + "   " + book.getAuthor());
                    break;
                }
            }

            if (!found)
            {
                System.out.println("No Books are present");
            }
        }

        else if(search.toLowerCase().equals("title"))
        {
            System.out.println("Title: ");
            sc.nextLine();
            String title = sc.nextLine();
            List<String> foundTitles = new ArrayList<>();
            boolean found = false;

            for (Book book : collectionOfBooks)
            {
                String tle = book.getTitle();
                int position = tle.indexOf(title);

                if (position != -1)
                {
                    found = true;
                    foundTitles.add(tle);                   
                }
            }

            if (!found)
            {
                System.out.println("No Books are present");
            }
            else
            {
                System.out.println(foundTitles);
            }

        }

        else if(search.toLowerCase().equals("author"))
        {
            System.out.println("Author: ");
            sc.nextLine();
            String author = sc.nextLine();
            List<String> foundAuthors = new ArrayList<>();
            boolean found = false;

            for (Book book : collectionOfBooks)
            {
                String athr = book.getAuthor();
                int position = athr.indexOf(author);
                
                if (position != -1)
                {
                    found = true;
                    foundAuthors.add(athr);
                }
            }

            if (!found)
            {
                System.out.println("No Books are present");
            }
            else
            {
                System.out.println(foundAuthors);
            }

        }
    }

    public void registerMember()
    {
        System.out.println("Enter Member ID: ");
        String memberId = sc.next();

        if (collectionOfMemberIds.contains(memberId))
        {
            System.out.println("Member Id already exists!");
            return;
        }

        Member member = new Member();

        System.out.println("Enter Member Name: ");
        sc.nextLine();
        String memberName = sc.nextLine();

        member.setMemberId(memberId);
        member.setMemberName(memberName);
        collectionOfMembers.add(member);
        collectionOfMemberIds.add(memberId);

        System.out.println("Member registered successfully.");

    }

    public void viewMembers()
    {
        System.out.println("===== MEMBERS =====");
        int size = collectionOfMembers.size();

        if (size == 0)
        {
            System.out.println("No members available.");
        }
        else
        {
            System.out.println("ID       NAME");

            for (Member member : collectionOfMembers)
            {
                System.out.println(member.getMemberId() + "       " + member.getMemberName());
            }
        }
    }

    public void borrowBook()
    {
        System.out.println("Enter Member ID: ");
        String memberId = sc.nextLine();

        if (collectionOfMemberIds.contains(memberId))
        {
            System.out.println("Enter Book ID: ");
            String bookId = sc.nextLine();
            if (collectionOfBookIds.contains(bookId))
            {
                for (Book book : collectionOfBooks)
                {
                    if (bookId.equals(book.getBookId()))
                    {
                        if (book.getAvailabilityStatus().equals("Available"))
                        {
                            book.setAvailabilityStatus("Borrowed");
                            System.out.println("Book borrowed successfully.");

                            for (Member member : collectionOfMembers)
                            {
                                if (member.getMemberId().equals(memberId))
                                {
                                    member.getBorrowedBooks().add(book);
                                }
                            }
                            break;
                        }
                        else
                        {
                            System.out.println("Book is currently unavailable.");
                        }
                    }
                }

            }
            else
            {
                System.out.println("Book not found.");
            }

        }
        else
        {
            System.out.println("Member not found.");
        }
    }

    public void returnBook()
    {
        
        System.out.println("Enter Member ID: ");
        String memberId = sc.nextLine();

        if (collectionOfMemberIds.contains(memberId))
        {
            for (Member member : collectionOfMembers)
            {

                if(member.getMemberId().equals(memberId))
                {
                    System.out.println("Enter Book ID: ");
                    String bookId = sc.nextLine();
                    int found = -1;
                    for (int i = 0; i < member.getBorrowedBooks().size(); i++)
                    {
                        Book book = member.getBorrowedBooks().get(i);
                        if (book.getBookId().equals(bookId))
                        {
                            found = i;
                            book.setAvailabilityStatus("Available");
                            break;
                        }
                    }
                    if (found == -1)
                    {
                        System.out.println("Book not borrowed.");
                    }
                    else
                    {
                        member.getBorrowedBooks().remove(found);
                        System.out.println("Book returned successfully.");

                    }
                }
            }
        }
        else
        {
            System.out.println("Member not found.");
        }

    }

    public void viewBorrowedBooks()
    {
        System.out.println("Enter Member ID: ");
        String memberId = sc.nextLine();

        if (collectionOfMemberIds.contains(memberId))
        {
            for (Member member : collectionOfMembers)
            { 
                if(member.getMemberId().equals(memberId))
                {
                    System.out.println("===== BORROWED BOOKS =====");
                    int size = member.getBorrowedBooks().size();

                    if (size == 0)
                    {
                        System.out.println("This member has no borrowed books.");
                        return;
                    }

                    else
                    {
                        for (Book book : member.getBorrowedBooks())
                        {
                           System.out.println(book.getBookId() + "     " + book.getTitle() + "     " + book.getAuthor());
                        }

                    }
                    break;
        
                }
            }

        }
        else
        {
            System.out.println("Member not found.");
        }


    }
}

