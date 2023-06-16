import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Scanner;
import javax.swing.*;

import java.util.List;

public class Operacje {
	public static void main (String[] args)  {
		
		PersonManager Pm = new PersonManager();
		BookManager Bm = new BookManager();
		
		MyFrame frame = new MyFrame();
		
		frame.create_account.addActionListener(e ->{
			JTextField NewLogin = new JTextField(20);
			JPasswordField NewPassword = new JPasswordField(20);
			
			JPanel account_panel = new JPanel();
			account_panel.add(new JLabel("login:"));
			account_panel.add(NewLogin);
			account_panel.add(new JLabel("haslo:"));
			account_panel.add(NewPassword);
			
			int option = JOptionPane.showConfirmDialog(frame, account_panel,"Stworz konto",JOptionPane.OK_CANCEL_OPTION,JOptionPane.INFORMATION_MESSAGE);
			if(option==JOptionPane.OK_OPTION) {
				String login = NewLogin.getText();
				String haslo = new String(NewPassword.getPassword());
				User NewUser = new User(haslo, login, 0);
				NewUser.setLogin(login);
				NewUser.setPassword(haslo);
				NewUser.setRole(0);
				try {
					Pm.addUser(NewUser);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
//		frame.log_in.addActionListener(e ->{
//			try {
//				List<User> UL = Pm.readUsers();
//			} catch (Exception e1) {
//				e1.printStackTrace();
//			}
//			Boolean smh = false;
//			do {
//				System.out.println("Podaj login");
//				String Login = scan.nextLine();
//				System.out.println("Podaj haslo");
//				String Pass = scan.nextLine();
//				Boolean correct = false;
//				do {
//					try {
//						for (User U : Pm.readUsers()) {
//							if (U.getLogin().equals(Login) && U.getPassword().equals(Pass)) {
//								System.out.println("Zalogowano :D");
//								correct = true;
//								logged = U;
//								Role = U.getRole();
//								System.out.println(Role);
//								break;
//							}
//
//							else{
//								System.out.println("bladne dane");
//								break;
//							}
//						}
//						break;
//					} catch (Exception e) {
//						e.printStackTrace();
//					}
//				} while (correct == false);
//				if (logged != null) {
//					smh = true;
//				}
//			} while (smh == false);
//			Boolean doLogout = false;
//			if (Role == 1) {
//				do {
//					System.out.println("[1] lista uzytkownikow:");
//					System.out.println("[2] Usun uzytkownika:");
//					System.out.println("[3] Dodaj ksiazke:");
//					System.out.println("[4] Usun Ksiazke:");
//					System.out.println("[5] Edytuj Ksiazke:");
//					System.out.println("[6] Wyloguj:");
//					String action = scan.nextLine();
//					if ("1".equals(action)) {
//						try {
//							for (User U : Pm.readUsers()) {
//								System.out.println("login: " + U.getLogin());
//							}
//						} catch (Exception e) {
//							e.printStackTrace();
//						}
//					}
//					if ("2".equals(action)) {
//						System.out.println("Podaj login:");
//						String login = scan.next();
//						try {
//							if (!Pm.removeUser(login))
//								System.out.println("uzytkownika nie ma na liscie");
//							else
//								System.out.println("Usunieto uzytkownika z listy");
//						} catch (Exception e) {
//							e.printStackTrace();
//						}
//					}
//					if ("3".equals(action)) {
//						System.out.println("Podaj tytu�:");
//						String NewTitle = scan.nextLine();
//						System.out.println("Podaj autora:");
//						String NewAuthor = scan.nextLine();
//						System.out.println("Podaj gatunek:");
//						String NewGenre = scan.nextLine();
//						if (scan.hasNextLine())
//							;
//						try {
//							Bm.addBook(NewTitle, NewAuthor, NewGenre);
//						} catch (Exception e) {
//							e.printStackTrace();
//						}
//					}
//					if ("4".equals(action)) {
//						System.out.println("Podaj ksiazke do usuniecia:");
//						String Bookremove = scan.nextLine();
//						if (scan.hasNextLine())
//							scan.nextLine();
//						try {
//							Bm.removeBook(Bookremove);
//						} catch (Exception e) {
//							e.printStackTrace();
//						}
//					}
//					if ("6".equals(action)) {
//						doLogout = true;
//						System.out.println("wyjecie.");
//						scan.close();
//						break;
//
//					}
//				} while (doLogout == false);
//			}
//
//			if (Role == 0) {
//				do {
//					System.out.println("[1] lista ksiezek:");
//					System.out.println("[2] wyszukaj po gatunku:");
//					System.out.println("[3] wyszukaj:");
//					System.out.println("[4] Wyloguj");
//					String action = scan.nextLine();
//					if ("1".equals(action)) {
//						try {
//							for (Book B : Bm.readBooks()) {
//								System.out.println("Book: " + B.getTitle());
//							}
//						} catch (Exception e) {
//							e.printStackTrace();
//						}
//					}
//					if ("2".equals(action)) {
//						System.out.println("[1] akcja:");
//						System.out.println("[2] thriller:");
//						System.out.println("[3] dramat:");
//						System.out.println("[4] horror:");
//						System.out.println("[5] fantasy:");
//						String gn = scan.nextLine();
//						if ("1".contentEquals(gn)) {
//
//							try {
//								for (Book B : Bm.readBooks()) {
//									System.out.println("ksiazki z gatunku:" + B.getGenre().contains("akcja"));
//									break;
//								}
//							} catch (Exception e) {
//								e.printStackTrace();
//							}
//						}
//						if ("5".contentEquals(gn)) {
//
//							try {
//								for (Book B : Bm.readBooks()) {
//									System.out.println(
//											"ksiazki z gatunku:" + B.getTitle() + B.getGenre().contains("fantasy"));
//									break;
//								}
//							} catch (Exception e) {
//								e.printStackTrace();
//							}
//						}
//					}
//					if ("3".contentEquals(action)) {
//						System.out.println("wyszukaj ksiazke:");
//						String mytitle = scan.nextLine();
//						try {
//							for (Book B : Bm.readBooks()) {
//								if(B.getTitle().contains(mytitle) == true){
//									System.out.println("mamy taką książkę");
//								}
//								else {
//									System.out.println("nie mamy takiej książki");
//								}
//								break;
//							}
//						} catch (Exception e) {
//							e.printStackTrace();
//						}
//
//					}
//			
//				}}}); 
		frame.exit.addActionListener(e ->{
			System.exit(0);
		});
	}
}