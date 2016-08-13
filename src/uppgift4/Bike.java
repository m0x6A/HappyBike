/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uppgift4;

import java.util.ArrayList;

/**
 *
 * @author xdr
 */
public class Bike {

	private long wheelSize;
	private String color;
	private String type;
	private int km;
	private long weight;
	private String name; 

	/**
	 * @return the wheelSize
	 */
	public Long getWheelSize() {
		return wheelSize;
	}

	/**
	 * @param wheelSize the wheelSize to set
	 */
	public void setWheelSize(Long wheelSize) {
		this.wheelSize = wheelSize;
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the km
	 */
	public int getKm() {
		return km;
	}

	/**
	 * @param km the km to set
	 */
	public void setKm(int km) {
		this.km = km;
	}

	/**
	 * @return the weight
	 */
	public long getWeight() {
		return weight;
	}

	/**
	 * @param weight the weight to set
	 */
	public void setWeight(long weight) {
		this.weight = weight;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
}
