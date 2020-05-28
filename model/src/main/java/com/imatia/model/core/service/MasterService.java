package com.imatia.model.core.service;

import com.imatia.api.core.service.IMasterService;
import com.imatia.model.core.dao.EducationDao;
import com.ontimize.db.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;
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
    public EntityResult educationQuery(Map<String, Object> keyMap, List<String> attrList)
            throws OntimizeJEERuntimeException {
        return this.daoHelper.query(this.educationDao, keyMap, attrList);
    }

    @Override
    public EntityResult educationInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException {
        return this.daoHelper.insert(this.educationDao, attrMap);
    }

    @Override
    public EntityResult educationUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap)
            throws OntimizeJEERuntimeException {
        return this.daoHelper.update(this.educationDao, attrMap, keyMap);
    }

    @Override
    public EntityResult educationDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException {
        return this.daoHelper.delete(this.educationDao, keyMap);
    }
}
