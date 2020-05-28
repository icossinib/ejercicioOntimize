package com.imatia.api.core.service;

import com.ontimize.db.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;

import java.util.List;
import java.util.Map;

public interface IMasterService {

    public EntityResult educationQuery(Map<String, Object> keyMap, List<String> attrList) throws OntimizeJEERuntimeException;
    public EntityResult educationInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException;
    public EntityResult educationUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap) throws OntimizeJEERuntimeException;
    public EntityResult educationDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException;
}
