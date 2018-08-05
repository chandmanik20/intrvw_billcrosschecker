package com.processor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.models.CmfoodchainType;
import com.models.MatchModel;
import com.validator.Validator;

/**
 * Processor iterate all models and apply validation rule to separate into two list - matched and unmatched.
 * 
 * @author User
 *
 */
public class Processor {
	private List<CmfoodchainType> collections;
	private Validator validator;
	List<MatchModel> matchModels = new ArrayList<MatchModel>();
	List<MatchModel> mismatchModels = new ArrayList<MatchModel>();
	
	public Processor(List<CmfoodchainType> collections, Validator validator) {
		this.collections = collections;
		this.validator = validator;
	}
	
	/**
	 * process to create match and unmatched list.
	 */
	public void process(){
		Iterator<CmfoodchainType> iterator = collections.iterator();
		
		while (iterator.hasNext()) {
			CmfoodchainType cmfoodchainType = (CmfoodchainType) iterator.next();
			MatchModel matchModel = validator.match(cmfoodchainType);
			if(matchModel.isMatched()){
				matchModels.add(matchModel);
			} else {
				mismatchModels.add(matchModel);
			}
		}
	}
	
	public List<MatchModel> getMatchModels() {
		return matchModels;
	}

	public List<MatchModel> getMismatchModels() {
		return mismatchModels;
	}


}
