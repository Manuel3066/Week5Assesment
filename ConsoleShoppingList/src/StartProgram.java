

import java.util.List;
import java.util.Scanner;

import controller.CarItemHelper;
import model.CarItem;

public class StartProgram {

		static Scanner in = new Scanner(System.in);
		static CarItemHelper lih = new CarItemHelper();

		private static void addAnItem() {
			System.out.print("Enter a Model: ");
			String model = in.nextLine();
			System.out.print("Enter an Color: ");
			String color = in.nextLine();
			System.out.print("Enter an Amount: ");
			int amount = in.nextInt();
			CarItem toAdd = new CarItem(model,color,amount);
			lih.insertItem(toAdd);
		}

		private static void deleteAnItem() {
			// TODO Auto-generated method stub
			System.out.print("Enter the model to delete: ");
			String model = in.nextLine();
			System.out.print("Enter the color to delete: ");
			String color = in.nextLine();
			System.out.println("Enter the amount to delete: ");
			int amount = in.nextInt();
			CarItem toDelte = new CarItem(model,color,amount);
			lih.deleteItem(toDelte);

		}

		private static void editAnItem() {
			// TODO Auto-generated method stub
			System.out.println("How would you like to search? ");
			System.out.println("1 : Search by Model");
			System.out.println("2 : Search by Color");
			int searchBy = in.nextInt();
			in.nextLine();
			List<CarItem> foundItems;
			if (searchBy == 1) {
				System.out.print("Enter the model name: ");
				String modelName = in.nextLine();
				foundItems = lih.searchforCarByModel(modelName);
				
			} else{
				System.out.print("Enter the Color: ");
				String colorName = in.nextLine();
				foundItems=lih.searchForCarByColor(colorName);

			}

			if (!foundItems.isEmpty()) {
				System.out.println("Found Results.");
				for (CarItem l : foundItems) {
					System.out.println(l.getId() + " : " + l.toString());
				}
				System.out.print("Which ID to edit: ");
				int idToEdit = in.nextInt();

				CarItem toEdit = lih.searchForCarById(idToEdit);
				System.out.println("Retrieved " + toEdit.getColor() + " from " + toEdit.getModel());
				System.out.println("1 : Update Model");
				System.out.println("2 : Update Color");
				System.out.println("3 : Update Amount");
				int update = in.nextInt();
				in.nextLine();

				if (update == 1) {
					System.out.print("New Store: ");
					String newModel = in.nextLine();
					toEdit.setModel(newModel);
				} else if (update == 2) {
					System.out.print("New Color: ");
					String newColor = in.nextLine();
					toEdit.setColor(newColor);
				} else if (update == 3) {
					System.out.print("New Amount: ");
					int newAmount = in.nextInt();
					toEdit.setAmount(newAmount);
				}
				

				lih.updateItem(toEdit);

			} else {
				System.out.println("---- No results found");
			}

		}

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			runMenu();

		}

		public static void runMenu() {
			boolean goAgain = true;
			System.out.println("--- Welcome to our Dealership ---");
			while (goAgain) {
				System.out.println("*  1 -- Add a Car");
				System.out.println("*  2 -- Edit a Car");
				System.out.println("*  3 -- Delete a Car");
				System.out.println("*  4 -- View the list of Cars");
				System.out.println("*  5 -- Exit");
				System.out.print("*  Your selection: ");
				int selection = in.nextInt();
				in.nextLine();

				if (selection == 1) {
					addAnItem();
				} else if (selection == 2) {
					editAnItem();
				} else if (selection == 3) {
					deleteAnItem();
				} else if (selection == 4) {
					viewTheList();
				} else {
					lih.cleanUp();
					System.out.println("   Goodbye!   ");
					goAgain = false;
				}

			}

		}

		private static void viewTheList() {
			// TODO Auto-generated method stub
			List<CarItem> allItems = lih.showAllitems();
			for(CarItem singleItem:allItems) {
				System.out.println(singleItem.returnItemDetails());
			}
		}

	}
