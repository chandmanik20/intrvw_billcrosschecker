package com.reader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.models.CmfoodchainType;
import com.models.branchType;
import com.models.orderdetailType;

class XMLFileReader implements FileReader {

	/**
	 * this will read xml file and parse and finally return specific java object.
	 */
	public CmfoodchainType readFile(File file) {
		try {
			
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(file);

			doc.getDocumentElement().normalize();
			
			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

			NodeList branchNodeList = doc.getElementsByTagName("branch");

			System.out.println("----------------------------");
			String location = ((Element)branchNodeList.item(0)).getElementsByTagName("location").item(0).getTextContent();
			String totalCollection = ((Element)branchNodeList.item(0)).getElementsByTagName("totalcollection").item(0).getTextContent();
			String locationid = ((Element)branchNodeList.item(0)).getElementsByTagName("locationid").item(0).getTextContent();
			
			
			
			System.out.println("Location:" + location + "; totalCollection:"+totalCollection+"; locationid:"+locationid);
			
			branchType branchType1 = new branchType(location, Float.parseFloat(totalCollection), locationid);
		
			System.out.println("--------------orders--------------");
			NodeList ordersNodeList = doc.getElementsByTagName("orderdetail");
			
			List<orderdetailType> orderDetails = new ArrayList<orderdetailType>(); 
			for (int temp = 0; temp < ordersNodeList.getLength(); temp++) {
				String orderid =((Element)ordersNodeList.item(temp)).getElementsByTagName("orderid").item(0).getTextContent();
				String billamount =((Element)ordersNodeList.item(temp)).getElementsByTagName("billamount").item(0).getTextContent();
				System.out.println("orderid : " + orderid);
				System.out.println("billamount : " + billamount);
				orderdetailType orderdetailType1 = new orderdetailType(Long.parseLong(orderid), Float.parseFloat(billamount));
				
				orderDetails.add(orderdetailType1);
			}
			
			CmfoodchainType cmfoodchainType = new CmfoodchainType(branchType1, orderDetails);
			return cmfoodchainType;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
