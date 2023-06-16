import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Scanner;
import javax.swing.*;

public class Operacje {
	public static void main(String[] args) {
		int Role = 0;
		PersonManager Pm = new PersonManager();
		BookManager Bm = new BookManager();

		MyFrame frame = new MyFrame();

		frame.create_account.addActionListener(e -> {
			JTextField NewLogin = new JTextField(20);
			JPasswordField NewPassword = new JPasswordField(20);

			JPanel account_panel = new JPanel();
			account_panel.add(new JLabel("login:"));
			account_panel.add(NewLogin);
			account_panel.add(new JLabel("haslo:"));
			account_panel.add(NewPassword);

			int option = JOptionPane.showConfirmDialog(frame, account_panel, "Stworz konto",
					JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
			if (option == JOptionPane.OK_OPTION) {
				String login = NewLogin.getText();
				String password = new String(NewPassword.getPassword());
				User NewUser = new User(login, password, 0);
				NewUser.setLogin(login);
				NewUser.setPassword(password);
				NewUser.setRole(0);
				try {
					Pm.addUser(NewUser);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		frame.log_in.addActionListener(e -> {
			try {
				List<User> UL = Pm.readUsers();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			Boolean smh = false;
			do {
				JTextField Login = new JTextField(20);
				JPasswordField Password = new JPasswordField(20);
				JPanel account_panel = new JPanel();
				account_panel.add(new JLabel("login:"));
				account_panel.add(Login);
				account_panel.add(new JLabel("haslo:"));
				account_panel.add(Password);
				int option = JOptionPane.showConfirmDialog(frame, account_panel, "Zaloguj się",
						JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
				if (option == JOptionPane.OK_OPTION) {
					String login = Login.getText();
					String password = new String(Password.getPassword());
					boolean correct = false;
					User logged = null;
					do {
						try {
							for (User U : Pm.readUsers()) {
								System.out.println(Pm.readUsers());
								if (U.getLogin().equals(login) && U.getPassword().equals(password)) {
									System.out.println("Zalogowano :D");
									correct = true;
									logged = U;
									int URole = U.getRole();
									break;
								}

								else {
									System.out.println("bladne dane");
									break;
								}
							}
							break;
						} catch (Exception ex) {
							ex.printStackTrace();
						}
					} while (correct == false);
					if (logged != null) {
						smh = true;
					}
				}
			} while (smh == false);
			if (Role == 1) {
				frame.getContentPane().removeAll();
				JButton user_list;
				user_list = new JButton("lista uzytkownikow");
				frame.add(user_list);
				user_list.addActionListener(a -> {
					try {
						for (User U : Pm.readUsers()) {
							System.out.println("login: " + U.getLogin());
						}
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				});
				JButton delete_user;
				delete_user = new JButton("usun uzytkownika");
				frame.add(delete_user);
				delete_user.addActionListener(a -> {
					JTextField Login = new JTextField(20);

					JPanel remove_panel = new JPanel();
					remove_panel.add(new JLabel("Podaj login do usuniecia:"));
					remove_panel.add(Login);

					int option = JOptionPane.showConfirmDialog(frame, remove_panel, "Podaj login",
							JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
					if (option == JOptionPane.OK_OPTION) {
						String login = Login.getText();
						try {
							if (!Pm.removeUser(login))
								System.out.println("uzytkownika nie ma na liscie");
							else
								System.out.println("Usunieto uzytkownika z listy");
						} catch (Exception ex) {
							ex.printStackTrace();
						}
					}
				});
				JButton add_book;
				add_book = new JButton("Dodaj ksiazke");
				frame.add(add_book);
				add_book.addActionListener(a -> {
					JTextField NewTitle = new JTextField(20);
					JTextField NewAuthor = new JTextField(20);
					JTextField NewGenre = new JTextField(20);
					JPanel remove_panel = new JPanel();
					remove_panel.add(new JLabel("Podaj tytul:"));
					remove_panel.add(NewTitle);
					remove_panel.add(new JLabel("Podaj autora:"));
					remove_panel.add(NewAuthor);
					remove_panel.add(new JLabel("Podaj gatunek:"));
					remove_panel.add(NewGenre);

					int option = JOptionPane.showConfirmDialog(frame, remove_panel, "Uzupelnij ksiazke",
							JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
					if (option == JOptionPane.OK_OPTION) {
						String title = NewTitle.getText();
						String author = NewAuthor.getText();
						String genre = NewGenre.getText();
						try {
							Bm.addBook(title, author, genre);
						} catch (Exception ex) {
							ex.printStackTrace();
						}
					}
				});
				JButton remove_book;
				remove_book = new JButton("Usun ksiazke");
				frame.add(remove_book);
				remove_book.addActionListener(a -> {
					JTextField Tytul = new JTextField(20);

					JPanel remove_panel = new JPanel();
					remove_panel.add(new JLabel("Podaj tytul ksiazki do usuniecia:"));
					remove_panel.add(Tytul);

					int option = JOptionPane.showConfirmDialog(frame, remove_panel, "Podaj login",
							JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
					if (option == JOptionPane.OK_OPTION) {
						String tytul = Tytul.getText();
						try {
							Bm.removeBook(tytul);
						} catch (Exception ex) {
							ex.printStackTrace();
						}
					}
				});
				JButton edit_book;
				edit_book = new JButton("Edytuj ksiazke");
				frame.add(edit_book);
				edit_book.addActionListener(a -> {

				});
				JButton exit;
				exit = new JButton("wyjdz");
				frame.add(exit);
				exit.addActionListener(a -> {
					System.exit(0);
				});
				frame.revalidate();
				frame.repaint();

			}

			if (Role == 0) {
				frame.getContentPane().removeAll();
				JButton book_list;
				book_list = new JButton("lista ksiazek");
				frame.add(book_list);
				book_list.addActionListener(a -> {
					try {
						for (Book B : Bm.readBooks()) {
							System.out.println("Book: " + B.getTitle());
						}
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				});
				JButton searchbygenre;
				searchbygenre = new JButton("szukaj po gatunku");
				frame.add(searchbygenre);
				searchbygenre.addActionListener(a -> {
					JTextField Login = new JTextField(20);

					JPanel remove_panel = new JPanel();
					remove_panel.add(new JLabel("Podaj login do usuniecia:"));
					remove_panel.add(Login);

					int option = JOptionPane.showConfirmDialog(frame, remove_panel, "Podaj gatunek",
							JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
					if (option == JOptionPane.OK_OPTION) {
						String login = Login.getText();
						try {
							if (!Pm.removeUser(login))
								System.out.println("uzytkownika nie ma na liscie");
							else
								System.out.println("Usunieto uzytkownika z listy");
						} catch (Exception ex) {
							ex.printStackTrace();
						}
					}
				});
				JButton search;
				search = new JButton("szukaj po tytule");
				frame.add(search);
				search.addActionListener(a -> {
					JTextField Title = new JTextField(20);
					search.add(Title);
					int option = JOptionPane.showConfirmDialog(frame, search, "Uzupelnij ksiazke",
							JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
					if (option == JOptionPane.OK_OPTION) {
						try {
							String title = Title.getText();
							for (Book B : Bm.readBooks()) {
								if (B.getTitle().contains(title) == true) {
									System.out.println("mamy taką książkę");
									break;
								} else {
									System.out.println("nie mamy takiej książki");
								}
							}
						} catch (Exception ex) {
							ex.printStackTrace();
						}
					}
				});
				JButton exit;
				exit = new JButton("wyjdz");
				frame.add(exit);
				exit.addActionListener(a -> {
					System.exit(0);
				});
				frame.revalidate();
				frame.repaint();
			}
		});
		frame.exit.addActionListener(e -> {
			System.exit(0);
		});
	}
}
