/**
 * @author theaw - mcorralledezma@dmacc.edu
 * CIS175 - Spring 2022
 * Feb 3, 2022
 */
package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cars")
/**
 * @author theaw
 *
 */
public class CarItem {
	
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	@Column(name="MODEL")
	private String model;
	@Column(name="COLOR")
	private String color;
	@Column(name="AMOUNT")
	private int amount;
	
	public CarItem(){
		super();
	}
	
	public CarItem(String model, String color) {
		super();
		this.model = model;
		this.color = color;
	}



	public CarItem(String model, String color, int amount) {
		super();
		this.model = model;
		this.color = color;
		this.amount = amount;
	}




	public String returnItemDetails() {
		return this.model + ":" + this.color + ":" + this.amount;
	}




	@Override
	public String toString() {
		return "CarItem [id=" + id + ", model=" + model + ", color=" + color + ", amount=" + amount + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	
	
}
