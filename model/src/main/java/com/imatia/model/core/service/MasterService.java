package com.imatia.model.core.service;

import com.imatia.api.core.service.IMasterService;
import com.imatia.model.core.dao.EducationDao;
import com.ontimize.db.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;
import com.ontimize.jee.server.dao.DefaultOntimizeDaoHelper;
import com.ontimize.jee.server.dao.IOntimizeDaoSupport;

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

	private IOntimizeDaoSupport experiencelevelDao;

	private IOntimizeDaoSupport originDao;
	private IOntimizeDaoSupport profileDao;
	private IOntimizeDaoSupport statusDao;


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
    public EntityResult educationDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException {
        return this.daoHelper.delete(this.educationDao, keyMap);
    }

	@Override
	public EntityResult educationUpdate(Map<String, Object> attrMap) throws OntimizeJEERuntimeException {
		return this.daoHelper.update(this.educationDao, attrMap, attrMap);
	}

	@Override
	public EntityResult experienceLevelQuery(Map<String, Object> keyMap, List<String> attrList)
			throws OntimizeJEERuntimeException {
		return this.daoHelper.query(this.experiencelevelDao,keyMap, attrList);
	}

	@Override
	public EntityResult experienceLevelInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException {
				
		return this.daoHelper.insert(this.experiencelevelDao, attrMap);
	}

	@Override
	public EntityResult experienceLevelUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap)
			throws OntimizeJEERuntimeException {
		
		return this.daoHelper.update(this.experiencelevelDao, attrMap, attrMap);
	}

	@Override
	public EntityResult experienceLevelDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException {
		
		return this.daoHelper.delete(this.experiencelevelDao, keyMap);
	}

	@Override
	public EntityResult originQuery(Map<String, Object> keyMap, List<String> attrList)
			throws OntimizeJEERuntimeException {
		
		return this.daoHelper.query(this.originDao, keyMap, attrList);
	}

	@Override
	public EntityResult originInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException {
		
		return this.daoHelper.insert(originDao, attrMap);
	}

	@Override
	public EntityResult originUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap)
			throws OntimizeJEERuntimeException {
		
		return this.daoHelper.update(originDao, attrMap, keyMap);
	}

	@Override
	public EntityResult originDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException {
		
		return this.daoHelper.delete(originDao, keyMap);
	}

	@Override
	public EntityResult profileQuery(Map<String, Object> keyMap, List<String> attrList)
			throws OntimizeJEERuntimeException {
		
		
		return this.daoHelper.query(profileDao, keyMap, attrList);
	}

	@Override
	public EntityResult profileInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException {
		
		return this.daoHelper.insert(profileDao, attrMap);
	}

	@Override
	public EntityResult profileUdate(Map<String, Object> attrMap, Map<String, Object> keyMap)
			throws OntimizeJEERuntimeException {
		return this.daoHelper.update(profileDao, attrMap, keyMap);
	}

	@Override
	public EntityResult profileDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException {
		return this.daoHelper.delete(profileDao, keyMap);
	}

	@Override
	public EntityResult statusQuery(Map<String, Object> keyMap, List<String> attrList)
			throws OntimizeJEERuntimeException {
		
		return this.daoHelper.query(statusDao, keyMap, attrList);
	}

	@Override
	public EntityResult statusInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException {
		
		return this.daoHelper.insert(statusDao, attrMap);
	}

	@Override
	public EntityResult statusUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap)
			throws OntimizeJEERuntimeException {
		
		return this.daoHelper.update(statusDao, attrMap, keyMap);
	}

	@Override
	public EntityResult statusDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException {
		
		return this.daoHelper.delete(statusDao, keyMap);
	}
}
