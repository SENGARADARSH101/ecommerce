package com.serviceops.ecommerce.dto.cart;


import com.serviceops.ecommerce.entities.Cart;
import com.serviceops.ecommerce.entities.Product;
import jakarta.validation.constraints.NotNull;

public class CartItemDto {

    private Integer id;
    private @NotNull Integer quantity;
    private @NotNull Product product;

    public CartItemDto(){

    }


    public CartItemDto(Cart cart) {
        this.setId(cart.getCartId());
        this.setQuantity(cart.getQuantity());
        this.setProduct(cart.getProduct());
    }

    @Override
    public String toString() {
        return "CartItemDto{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", productName=" + product.getProductName()+
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public String getProductName(){
        return product.getProductName();
    }
    public void setProduct(Product product) {
        this.product = product;
    }
}
