package com.imatia.model.core.service;

import com.imatia.api.core.service.IMasterService;
import com.imatia.model.core.dao.EducationDao;
import com.ontimize.db.EntityResult;
import com.ontimize.jee.server.dao.DefaultOntimizeDaoHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("MasterService")
@Lazy
public class MasterService implements IMasterService {

    @Autowired
    private EducationDao educationDao;

    @Autowired
    private DefaultOntimizeDaoHelper daoHelper;

    @Override
    public EntityResult educationQuery(Map<String, Object> keyMap, List<String> attrList) {
        return this.daoHelper.query(educationDao, keyMap, attrList);
    }
}
