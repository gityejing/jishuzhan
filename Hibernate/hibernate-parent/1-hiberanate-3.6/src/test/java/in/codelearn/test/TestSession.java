package in.codelearn.test;

import in.codelearn.entity.Employee;
import in.codelearn.persistence.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class TestSession {
    Session session;
    Transaction transaction;

    @Before
    public void getSession(){
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
    }

    @After
    public void destory(){
        transaction.commit();
        session.flush();
        session.close();
        HibernateUtil.shutdown();
    }

    @Test
    public void testFind(){
        String hql = " from Employee ";
        Query query = session.createQuery(hql);
        List<Employee> employeeList = query.list();
        for (Employee e:employeeList) {
            System.out.println(e);
        }
    }

    @Test
    public void testUpdate(){
        Employee employee = new Employee();
        employee.setEmployeeId(1);
        employee.setEmployeeCode("1234");
        employee.setEmployeeName("蒼井空");
        session.update(employee);
    }

    @Test
    public void testSave(){
        Employee employee = new Employee();
        employee.setEmployeeCode("001");
        employee.setEmployeeName("李雲龍");
        session.save(employee);
    }


    @Test
    public void testDel(){
        String hql = " from Employee where employeeId = ";
        Query query = session.createQuery(hql + 1);
        List<Employee> list = query.list();
        if(list != null && list.size()>0){
            Employee employee = list.get(0);
            session.delete(employee);
        }
    }
}
