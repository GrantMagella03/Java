package com.maxtrain.gm.prs.data.models.RequestLine;

import com.fasterxml.jackson.annotation.*;
import com.maxtrain.gm.prs.data.models.Request.Request;
import com.maxtrain.gm.prs.data.models.product.Product;

import jakarta.persistence.*;

@Entity
@Table(name="RequestLines")
public class RequestLine {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int id;
	
	@JsonBackReference
	@ManyToOne(optional=false)
	@JoinColumn(name="requestId")
	public Request request;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="productId")
	public Product product;
	
	public int quantity = 1;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Request getRequest() {
		return request;
	}

	public void setRequest(Request request) {
		this.request = request;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
