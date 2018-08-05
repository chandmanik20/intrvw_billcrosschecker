package com.validator;

import com.models.CmfoodchainType;
import com.models.MatchModel;

/**
 * This interface is to find match and mismatch the calculation.
 * 
 * @author User
 *
 */
public interface Validator {
	MatchModel match(CmfoodchainType cmfoodchainType);
}
