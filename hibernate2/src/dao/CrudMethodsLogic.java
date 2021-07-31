package dao;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import glavni.HibernateUtil;
import model.Card;
import model.User;

public class CrudMethodsLogic {
	
	// Session factory object
	private SessionFactory sf = HibernateUtil.getSessionFactory();
	
	
	public void upisiKarticuUbazu(Card card) {
		
		//otvaram sesiju
		Session session = sf.openSession();
			//zapocinjem transakciju
			session.beginTransaction();		
			try {
				session.persist(card);
				//transakcija ok
				session.getTransaction().commit();
			} catch (Exception e) {
				//transakcija nije dobro zavrsila
				session.getTransaction().rollback();
			}
		//zatvaram sesiju
		session.close();
		
	}
	
	public Card vratiKarticuPoId(int id) {
		
		Card card = null;
		
		Session session = sf.openSession();
			session.beginTransaction();		
			try {
				// ovde preuzimam objekat iz baze
				card = session.get(Card.class, id);
				System.out.println("Preuzimam karticu ciji je id " + id);
				session.getTransaction().commit();
			} catch (Exception e) {
				session.getTransaction().rollback();
			}
		session.close();
		return card;
	}
	
	
	public void updateujPan(String pan, String id) {
		
		Session session = sf.openSession();
			session.beginTransaction();		
			try {
				//izvlacim objekat koji zelim da update-ujem
				Card card = session.get(Card.class, Integer.parseInt(id));
				//setujem novu vrednost pan-a
				card.setPan(pan);
				//update
				session.update(card);
				// session.merge(card) je metoda za update takodje
				System.out.println("Updateujem pan...");
				session.getTransaction().commit();
			} catch (Exception e) {
				session.getTransaction().rollback();
			}
		session.close();
	}
	
	
	public void deleteCard(String id) {
		Session session = sf.openSession();
			session.beginTransaction();		
			try {
				//izvlacim objekat koji zelim da delete-ujem
				Card card = session.get(Card.class, Integer.parseInt(id));
				//delete object
				session.delete(card);
				System.out.println("Delete card...");
				session.getTransaction().commit();
			} catch (Exception e) {
				session.getTransaction().rollback();
			}
		session.close();
	}
	
	
	
	public void upisiUseraUbazu(User user) {		
			Session session = sf.openSession();
				session.beginTransaction();		
				try {
					session.save(user);
					session.getTransaction().commit();
				} catch (Exception e) {
					session.getTransaction().rollback();
				}
			session.close();	
	}
	
	public User vratiUseraPoId(int id) {
		
		User user = null;
		
		Session session = sf.openSession();
			session.beginTransaction();		
			try {
				user = session.get(User.class, id);
				//eksplicitno sam mu rekao da ucita i listu kontakata
				//Hibernate.initialize(user.getKontakti());
				//user.getKontakti().size();
				System.out.println("Preuzeo sam usera...");
				session.getTransaction().commit();
			} catch (Exception e) {
				System.out.println("Nisam preuzeo usera!");
				session.getTransaction().rollback();
			}
		session.close();
		
		return user;
	}
	
	
	

}
