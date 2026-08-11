import java.util.List;
import java.util.ArrayList;

class Member
{
    private String memberId;
    private String memberName;
    private List<Book> borrowedBooks = new ArrayList<>();

    // public Member(String memberId, String memberName){
    //     this.memberId = memberId;
    //     this.memberName = memberName;
    // }

    public void setMemberId(String memberId)
    {
        this.memberId = memberId;
    }

    public void setMemberName(String memberName)
    {
        this.memberName = memberName;
    }

    public String getMemberId()
    {
        return memberId;
    }

    public String getMemberName()
    {
        return memberName;
    }

    public List<Book> getBorrowedBooks()
    {
        return borrowedBooks;
    }
}