package com.imatia.model.core.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imatia.api.core.service.ICandidateService;
import com.imatia.model.core.dao.CandidateDao;
import com.imatia.model.core.dao.EducationDao;
import com.imatia.model.core.dao.ExperienceLevelDao;
import com.imatia.model.core.dao.OriginDao;
import com.imatia.model.core.dao.ProfileDao;
import com.imatia.model.core.dao.StatusDao;
import com.ontimize.db.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;
import com.ontimize.jee.server.dao.DefaultOntimizeDaoHelper;

@Service("CandidateService")
@Lazy
public class CandidateService implements ICandidateService {

    @Autowired private CandidateDao candidateDao;
    @Autowired private DefaultOntimizeDaoHelper daoHelper;
/**
    Almacena el servicio maestro. Cuando lo marque con la notación @Autowired, se vincula automáticamente sin usar ningún setter
 */
     @Autowired
     private MasterService masterService;

    @Override
    public EntityResult candidateQuery(Map<String, Object> keyMap, List<String> attrList)
            throws OntimizeJEERuntimeException {
        return this.daoHelper.query(this.candidateDao, keyMap, attrList);
    }

    /**
    * Este método agrega un nuevo candidato. Elimina de los parámetros esos elementos.
       * no pertenecen directamente a la mesa de candidatos en caso de que sean de la
       * {@link String} tipo. Busque el identificador de estos datos en caso de que
       * existe o los agrega a las tablas correspondientes, y los asocia con el
       * identificador correcto. Luego agregue estos nuevos elementos a la lista de solicitantes
       * artículos y realiza la inserción de un nuevo candidato
       * *
       * *
       * @param attrMap A {@link Map} que contiene los datos del nuevo candidato a ser
       * insertado.
      */
    @Override
    @Transactional(rollbackFor = Exception.class)
    
    public EntityResult candidateInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException {
    	  Map<String, Object> nonCandidateData = removeNonRelatedData(attrMap, CandidateDao.ATTR_EDUCATION,
    	    CandidateDao.ATTR_EXPERIENCE_LEVEL, CandidateDao.ATTR_ORIGIN, CandidateDao.ATTR_PROFILE,
    	    CandidateDao.ATTR_STATUS);
    	  this.insertNonRelatedData(nonCandidateData);
    	  attrMap.putAll(nonCandidateData);
    	  return this.daoHelper.insert(this.candidateDao, attrMap);
    	 }
    /**
    * Este método actualiza a un candidato. Elimina de los parámetros esos elementos.
    * no pertenecen directamente a la mesa de candidatos en caso de que sean de la
    * {@link String} tipo. Busque el identificador de estos datos en caso de que
    * existe o los agrega a las tablas correspondientes, y los asocia con el
    * identificador correcto. Luego agregue estos nuevos elementos a la lista de solicitantes
    * artículos y realiza la actualización de un candidato
    * *
    * *
    * @param attrMap A {@link Map} que contiene los datos del candidato a ser
    *                actualizado.
    * @param keyMap A {@link Map} que contiene la identificación del candidato a ser
    *                actualizado.
    */

    
    @Override
    @Transactional(rollbackFor = Exception.class)
    public EntityResult candidateUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap)
      throws OntimizeJEERuntimeException {
     Map<String, Object> nonCandidateData = removeNonRelatedData(attrMap, CandidateDao.ATTR_EDUCATION,
       CandidateDao.ATTR_EXPERIENCE_LEVEL, CandidateDao.ATTR_ORIGIN, CandidateDao.ATTR_PROFILE,
       CandidateDao.ATTR_STATUS);
     this.insertNonRelatedData(nonCandidateData);
     attrMap.putAll(nonCandidateData);
     return this.daoHelper.update(this.candidateDao, attrMap, keyMap);
    }

    @Override
    public EntityResult candidateDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException {
        return this.daoHelper.delete(this.candidateDao, keyMap);
    }
    
   /**
    * Elimina de un mapa todas las claves y valores del mapa que coinciden con esos
    * ingresa sus siguientes parámetros y devuelve un mapa con las claves extraídas
    * y valores
    * *
    * @param attrMap A {@link Map} con todas las claves
    * @param attrToExclude Multiple {@link String} que se puede encontrar como clave de
    * {@code attrMap}
    * @return A {@link Map} con todas las claves y valores eliminados de
    * {@code attrMap}
   */

  private Map<String, Object> removeNonRelatedData(Map<String, Object> attrMap, String... attrToExclude) {
   HashMap<String, Object> data = new HashMap<String, Object>();
   for (String attr : attrToExclude) {
    if (attrMap.containsKey(attr) && attrMap.get(attr) instanceof String) {
     data.put(attr, attrMap.remove(attr));
    }
   }
   return data;
  }

  /**
  * Comprueba si los datos almacenados en el mapa pasado por parámetro existen en el
  * tabla de base de datos correspondiente al servicio {@link MasterService}. Si es así,
  * reemplaza el valor con el identificador correspondiente. En caso de que no
  * existe, almacena ese valor y sustituye el valor del elemento en el mapa
  * con su identificador
  * *
  * @param nonCandidateData Valores a insertar en las tablas administradas por
  * {@link MasterService}
  */

private void insertNonRelatedData(Map<String, Object> nonCandidateData) {
 for (Entry<String, Object> entry : nonCandidateData.entrySet()) {
  Map<String, Object> data = new HashMap<String, Object>();
  List<String> attr = new ArrayList<String>();
  EntityResult toret, query;
  switch (entry.getKey()) {
  case CandidateDao.ATTR_EDUCATION:
   data.put(EducationDao.ATTR_DESCRIPTION, entry.getValue());
   attr.add(EducationDao.ATTR_ID);
   query = this.masterService.educationQuery(data, attr);
   if (query.calculateRecordNumber() > 0) {
    entry.setValue(query.getRecordValues(0).get(EducationDao.ATTR_ID));
   } else {
    toret = this.masterService.educationInsert(data);
    entry.setValue(toret.get(EducationDao.ATTR_ID));
   }
   break;
  case CandidateDao.ATTR_EXPERIENCE_LEVEL:
   data.put(ExperienceLevelDao.ATTR_DESCRIPTION, entry.getValue());
   attr.add(ExperienceLevelDao.ATTR_ID);
   query = this.masterService.experienceLevelQuery(data, attr);
   if (query.calculateRecordNumber() > 0) {
    entry.setValue(query.getRecordValues(0).get(ExperienceLevelDao.ATTR_ID));
   } else {
    toret = this.masterService.experienceLevelInsert(data);
    entry.setValue(toret.get(ExperienceLevelDao.ATTR_ID));
   }
   break;
  case CandidateDao.ATTR_ORIGIN:
   data.put(OriginDao.ATTR_DESCRIPTION, entry.getValue());
   attr.add(OriginDao.ATTR_ID);
   query = this.masterService.originQuery(data, attr);
   if (query.calculateRecordNumber() > 0) {
    entry.setValue(query.getRecordValues(0).get(OriginDao.ATTR_ID));
   } else {
    toret = this.masterService.originInsert(data);
    entry.setValue(toret.get(OriginDao.ATTR_ID));
   }
   break;
  case CandidateDao.ATTR_PROFILE:
   data.put(ProfileDao.ATTR_DESCRIPTION, entry.getValue());
   attr.add(ProfileDao.ATTR_ID);
   query = this.masterService.profileQuery(data, attr);
   if (query.calculateRecordNumber() > 0) {
    entry.setValue(query.getRecordValues(0).get(ProfileDao.ATTR_ID));
   } else {
    toret = this.masterService.profileInsert(data);
    entry.setValue(toret.get(ProfileDao.ATTR_ID));
   }
   break;
  case CandidateDao.ATTR_STATUS:
   data.put(StatusDao.ATTR_DESCRIPTION, entry.getValue());
   attr.add(StatusDao.ATTR_ID);
   query = this.masterService.statusQuery(data, attr);
   if (query.calculateRecordNumber() > 0) {
    entry.setValue(query.getRecordValues(0).get(StatusDao.ATTR_ID));
   } else {
    toret = this.masterService.statusInsert(data);
    entry.setValue(toret.get(StatusDao.ATTR_ID));
   }
   break;
  default:
   break;
  }
 }
}


}