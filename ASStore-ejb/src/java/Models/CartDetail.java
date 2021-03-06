/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author zerox
 */
@Entity
@Table(name = "CartDetail")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "CartDetail.findAll", query = "SELECT c FROM CartDetail c")
  , @NamedQuery(name = "CartDetail.findById", query = "SELECT c FROM CartDetail c WHERE c.id = :id")
  , @NamedQuery(name = "CartDetail.findByCartId", query = "SELECT c FROM CartDetail c WHERE c.cartId = :id")
  , @NamedQuery(name = "CartDetail.findByCartIdAndProductId", query = "SELECT c FROM CartDetail c WHERE c.cartId = :cid AND c.productId = :pid")
  , @NamedQuery(name = "CartDetail.findByQuantity", query = "SELECT c FROM CartDetail c WHERE c.quantity = :quantity")
  , @NamedQuery(name = "CartDetail.findByUnitPrice", query = "SELECT c FROM CartDetail c WHERE c.unitPrice = :unitPrice")
  , @NamedQuery(name = "CartDetail.findByCoupon", query = "SELECT c FROM CartDetail c WHERE c.coupon = :coupon")})
public class CartDetail implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "Id")
  private Integer id;
  @Basic(optional = false)
  @NotNull
  @Column(name = "Quantity")
  private int quantity;
  // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
  @Column(name = "UnitPrice")
  private BigDecimal unitPrice;
  @Size(max = 100)
  @Column(name = "Coupon")
  private String coupon;
  @JoinColumn(name = "CartId", referencedColumnName = "Id")
  @ManyToOne(optional = true)
  private Cart cartId;
  @JoinColumn(name = "ProductId", referencedColumnName = "Id")
  @ManyToOne(optional = false)
  private Product productId;

  public CartDetail() {
  }

  public CartDetail(Integer id) {
    this.id = id;
  }

  public CartDetail(Integer id, int quantity) {
    this.id = id;
    this.quantity = quantity;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public BigDecimal getUnitPrice() {
    return unitPrice;
  }

  public void setUnitPrice(BigDecimal unitPrice) {
    this.unitPrice = unitPrice;
  }

  public String getCoupon() {
    return coupon;
  }

  public void setCoupon(String coupon) {
    this.coupon = coupon;
  }

  public Cart getCartId() {
    return cartId;
  }

  public void setCartId(Cart cartId) {
    this.cartId = cartId;
  }

  public Product getProductId() {
    return productId;
  }

  public void setProductId(Product productId) {
    this.productId = productId;
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
    if (!(object instanceof CartDetail)) {
      return false;
    }
    CartDetail other = (CartDetail) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "Models.CartDetail[ id=" + id + " ]";
  }
  
}
