package com.skilldistillery.filmquery.app;

import java.util.List;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {

	DatabaseAccessor db = new DatabaseAccessorObject();
	Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		FilmQueryApp app = new FilmQueryApp();
//    app.test();
		app.launch();
	}
//  private void test() {
//    Film film = db.findFilmById(1);
//    System.out.println(film);
//    System.out.println(film.getActors());
//  }

	private void launch() {
		startUserInterface(input);

		input.close();
	}

	private void startUserInterface(Scanner input) {
		// TODO Print menu
		boolean keepGoing = true;
		while (keepGoing) {
			System.out.println("+-------------------------------+");
			System.out.println("|   *Please select an option*   |");
			System.out.println("|-------------------------------|");
			System.out.println("| 1. Look up a film by it's ID  |");
			System.out.println("| 2. Look up a film by keyword  |");
			System.out.println("| 3. EXIT                       |");
			System.out.println("+-------------------------------+");

			int choice = getInput();
			input.nextLine();

			switch (choice) {

			case 1:
				System.out.println("Please input the film's ID.");
				int filmId = input.nextInt();
				Film film = db.findFilmById(filmId);
				if (film != null) {
					showFilm(film);
				} else {
					System.out.println("This ID does not match a film on record.");
				}
				break;

			case 2:
				System.out.println("Please input a keyword to search by:");
				String keyword = input.nextLine();
				List<Film> films = db.findFilmByKeyword(keyword);
				if (films.isEmpty()) {
					System.out.println("No films contain " + keyword);
				} else {
					for (Film filmByKeyword : films) {
						showFilm(filmByKeyword);
					}
					break;
				}

			case 3:
				System.out.println("Goodbye!");
				keepGoing = false;
				break;
			default:
				System.out.println("Invalid choice. Try again.");
			
		}
	}

	}

	private void showFilm(Film film) {
		System.out.println("\nTitle: " + film.getTitle());
		System.out.println("Year: " + film.getReleaseYear());
		System.out.println("Rating: " + film.getRating());
		System.out.println("Description: " + film.getDescription());
		System.out.println("Language: " + film.getLanguage());
		System.out.println("Cast: " + film.getActors());
	}

	private int getInput() {
		while (true) {
			try {
				return input.nextInt();
			} catch (Exception e) {
				System.out.println("Error: Input MUST be a number.");
			}
			input.nextLine();
		}
	}

}
