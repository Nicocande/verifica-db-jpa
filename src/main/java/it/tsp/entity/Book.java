package it.tsp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;



@NamedQueries({
    @NamedQuery(name = Book.FIND_BY_BOOK_ID, query = "select e from t_books e where e.bookID= :id")})
@Entity
@Table(name = "t_books")

public class Book  {


    public static final String FIND_BY_BOOK_ID = "Book.findByAccountId";


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bookID")
    protected int id;
    @Column(name = "bookname")
    private String bookname;
    @Column(name = "price")
    private int price;
    

    public int getId() {
        return id;
    }

    public Book() {

    }

    public Book(String bookname, int edition, int price) {
        this.bookname = bookname;
        this.price = price;
    }

    public String getBname() {
        return bookname;
    }

    public void setBname(String bookname) {
        this.bookname = bookname;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + id;
        result = prime * result + ((bookname == null) ? 0 : bookname.hashCode());
        result = prime * result + price;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Book other = (Book) obj;
        if (id != other.id)
            return false;
        if (bookname == null) {
            if (other.bookname != null)
                return false;
        } else if (!bookname.equals(other.bookname))
            return false;
        if (price != other.price)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Book [bname=" + bookname + ", price=" + price + "]";
    }

}
