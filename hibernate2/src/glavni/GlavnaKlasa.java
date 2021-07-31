package glavni;

import java.util.ArrayList;
import java.util.List;

import dao.CrudMethodsLogic;
import model.Adresa;
import model.Card;
import model.Contact;
import model.User;
import model.UserType;

public class GlavnaKlasa {

	public static void main(String[] args) {
		
		CrudMethodsLogic logic = new CrudMethodsLogic();
		
		/*
		 * Card card = new Card(); 
		 * card.setPan("7823 7777 2222 1234");
		 * card.setCardType("Visa");
		 */
		
		/*
		 * Card card = logic.vratiKarticuPoId(5); 
		 * try { 
		 * System.out.println("Pan : " + card.getPan()); 
		 * System.out.println("Tip: " + card.getCardType()); 
		 * }catch(Exception e) { 
		 * 	System.out.println("Nepostojeci id..."); 
		 * }
		 */
		
		//logic.updateujPan("7823 9999 1111 0000", "3");
		//logic.deleteCard("4");
		/*Contact c1 = new Contact();
			c1.setBrojTelefona("064 111 222");
			c1.setEmail("ruza1@gmail.com");
		Contact c2 = new Contact();
			c2.setBrojTelefona("063 555 666");
			c2.setEmail("ruza2@gmail.com");
		Contact c3 = new Contact();
			c3.setBrojTelefona("061 999 888");
			c3.setEmail("ruza3@gmail.com");
		
		List<Contact> ruziniKontakti = new ArrayList<>();
			ruziniKontakti.add(c1);
			ruziniKontakti.add(c2);
			ruziniKontakti.add(c3);
		
		Adresa a = new Adresa();
			a.setDrzava("Srbija");
			a.setGrad("Bajina Basta");
			a.setUlica("Marsala Tita");
			
		UserType userType = UserType.STANDARD_USER;
		
		User user = new User();
			user.setUserName("Ruza");
			user.setAdresa(a);
			user.setUserType(userType);
			user.setKontakti(ruziniKontakti);
			
		logic.upisiUseraUbazu(user);*/
		
		
		//preuzimamo usera
		
		User user = logic.vratiUseraPoId(3);
			String imeUsera = user.getUserName();
			System.out.println("Ime: " + imeUsera);
			String drzava = user.getAdresa().getDrzava();
			System.out.println("Drzava: " + drzava);
			UserType tipUsera = user.getUserType();
			System.out.println("Tip usera: " + tipUsera);
			List<Contact> listaKontakata = user.getKontakti();
			for(Contact contact: listaKontakata) {
				System.out.println("Mob: " + contact.getBrojTelefona());
				System.out.println("Email: " + contact.getEmail());
			}

	}

}
