package com.imatia.ws.core.rest;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ontimize.db.EntityResult;
import com.ontimize.db.SQLStatementBuilder;
import com.ontimize.db.SQLStatementBuilder.BasicExpression;
import com.ontimize.db.SQLStatementBuilder.BasicOperator;
import com.ontimize.db.SQLStatementBuilder.BasicField;
import com.imatia.api.core.service.IOfferService;
import com.imatia.model.core.dao.OfferDao;
import com.ontimize.jee.server.rest.ORestController;

@RestController
@RequestMapping("/offers")
@ComponentScan(basePackageClasses = { com.imatia.api.core.service.IOfferService.class })

public class OfferRestController extends ORestController<IOfferService> {
	
	@Autowired private IOfferService offerService;

	@Override
	public IOfferService getService() {
		return this.offerService;
	}
	
	@RequestMapping(value = "currentOffers/search", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	 public EntityResult currentOffersSearch(@RequestBody Map<String, Object> req) {
	  try {
	   List<String> columns = (List<String>) req.get("columns");
	   Map<String, Object> key = new HashMap<String, Object>();
	   key.put(SQLStatementBuilder.ExtendedSQLConditionValuesProcessor.EXPRESSION_KEY,
	     searchBetween(OfferDao.ATTR_START_DATE));
	   return offerService.offerQuery(key, columns);
	  } catch (Exception e) {
	   e.printStackTrace();
	   EntityResult res = new EntityResult();
	   res.setCode(EntityResult.OPERATION_WRONG);
	   return res;
	  }
	 }

	 @RequestMapping(value = "yearOffers/search", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	 public EntityResult yearOffersSearch(@RequestBody Map<String, Object> req) {
	  try {
	   List<String> columns = (List<String>) req.get("columns");
	   Map<String, Object> filter = (Map<String, Object>) req.get("filter");
	   int year = (int) filter.get("YEAR");
	   Map<String, Object> key = new HashMap<String, Object>();
	   key.put(SQLStatementBuilder.ExtendedSQLConditionValuesProcessor.EXPRESSION_KEY,
	     searchBetweenWithYear(OfferDao.ATTR_START_DATE, year));
	   return offerService.offerQuery(key, columns);
	  } catch (Exception e) {
	   e.printStackTrace();
	   EntityResult res = new EntityResult();
	   res.setCode(EntityResult.OPERATION_WRONG);
	   return res;
	  }
	 }

	 private BasicExpression searchBetween(String param) {

	  Calendar cal = Calendar.getInstance();
	  int currentYear = cal.get(Calendar.YEAR);

	  return this.searchBetweenWithYear(param, currentYear);
	 }

	 private BasicExpression searchBetweenWithYear(String param, int year) {

	  Calendar cal = Calendar.getInstance();
	  cal.set(year, 0, 1);
	  Date startDate = cal.getTime();
	  cal.set(year + 1, 0, 1);
	  Date endDate = cal.getTime();

	  BasicField field = new BasicField(param);
	  BasicExpression bexp1 = new BasicExpression(field, BasicOperator.MORE_EQUAL_OP, startDate);
	  BasicExpression bexp2 = new BasicExpression(field, BasicOperator.LESS_OP, endDate);
	  return new BasicExpression(bexp1, BasicOperator.AND_OP, bexp2);
	 }
}
