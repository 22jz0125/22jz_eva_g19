package model;

import java.io.Serializable;
import java.sql.Timestamp;

public class Item implements Serializable {
	private int id;
	private String name;
	private int price;
	private String description;
	private String imageURL;
	private String material;
	private int weight;
	private int isdeleted;
	private Timestamp created_at;
	private Timestamp updated_at;

	public Item() {}

	public Item(int id, String name, int price, String description, String imageURL, String material, int weight,
				int isdeleted, Timestamp created_at, Timestamp updated_at) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
		this.imageURL = imageURL;
		this.material = material;
		this.weight = weight;
		this.isdeleted = isdeleted;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public String getDescription() {
		return description;
	}

	public String getImageURL() {
		return imageURL;
	}

	public String getMaterial() {
		return material;
	}

	public int getWeight() {
		return weight;
	}

	public int isIsdeleted() {
		return isdeleted;
	}

	public Timestamp getCreated_at() {
		return created_at;
	}

	public Timestamp getUpdated_at() {
		return updated_at;
	}

}