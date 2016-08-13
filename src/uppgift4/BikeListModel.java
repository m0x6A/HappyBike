/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uppgift4;

import javax.swing.AbstractListModel;

/**
 *
 * @author xdr
 */
public class BikeListModel extends AbstractListModel {

	private BikeList bikeList;

	@Override
	public int getSize() {
		return bikeList.bikeListSize();
	}

	@Override
	public Object getElementAt(int i) {
		Bike b = bikeList.getBike(i);
		String bikeString = b.getName();
		return bikeString;
	}

	/**
	 * @return the bikeList
	 */
	public BikeList getBikeList() {
		return bikeList;
	}

	/**
	 * @param bikeList the bikeList to set
	 */
	public void setBikeList(BikeList bikeList) {
		this.bikeList = bikeList;
		this.fireContentsChanged(this, 0, bikeList.bikeListSize() - 1);
	}

	public void update() {
		this.fireContentsChanged(this, 0, bikeList.bikeListSize() - 1);

	}
}
