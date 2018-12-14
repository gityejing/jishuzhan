package in.codelearn.common;

import in.codelearn.entity.Employee;
import in.codelearn.persistence.HibernateUtil;
import org.hibernate.classic.Session;

public class App {
    public static void main(String[] args) {
        System.out.println("Hibernate Example XML");
        // 1，获取数据库会话
        Session session = HibernateUtil.getSessionFactory().openSession();
        // 2.开启事务
        session.beginTransaction();
        Employee emp = new Employee();

        emp.setEmployeeCode("234");
        emp.setEmployeeName("小泽玛利亚");
        // 3，保存
        session.save(emp);
        // 4，提交事务
        session.getTransaction().commit();
    }



}
