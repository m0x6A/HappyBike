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
public class BikeList {

	private ArrayList<Bike> bikeList;

	public BikeList() {
		bikeList = new ArrayList<Bike>();
	}

	/**
	 * @return the bikeList
	 */
	public ArrayList<Bike> getBikeList() {
		return bikeList;
	}

	/**
	 * @param bikeList the bikeList to set
	 */
	public void setBikeList(ArrayList<Bike> bikeList) {
		this.bikeList = bikeList;
	}

	public void addBike(Bike b) {
		bikeList.add(b);
	}

	public void removeBike(int index) {
		bikeList.remove(index);
	}

	public int bikeListSize() {
		return bikeList.size();
	}

	public Bike getBike(int i) {
		return bikeList.get(i);
	}

}
