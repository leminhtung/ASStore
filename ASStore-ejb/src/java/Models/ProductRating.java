/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Tien Phat
 */
@Entity
@Table(name = "ProductRating")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductRating.findAll", query = "SELECT p FROM ProductRating p")
    , @NamedQuery(name = "ProductRating.findById", query = "SELECT p FROM ProductRating p WHERE p.id = :id")
    , @NamedQuery(name = "ProductRating.findByRating", query = "SELECT p FROM ProductRating p WHERE p.rating = :rating")})
public class ProductRating implements Serializable {

    

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @JoinColumn(name = "ProductId", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Product productId;
    @JoinColumn(name = "UsersId", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Users usersId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Rating")
    private double rating;
    
    public ProductRating() {
    }

    public ProductRating(Integer id) {
        this.id = id;
    }

    public ProductRating(Integer id, int rating) {
        this.id = id;
        this.rating = rating;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }

    public Users getUsersId() {
        return usersId;
    }

    public void setUsersId(Users usersId) {
        this.usersId = usersId;
    }
    
    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductRating)) {
            return false;
        }
        ProductRating other = (ProductRating) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Models.ProductRating[ id=" + id + " ]";
    }

    
    
}
