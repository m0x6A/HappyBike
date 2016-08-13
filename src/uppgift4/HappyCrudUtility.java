/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uppgift4;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

/**
 *
 * @author xdr
 */
public class HappyCrudUtility {

	static void writeToFile(BikeList myBikeList, File currentFile) throws ParserConfigurationException, TransformerConfigurationException, TransformerException {

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		dbf.setValidating(false);
		Document doc = db.newDocument();
		Element bikesElement = doc.createElement("bikes");
		doc.appendChild(bikesElement);

		for (int i = 0; i < myBikeList.bikeListSize(); i++) {
			Bike b = myBikeList.getBike(i);

			Element bikeElement = doc.createElement("bike");

			Element nameElement = doc.createElement("name");
			Text nameNode = doc.createTextNode(b.getName());
			nameElement.appendChild(nameNode);
			bikeElement.appendChild(nameElement);

			Element typeElement = doc.createElement("type");
			Text typeTextNode = doc.createTextNode(b.getType());
			typeElement.appendChild(typeTextNode);
			bikeElement.appendChild(typeElement);

			Element colorElement = doc.createElement("color");
			Text colorTextNode = doc.createTextNode(b.getColor());
			colorElement.appendChild(colorTextNode);
			bikeElement.appendChild(colorElement);

			Element kmElement = doc.createElement("km");
			Text kmTextNode = doc.createTextNode(Integer.toString(b.getKm()));
			kmElement.appendChild(kmTextNode);
			bikeElement.appendChild(kmElement);

			Element weightElement = doc.createElement("weight");
			Text weightTextNode = doc.createTextNode(Long.toString(b.getWeight()));
			weightElement.appendChild(weightTextNode);
			bikeElement.appendChild(weightElement);

			Element wheelSizeElement = doc.createElement("wheelsize");
			Text wheelSizeTextNode = doc.createTextNode(Long.toString(b.getWheelSize()));
			wheelSizeElement.appendChild(wheelSizeTextNode);
			bikeElement.appendChild(wheelSizeElement);

			bikesElement.appendChild(bikeElement);

			Source source = new DOMSource(doc);
			Result result = new StreamResult(currentFile);

			Transformer transformer;
			transformer = TransformerFactory.newInstance().newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

			transformer.transform(source, result);

		}
	}

	public static BikeList readFromFile(File fil) throws ParserConfigurationException, SAXException, IOException, NumberFormatException {
		BikeList myBikeList = new BikeList();

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setValidating(false);
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(fil);

		NodeList bikeList = doc.getElementsByTagName("bike");

		for (int i = 0; i < bikeList.getLength(); i++) {
			Bike b = new Bike();
			Element bikeElement = (Element) bikeList.item(i);

			NodeList nameList = bikeElement.getElementsByTagName("name");

			String name = nameList.item(0).getFirstChild().getNodeValue();
			b.setName(name);

			NodeList colorList = bikeElement.getElementsByTagName("color");

			String color = colorList.item(0).getFirstChild().getNodeValue();
			b.setColor(color);

			NodeList typeList = bikeElement.getElementsByTagName("type");
			String type = typeList.item(0).getFirstChild().getNodeValue();
			b.setType(type);

			NodeList wheelSizeList = bikeElement.getElementsByTagName("wheelsize");

			String wheelSizeStr = wheelSizeList.item(0).getFirstChild().getNodeValue();
			long wheelSize = Long.parseLong(wheelSizeStr);
			b.setWheelSize(wheelSize);

			NodeList kmList = bikeElement.getElementsByTagName("km");

			String kmStr = kmList.item(0).getFirstChild().getNodeValue();
			int km = Integer.parseInt(kmStr);
			b.setKm(km);

			NodeList weightList = bikeElement.getElementsByTagName("weight");
			String weightStr = weightList.item(0).getFirstChild().getNodeValue();
			long weight = Long.parseLong(weightStr);
			b.setWeight(weight);

			myBikeList.addBike(b);

		}
		return myBikeList;
	}
}
