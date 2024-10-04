package org.example.employtracker.dao.impl;

import org.example.employtracker.dao.IEmployeeDao;
import org.example.employtracker.model.Employee;
import org.example.employtracker.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

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

    @Override
    public void deleteEmployee(int id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Employee employee = session.get(Employee.class, id);
            if (employee != null) {
                session.delete(employee);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public List<Employee> getAllEmployees() {
        Transaction transaction = null;
        List<Employee> employees = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            employees = session.createQuery("FROM Employee", Employee.class).list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return employees;
    }

    @Override
    public void updateEmployee(Employee employee) {
        Transaction transaction = null;

        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(employee);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public Employee selectEmployeeById(int id) {
        Transaction transaction = null;
        Employee employee = null;

        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            employee = session.get(Employee.class, id);
            transaction.commit();
        }catch(Exception e) {
            if(transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public List<Employee> searchEmployees(String query) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        String lowerQuery = query.toLowerCase();
        List<Employee> employees = session.createQuery(
                        "FROM Employee e WHERE "
                                + "LOWER(e.firstName) LIKE :query OR "
                                + "LOWER(e.lastName) LIKE :query OR "
                                + "LOWER(e.email) LIKE :query OR "
                                + "LOWER(e.phone) LIKE :query OR "
                                + "LOWER(e.department) LIKE :query", Employee.class)
                .setParameter("query", "%" + lowerQuery + "%")
                .getResultList();
        session.close();
        return employees;
    }

    @Override
    public List<Employee> getEmployeesByDepartment(String department) {
        Transaction transaction = null;
        List<Employee> employees = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            String hql = "FROM Employee WHERE department = :dept";
            Query<Employee> query = session.createQuery(hql, Employee.class);
            query.setParameter("dept", department);
            employees = query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

        return employees;
    }

    @Override
    public List<String> getDistinctDepartments() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        String hql = "SELECT DISTINCT e.department FROM Employee e";
        Query<String> query = session.createQuery(hql, String.class);
        query.setMaxResults(5); // Limit the results to 5
        List<String> departments = query.getResultList();
        session.close();
        return departments;
    }

}
