package com.skilldistillery.filmquery.app;

import java.util.InputMismatchException;
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
		}
	}

	private int getInput() {
		while (true) {
			try {
				return input.nextInt();
			}
			catch (Exception e) {
				System.out.println("Error: Input MUST be a number.");
			}
			input.nextLine();
		}
	}

}
