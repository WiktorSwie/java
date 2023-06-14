import java.util.List;
import java.util.Scanner;

public class Operacje {
	public static void main(String[] args) {
		PersonManager Pm = new PersonManager();
		BookManager Bm = new BookManager();
		System.out.println("Wybierz opcje:");
		System.out.println("[1] Stworz konto:");
		System.out.println("[2] zaloguj:");
		System.out.println("[3] Wyjdz:");
		Scanner scan = new Scanner(System.in);
		String akcja = scan.nextLine();
		User logged = null;
		int Role = 1;
		if ("1".equals(akcja)) {

			System.out.println("Podaj login");
			String NewLogin = scan.nextLine();
			System.out.println("Podaj haslo");
			String NewPassword = scan.nextLine();
			User NewUser = new User(NewLogin, NewPassword, 0);
			NewUser.setLogin(NewLogin);
			NewUser.setPassword(NewPassword);
			NewUser.setRole(0);
			try {
				Pm.addUser(NewUser);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if ("2".equals(akcja))
			;
		{
			try {
				List<User> UL = Pm.readUsers();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			Boolean smh = false;
			do {
				System.out.println("Podaj login");
				String Login = scan.nextLine();
				System.out.println("Podaj haslo");
				String Pass = scan.nextLine();
				Boolean correct = false;
				do {
					try {
						for (User U : Pm.readUsers()) {
							if (U.getLogin().equals(Login) && U.getPassword().equals(Pass)) {
								System.out.println("Zalogowano :D");
								correct = true;
								logged = U;
								Role = U.getRole();
								System.out.println(Role);
								break;
							}

							else{
								System.out.println("bladne dane");
								break;
							}
						}
						break;
					} catch (Exception e) {
						e.printStackTrace();
					}
				} while (correct == false);
				if (logged != null) {
					smh = true;
				}
			} while (smh == false);
			Boolean doLogout = false;
			if (Role == 1) {
				do {
					System.out.println("[1] lista uzytkownikow:");
					System.out.println("[2] Usun uzytkownika:");
					System.out.println("[3] Dodaj ksiazke:");
					System.out.println("[4] Usun Ksiazke:");
					System.out.println("[5] Edytuj Ksiazke:");
					System.out.println("[6] Wyloguj:");
					String action = scan.nextLine();
					if ("1".equals(action)) {
						try {
							for (User U : Pm.readUsers()) {
								System.out.println("login: " + U.getLogin());
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					if ("2".equals(action)) {
						System.out.println("Podaj login:");
						String login = scan.next();
						try {
							if (!Pm.removeUser(login))
								System.out.println("uzytkownika nie ma na liscie");
							else
								System.out.println("Usunieto uzytkownika z listy");
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					if ("3".equals(action)) {
						System.out.println("Podaj tytu�:");
						String NewTitle = scan.nextLine();
						System.out.println("Podaj autora:");
						String NewAuthor = scan.nextLine();
						System.out.println("Podaj gatunek:");
						String NewGenre = scan.nextLine();
						if (scan.hasNextLine())
							;
						try {
							Bm.addBook(NewTitle, NewAuthor, NewGenre);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					if ("4".equals(action)) {
						System.out.println("Podaj ksiazke do usuniecia:");
						String Bookremove = scan.nextLine();
						if (scan.hasNextLine())
							scan.nextLine();
						try {
							Bm.removeBook(Bookremove);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					if ("6".equals(action)) {
						doLogout = true;
						System.out.println("wyjecie.");
						scan.close();
						break;

					}
				} while (doLogout == false);
			}

			if (Role == 0) {
				do {
					System.out.println("[1] lista ksiezek:");
					System.out.println("[2] wyszukaj po gatunku:");
					System.out.println("[3] wyszukaj:");
					System.out.println("[4] Wyloguj");
					String action = scan.nextLine();
					if ("1".equals(action)) {
						try {
							for (Book B : Bm.readBooks()) {
								System.out.println("Book: " + B.getTitle());
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					if ("2".equals(action)) {
						System.out.println("[1] akcja:");
						System.out.println("[2] thriller:");
						System.out.println("[3] dramat:");
						System.out.println("[4] horror:");
						System.out.println("[5] fantasy:");
						String gn = scan.nextLine();
						if ("1".contentEquals(gn)) {

							try {
								for (Book B : Bm.readBooks()) {
									System.out.println("ksiazki z gatunku:" + B.getGenre().contains("akcja"));
									break;
								}
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
						if ("5".contentEquals(gn)) {

							try {
								for (Book B : Bm.readBooks()) {
									System.out.println(
											"ksiazki z gatunku:" + B.getTitle() + B.getGenre().contains("fantasy"));
									break;
								}
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					}
					if ("3".contentEquals(action)) {
						System.out.println("wyszukaj ksiazke:");
						String mytitle = scan.nextLine();
						try {
							for (Book B : Bm.readBooks()) {
								if(B.getTitle().contains(mytitle) == true){
									System.out.println("mamy taką książkę");
								}
								else {
									System.out.println("nie mamy takiej książki");
								}
								break;
							}
						} catch (Exception e) {
							e.printStackTrace();
						}

					}
					if ("4".equals(action)) {
						doLogout = true;
						System.out.println("Wyjście");
					}

				} while (doLogout == false);
			}
		}
	}
}