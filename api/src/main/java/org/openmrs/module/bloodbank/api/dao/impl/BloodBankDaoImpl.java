package org.openmrs.module.bloodbank.api.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.openmrs.module.bloodbank.api.dao.BloodBankDao;

public class BloodBankDaoImpl implements BloodBankDao {

    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

	/* public Item getItemByUuid(String uuid) {
	     return (Item) getSession().createCriteria(Item.class).add(Restrictions.eq("uuid", uuid)).uniqueResult();
	 }

	 public Item saveItem(Item item) {
	     getSession().saveOrUpdate(item);
	     return item;
	 }*/
}
