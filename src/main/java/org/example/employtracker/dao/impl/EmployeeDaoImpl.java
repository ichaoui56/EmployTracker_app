package org.example.employtracker.dao.impl;

import org.example.employtracker.dao.IEmployeeDao;
import org.example.employtracker.model.Employee;
import org.example.employtracker.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class EmployeeDaoImpl implements IEmployeeDao {

    @Override
    public void insertEmployee(Employee employee) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(employee);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
