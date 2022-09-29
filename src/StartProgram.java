import java.util.List;
import java.util.Scanner;

import controller.ListMusicStudentHelper;
import model.ListMusicStudent;

/**
 * @author Kaitlyn Briggs - krbriggs
 * CIS175 - Fall 2022
 * Sep 15, 2022
 */

public class StartProgram {
	static Scanner in = new Scanner(System.in);
	static ListMusicStudentHelper msh = new ListMusicStudentHelper();

	private static void addAStudent() {
		// TODO Auto-generated method stub
		System.out.print("Please enter a student's name: ");
		String name = in.nextLine();
		System.out.print("Please enter an instrument they take lessons on: ");
		String instrument = in.nextLine();
		ListMusicStudent toAdd = new ListMusicStudent(name, instrument);
		msh.insertStudent(toAdd);

	}

	private static void deleteAStudent() {
		// TODO Auto-generated method stub
		try {
		System.out.print("Enter a student's name to delete: ");
		String name = in.nextLine();
		System.out.print("Enter an instrument to delete: ");
		String instrument = in.nextLine();
		ListMusicStudent toDelete = new ListMusicStudent(name, instrument);
		msh.deleteStudent(toDelete);
		System.out.println("Student sucessfully deleted");
		}catch (javax.persistence.NoResultException e) {
			System.out.println("Couldn't find student, please start over.");
			runMenu();
		}

	}

	private static void editAStudent() {
		// TODO Auto-generated method stub
		System.out.println("How would you like to search? ");
		System.out.println("1 : Search by Music Student's Name");
		System.out.println("2 : Search by Instrument");
		int searchBy = in.nextInt();
		in.nextLine();
		List<ListMusicStudent> foundStudents;
		if (searchBy == 1) {
			System.out.print("Enter the student's name: ");
			String studentName = in.nextLine();
			foundStudents = msh.searchForStudentByName(studentName);
		} else if(searchBy == 2){
			System.out.print("Enter the instrument: ");
			String instrumentType = in.nextLine();
			foundStudents = msh.searchForStudentByInstrument(instrumentType);
		} else {
			foundStudents = null;
			System.out.println("Invalid response, please start over.");
			runMenu();
		}

		if (!foundStudents.isEmpty()) {
			System.out.println("Found Results.");
			for (ListMusicStudent a : foundStudents) {
				
				System.out.println(a.getId() + " : " + (a.toString()));
			}
			System.out.print("Which ID to edit: ");
			int idToEdit = in.nextInt();

			ListMusicStudent toEdit = msh.searchForStudentById(idToEdit);
			System.out.println("Retrieved " + toEdit.getName() + ", who plays " + toEdit.getInstrument());
			System.out.println("1 : Update Student Name");
			System.out.println("2 : Update Instrument");
			int update = in.nextInt();
			in.nextLine();

			if (update == 1) {
				System.out.print("New Music Student: ");
				String newStudentName = in.nextLine();
				toEdit.setName(newStudentName);
			} else if (update == 2) {
				System.out.print("New Instrument: ");
				String newInstrument = in.nextLine();
				toEdit.setInstrument(newInstrument);
				System.out.println("Student successfully updated!");
			}

			msh.updateStudent(toEdit);

		} else {
			System.out.println("Student not found");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		runMenu();

	}

	public static void runMenu() {
		boolean goAgain = true;
		System.out.println("--------------------  Music Student Tracker  --------------------");
		System.out.println("--- Track Your Music Students and the Instruments They Play!! ---");
		while (goAgain) {
			System.out.println(" ");
			System.out.println("~Choose an Option~");
			System.out.println("1: Add a Student");
			System.out.println("2: Edit a Student");
			System.out.println("3: Delete a Student");
			System.out.println("4: View Students and Instruments They Play");
			System.out.println("5: Exit Program");
			System.out.print("Your choice: ");
			int selection = in.nextInt();
			in.nextLine();

			if (selection == 1) {
				addAStudent();
			} else if (selection == 2) {
				editAStudent();
			} else if (selection == 3) {
				deleteAStudent();
			} else if (selection == 4) {
				viewTheList();
			} else {
				msh.cleanUp();
				System.out.println("End of Program");
				goAgain = false;
			}

		}

	}

	private static void viewTheList() {
		// TODO Auto-generated method stub
		List<ListMusicStudent> allStudents = msh.showAllStudents();
		System.out.println("");
		System.out.println("Complete Music Student List: ");
		for(ListMusicStudent singleStudent : allStudents){
		System.out.println(singleStudent.returnStudentDetails());
		}

	}

}
