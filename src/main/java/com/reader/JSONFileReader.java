package com.reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.models.CmfoodchainType;
import com.models.branchType;
import com.models.orderdetailType;

class JSONFileReader implements FileReader {

	/**
	 * This will parse the JSON file and return specific object.
	 */
	public CmfoodchainType readFile(File file) {
		 JSONParser parser = new JSONParser();

	        try {     
	            Object obj = parser.parse(new java.io.FileReader(file));

	            JSONObject jsonObject =  (JSONObject) obj;
	            JSONObject cmfoodchainObj = (JSONObject) jsonObject.get("cmfoodchain");
	            JSONObject branchObj = (JSONObject) cmfoodchainObj.get("branch");
	            String location = (String) branchObj.get("location");
	            String totalcollection = (String) branchObj.get("totalcollection");
	            String locationid = (String) branchObj.get("locationid");
	            
	            System.out.println("location:"+ location+"; totalcollection:"+totalcollection+"; locationid:"+locationid);
	            branchType branchType1 = new branchType(location, Float.parseFloat(totalcollection), locationid);
	            
	            //TODO order details
	            JSONObject ordersObj = (JSONObject) cmfoodchainObj.get("orders");
	            JSONArray orderDetailArray = (JSONArray) ordersObj.get("orderdetail");
	            List<orderdetailType> orderDetails = new ArrayList<orderdetailType>(); 
	            for(int i = 0; i < orderDetailArray.size(); i++){
	                Long orderid = (Long)((JSONObject)orderDetailArray.get(i)).get("orderid");
	                String billamount = (String)((JSONObject)orderDetailArray.get(i)).get("billamount");
	                
	                System.out.println("orderid : " + orderid+"; billamount:" + billamount);
	                orderdetailType orderdetailType1 = new orderdetailType(orderid, Float.parseFloat(billamount));
					
					orderDetails.add(orderdetailType1);
	            }

	            CmfoodchainType cmfoodchainType = new CmfoodchainType(branchType1, orderDetails);
				return cmfoodchainType;
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
	        
		return null;
	}
}
