package com.test.hibernateTest.hibernateTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.Id;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.test.hibernateTest.entity.Company;
import com.test.hibernateTest.entity.Person;


/**
 * Hello world!
 *
 */
public class App {
   /* public static void main( String[] args ) {
        System.out.println( "Hello World!" );
    
    }*/
    
    @Test
    public void Test1() {
    	System.out.println("====Test1=====mysql===");
    	String driver = "com.mysql.jdbc.Driver";
    	String url = "jdbc:mysql://localhost:3306/mytest?characterEncoding=UTF-8";
    	try {
			Class.forName(driver);
			try {
				Connection conn = DriverManager.getConnection(url,"root","root");
				PreparedStatement pre = conn.prepareStatement("select *from pErson");
				ResultSet rs = pre.executeQuery();
				while (rs.next()) {
					System.out.println(rs.getString("id") + '-' + rs.getString(2));
				}
			} catch (SQLException e) {
				System.out.println("error1");
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			System.out.println("error0" + e);
			e.printStackTrace();
		}
    }
    
    @Test
    public void Test2() {
    	System.out.println("======Test2====hibernate===Person====xxx.hbm.xml====");
    	
    	//Configuration cfg = new Configuration().configure();//默认加载src下的hibernate.cfg.xml文件
    	Configuration cfg = new Configuration().configure("/com/test/hibernateTest/resouce/hibernate.cfg.xml");// 否则写路径
    	
    	// 添加映射文件  则在配置文件中不用添加映射
    	//cfg.addResource("com/test/hibernateTest/entity/Person.hbm.xml");// 不能加/
    	
    	SessionFactory factory = cfg.buildSessionFactory();
    	Session session = null;
    	try {
        	session = factory.openSession();
        	
        	Query query = session.createQuery("select p from Person p where id=:id");// can't select Person
        	query.setParameter("id", 1);
        	
        	List<Person> list = query.list();  
        	System.out.println(list.get(0).getId() + "-" + list.get(0).getName());

        	Person person = (Person) query.uniqueResult();
        	System.out.println(person.getId() + "-" + person.getName());
    	} catch(Exception e) {
    		System.out.println(e.getMessage());
    	} finally {
			if (session != null) {
				if (session.isOpen()) {
					session.close();
				}
			}
		}

    }
    
    @Test
    public void Test3() {
    	System.out.println("======Test3====hibernate===Company====@Entity====");
    	
    	//Configuration cfg = new Configuration().configure();//默认加载src下的hibernate.cfg.xml文件
    	Configuration cfg = new Configuration().configure("/com/test/hibernateTest/resouce/hibernate.cfg.xml");// 否则写路径
    	
    	SessionFactory factory = cfg.buildSessionFactory();
    	Session session = null;
    	try {
        	session = factory.openSession();
        	
        	Query query = session.createQuery("select c from Company c where id=:id");// can't select Person
        	query.setParameter("id", 1);
        	
        	List<Company> list = query.list();  
        	System.out.println(list.get(0).getId() + "-" + list.get(0).getName());

        	Company company = (Company) query.uniqueResult();
        	System.out.println(company.getId() + "-" + company.getName());
    	} catch(Exception e) {
    		System.out.println(e + "------over--------");
    		System.out.println(e.getMessage() + "------over--------");
    	} finally {
			if (session != null) {
				if (session.isOpen()) {
					session.close();
				}
			}
		}
    }
    
    @Test
    public void Test4() {
    	System.out.println("======Test3====hibernate===Company====@Entity====");
    	
    	//Configuration cfg = new Configuration().configure();//默认加载src下的hibernate.cfg.xml文件
    	Configuration cfg = new Configuration().configure("/com/test/hibernateTest/resouce/hibernateTest.cfg.xml");// 否则写路径
    	
    	SessionFactory factory = cfg.buildSessionFactory();
    	Session session = null;
    	try {
        	session = factory.openSession();
        	
        	Query query = session.createQuery("select c from Company c where id=:id");// can't select Person
        	query.setParameter("id", 1);
        	
        	List<Company> list = query.list();  
        	System.out.println(list.get(0).getId() + "-" + list.get(0).getName());

        	Company company = (Company) query.uniqueResult();
        	System.out.println(company.getId() + "-" + company.getName());
    	} catch(Exception e) {
    		System.out.println(e + "------over--------");
    		System.out.println(e.getMessage() + "------over--------");
    	} finally {
			if (session != null) {
				if (session.isOpen()) {
					session.close();
				}
			}
		}
    }
    
}
