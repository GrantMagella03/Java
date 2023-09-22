package com.maxtrain.gm.prs.data.models.product;

import com.maxtrain.gm.prs.data.models.vendor.Vendor;

import jakarta.persistence.*;

@Entity
@Table(name="Products", uniqueConstraints=@UniqueConstraint(name="UIDX_PartNbr", columnNames = {"partNbr"}))
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int id;
	@Column(length=30,nullable=false)
	public String partNbr;
	@Column(length=30,nullable=false)
	public String name;
	@Column(columnDefinition="decimal(11,2) not null")
	public double price;
	@Column(length=30,nullable=false)
	public String unit;
	@Column(length=255,nullable=true)
	public String photoPath;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="vendorId", nullable=false)
	public Vendor vendor;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPartNbr() {
		return partNbr;
	}

	public void setPartNbr(String partNbr) {
		this.partNbr = partNbr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getPhotoPath() {
		return photoPath;
	}

	public void setPhotoPath(String PhotoPath) {
		photoPath = PhotoPath;
	}

	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}
	
	
}
