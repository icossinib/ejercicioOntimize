package com.imatia.api.core.service;

import com.ontimize.db.EntityResult;

import java.util.List;
import java.util.Map;

public interface IMasterService {

    public EntityResult educationQuery(Map<String, Object> keyMap, List<String> attrList);
}
