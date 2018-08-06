package com.jk.pojo;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class boos  implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String bookName;
    private Integer bookNumber;
    private Integer bookPrice;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Integer getBookNumber() {
        return bookNumber;
    }

    public void setBookNumber(Integer bookNumber) {
        this.bookNumber = bookNumber;
    }

    public Integer getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(Integer bookPrice) {
        this.bookPrice = bookPrice;
    }


    @Override
    public String toString() {
        return "boos{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", bookNumber=" + bookNumber +
                ", bookPrice=" + bookPrice +
                '}';
    }
}


