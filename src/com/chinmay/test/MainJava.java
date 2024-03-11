package com.chinmay.test;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.chinmay.entity.Student;
import com.mysql.cj.Session;




public class MainJava {

	public static void addObject(org.hibernate.Session session,SessionFactory sessionFactory, Transaction transaction) {
		try {
		session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        
		Student sd= new Student();
		sd.setRegno(45);
		sd.setName("Chinmayyy");
		sd.setEmail("chinmay@gmail.com");
		sd.setMarks(100);
		
		 session.save(sd);

         // Commit the transaction
         transaction.commit();
         System.out.println("Product saved successfully.");

     } catch (Exception e) {
         if (transaction != null) {
             transaction.rollback();
         }
         e.printStackTrace();
     } finally {
         if (session != null) {
             session.close();
         }
         if (sessionFactory != null) {
             sessionFactory.close();
         }
     }
		
		
	}
	
	public static void updateMarks(org.hibernate.Session session,SessionFactory sessionFactory, Transaction transaction) {
		try {
			 session = sessionFactory.openSession();
	            transaction = session.beginTransaction();
			System.out.println("The REg  No of student to add marks : 44");

		Student student = session.get(Student.class, 45); // Assuming 123 is the regNo of the student you want to update
        if (student != null) {
            // Update marks field
            student.setMarks(95);
            session.update(student); // Update the object in the database
            System.out.println("Student marks updated successfully.");
        } else {
            System.out.println("Student not found!");
        }

        transaction.commit();
    } catch (Exception e) {
        if (transaction != null) {
            transaction.rollback();
        }
        e.printStackTrace();
    } finally {
        if (session != null) {
            session.close();
        }
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
	}
	
	public static void fetchObject(org.hibernate.Session session,SessionFactory sessionFactory, Transaction transaction) {
		try {
            
            session = sessionFactory.openSession();
            
            transaction = session.beginTransaction();
       
            // Fetching object by primary key (id)
            Student student = session.get(Student.class, 45);
            
            if (student != null) {
                System.out.println("Fetched Student: " + ", Reg No: " + student.getRegno() + student.getName() + ", Marks: " + student.getMarks() + ", Email: " + student.getEmail() );
            } else {
                System.out.println("Student not found!");
            }

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
            if (sessionFactory != null) {
                sessionFactory.close();
            }
        }
	}
	
	public static void deleteObject(org.hibernate.Session session,SessionFactory sessionFactory, Transaction transaction) {
		try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            Student student = session.get(Student.class, 45);
            if (student != null) {
                session.delete(student);
                System.out.println("Student with id 44 deleted successfully.");
            } else {
                System.out.println("Student not found, deletion failed!");
            }

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
            if (sessionFactory != null) {
                sessionFactory.close();
            }
        }
    }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration cfg = null;
		SessionFactory sessionFactory = null;
		Student sd = null;
		org.hibernate.Session session = null;
		Transaction tx = null;
		cfg = new Configuration();
		cfg.configure("com/chinmay/cfgs/hibernate.cfg.xml");
		
		sessionFactory = cfg.buildSessionFactory();
		

		// addObject(sd);                    // performed this before
		// updating new marks
		// fetching data for that particular student
//		fetchObject(session, sessionFactory, tx);
		
//		// updating marks
//		
//		addObject(session, sessionFactory, tx);
		
//		updateMarks(session, sessionFactory, tx);
//	
//	
//		// fetching data for that particular student to check update
//		
//		fetchObject(session, sessionFactory, tx);
//		
//		// deleting object finally
//		
		deleteObject(session, sessionFactory, tx);
			

	}

}
