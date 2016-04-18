package com.testing.pdev.utils;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author shashantp
 *
 */
public class GoogApiUtil {

	static Logger log = LoggerFactory.getLogger(GoogApiUtil.class);
	private static final String COMMA = ",";
	
	/*public static HomeAddress getProperAddress(HomeAddress address){
		
		StringBuffer finalAddress = new StringBuffer();
		
		if(StringUtils.isNotEmpty(address.getAddress1())){
			finalAddress.append(address.getAddress1());
			finalAddress.append(COMMA);
		}
		if(StringUtils.isNotEmpty(address.getAddress2())){
			finalAddress.append(address.getAddress2());
			finalAddress.append(COMMA);
		}
		if(StringUtils.isNotEmpty(address.getAddress3())){
			finalAddress.append(address.getAddress3());
			finalAddress.append(COMMA);
		}
		if(StringUtils.isNotEmpty(address.getAddress4())){
			finalAddress.append(address.getAddress1());
			finalAddress.append(COMMA);
		}
		if(StringUtils.isNotEmpty(address.getCity())){
			finalAddress.append(address.getCity());
			finalAddress.append(COMMA);
		}
		if(StringUtils.isNotEmpty(address.getCounty())){
			finalAddress.append(address.getCounty());
			finalAddress.append(COMMA);
		}
		if(StringUtils.isNotEmpty(address.getState())){
			finalAddress.append(address.getState());
			finalAddress.append(COMMA);
		}
		if(StringUtils.isNotEmpty(address.getPostal())){
			finalAddress.append(address.getPostal());
		}
		
		log.info("....Final address...."+ finalAddress);
		address.setFinalAddress(finalAddress.toString());
		
		return address; 
	}*/
}
