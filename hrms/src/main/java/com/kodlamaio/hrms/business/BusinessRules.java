package com.kodlamaio.hrms.business;

import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.core.utilities.results.SuccessResult;

public class BusinessRules { //injection
	public static Result run(Result... logics){
        for(Result logic:logics){
            if(!logic.isSuccess()){
                return logic;
            }
        }
        return new SuccessResult();
    }
	

}
