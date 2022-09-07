package edu.springboot.admin.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName t_book
 */
@TableName(value ="t_book")
@Data
public class Book implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 
     */
    private String bookimg;

    /**
     * 
     */
    private String bookname;

    /**
     * 
     */
    private Double price;

    /**
     * 
     */
    private String author;

    /**
     * 
     */
    private Integer salecount;

    /**
     * 
     */
    private Integer bookcount;

    /**
     * 
     */
    private Integer bookstatus;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Book other = (Book) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getBookimg() == null ? other.getBookimg() == null : this.getBookimg().equals(other.getBookimg()))
            && (this.getBookname() == null ? other.getBookname() == null : this.getBookname().equals(other.getBookname()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
            && (this.getAuthor() == null ? other.getAuthor() == null : this.getAuthor().equals(other.getAuthor()))
            && (this.getSalecount() == null ? other.getSalecount() == null : this.getSalecount().equals(other.getSalecount()))
            && (this.getBookcount() == null ? other.getBookcount() == null : this.getBookcount().equals(other.getBookcount()))
            && (this.getBookstatus() == null ? other.getBookstatus() == null : this.getBookstatus().equals(other.getBookstatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getBookimg() == null) ? 0 : getBookimg().hashCode());
        result = prime * result + ((getBookname() == null) ? 0 : getBookname().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        result = prime * result + ((getAuthor() == null) ? 0 : getAuthor().hashCode());
        result = prime * result + ((getSalecount() == null) ? 0 : getSalecount().hashCode());
        result = prime * result + ((getBookcount() == null) ? 0 : getBookcount().hashCode());
        result = prime * result + ((getBookstatus() == null) ? 0 : getBookstatus().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", bookimg=").append(bookimg);
        sb.append(", bookname=").append(bookname);
        sb.append(", price=").append(price);
        sb.append(", author=").append(author);
        sb.append(", salecount=").append(salecount);
        sb.append(", bookcount=").append(bookcount);
        sb.append(", bookstatus=").append(bookstatus);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}