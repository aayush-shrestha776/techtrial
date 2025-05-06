package com.TechSansar.model;

public class ProductModel {
    private String name;
    private String imageUrl;
    private int price;
    private String description;// Added description field

    // Constructor with description field
    public ProductModel(String name, String imageUrl, int price, String description) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.price = price;
        this.description = description;  // Initialize the description
    }

    public ProductModel() {
		super();
	}

	// Getters and Setters for all fields
    
	public String getName() {
        return name;
    }

    public void setName(String name) {
		this.name = name;
	}


	public String getImageUrl() {
        return imageUrl;
    }
	
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public int getPrice() {
        return price;
    }
	
	public void setPrice(int price) {
		this.price = price;
	}

    public String getDescription() {
        return description;  // Getter for description
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

