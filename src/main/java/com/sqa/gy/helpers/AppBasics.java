/**
 *   Yakovenko, Galina<br>
 *   Created: Jan 16, 2017
 *
 */

package com.sqa.gy.helpers;

import java.util.*;

import com.sqa.gy.helpers.exceptions.*;

public class AppBasics {

	static Scanner scanner = new Scanner(System.in);

	public static double calcsAverageOfIntsInArray(int[] anArray) {
		int total = calcsTotalOfIntsInArray(anArray);
		double average = (double) total / anArray.length;
		return average;
	}

	public static int calcsTotalOfIntsInArray(int[] anArray) {
		int total = 0;
		for (int i = 0; i < anArray.length; i++) {
			total += anArray[i];
		}
		return total;
	}

	public static double convertMoneyStringIntoDouble(String moneyString) {
		double moneyDouble = 0;
		if (moneyString.substring(0, 0).equalsIgnoreCase("$")) {
			moneyString = moneyString.substring(1);
		}
		if (moneyString.contains(",")) {
			moneyString = moneyString.replaceAll(",", "");
		}
		try {
			moneyDouble = Double.parseDouble(moneyString);
		} catch (Exception e) {
			System.out.println("Could not convert subtotal string into a double");
		}
		return moneyDouble;
	}

	public static int convertStringtoInt(String input, int min, int max) {
		int result = 0;
		boolean isNotValid = true;
		while (isNotValid) {
			try {
				result = Integer.parseInt(input);
				if (min != 0 && max != 0) {
					if (result < max && result > min) {
						isNotValid = false;
					} else {
						throw new NumberNotInRangeException();
					}
				}
			} catch (NumberFormatException e) {
				System.out.println("You have not entered a correct number value.");
			} catch (NumberNotInRangeException e) {
				System.out.println("You have not entered a number within the range of " + min + " and " + max + ".");
			}
			isNotValid = false;
		}
		return result;
	}

	public static void doSomething(String appName, String appActionIng) {
		System.out.println(appName + " App is " + appActionIng);
	}

	public static void farewellUser(String nameOfUser, String appName) {
		System.out.println("\nThanks for using " + appName + ".");
		System.out.println("Bye for now, " + nameOfUser + "!");
	}

	public static String greetNoUserName(String appName) {
		System.out.println("Hello there and welcome to the " + appName + " app.");
		return scanner.nextLine();
	}

	public static String greetUser(String appName) {
		System.out.println("Hello and welcome to the " + appName + " app.");
		System.out.print("What shall I call you? ");
		return scanner.nextLine();
	}

	public static void printAddingingEachLoopFor(int minInclusive, int maxInclusive, int numToDeIncrementBy,
			String symbolBefore, String symbolAfter, String symbolBetween) {
		for (int i = minInclusive; i <= maxInclusive; i += numToDeIncrementBy) {
			if (i == minInclusive) {
				System.out.print(symbolBefore + i + symbolAfter);
			} else {
				System.out.print(symbolBetween + symbolBefore + i + symbolAfter);
			}
		}
		System.out.print("\n");
	}

	public static void printDividingEachLoopFor(int maxInclusive, int minInclusive, int numMultDivBy,
			String symbolBefore, String symbolAfter, String symbolBetween) {

		if (minInclusive < 0) {
			for (int i = minInclusive; i <= maxInclusive; i = i / numMultDivBy) {
				if (i == minInclusive) {
					System.out.print(symbolBefore + i + symbolAfter);
				} else {
					System.out.print(symbolBetween + symbolBefore + i + symbolAfter);
				}
			}
		} else {
			for (int i = maxInclusive; i >= minInclusive; i = i / numMultDivBy) {
				if (i == maxInclusive) {
					System.out.print(symbolBefore + i + symbolAfter);
				} else {
					System.out.print(symbolBetween + symbolBefore + i + symbolAfter);
				}
			}
		}
		System.out.print("\n");
	}

	public static void printIntArray(int[] anArray) {
		System.out.print(anArray[0]);
		for (int i = 1; i < anArray.length; i++) {
			System.out.print(Integer.toString(anArray[i]));
			System.out.print(", ");
		}
	}

	public static void printMultiplyingEachLoopFor(int minInclusive, int maxInclusive, int numMultDivBy,
			String symbolBefore, String symbolAfter, String symbolBetween) {
		for (int i = minInclusive; i <= maxInclusive; i = i * numMultDivBy) {
			if (i == minInclusive) {
				System.out.print(symbolBefore + i + symbolAfter);
			} else {
				System.out.print(symbolBetween + symbolBefore + i + symbolAfter);
			}
		}
		System.out.print("\n");
	}

	public static void printSubtractingEachLoopFor(int maxInclusive, int minInclusive, int numToDeIncrementBy,
			String symbolBefore, String symbolAfter, String symbolBetween) {
		for (int i = maxInclusive; i >= minInclusive; i -= numToDeIncrementBy) {
			if (i == maxInclusive) {
				System.out.print(symbolBefore + i + symbolAfter);
			} else {
				System.out.print(symbolBetween + symbolBefore + i + symbolAfter);
			}
		}
		System.out.print("\n");
	}

	public static double requestDoubleFromUser(String question) {
		return requestDoubleFromUser(question, 0, 0);
	}

	public static double requestDoubleFromUser(String question, double min, int max) {
		String input;
		double result = 0;
		boolean isNotValid = true;
		while (isNotValid) {
			try {
				System.out.print(question + " ");
				input = scanner.nextLine();
				result = Double.parseDouble(input);
				if (min != 0 && max != 0) {
					if (result < max && result > min) {
						isNotValid = false;
					} else {
						throw new NumberNotInRangeException();
					}
				}
			} catch (NumberFormatException e) {
				System.out.println("You have not entered a correct number value.");
			} catch (NumberNotInRangeException e) {
				System.out.println("You have not entered a number within the range of " + min + " and " + max + ".");
			}
			isNotValid = false;
		}
		return result;
	}

	public static int requestIntFromUser(String question) {
		return requestIntFromUser(question, 0, 0);
	}

	public static int requestIntFromUser(String question, int min, int max) {
		String input;
		int result = 0;
		boolean isNotValid = true;
		while (isNotValid) {
			try {
				System.out.print(question + " ");
				input = scanner.nextLine();
				result = Integer.parseInt(input);
				if (min != 0 && max != 0) {
					if (result < max && result > min) {
						isNotValid = false;
					} else {
						throw new NumberNotInRangeException();
					}
				}
			} catch (NumberFormatException e) {
				System.out.println("You have not entered a correct number value.");
			} catch (NumberNotInRangeException e) {
				System.out.println("You have not entered a number within the range of " + min + " and " + max + ".");
			}
			isNotValid = false;
		}
		return result;
	}

	public static int requestIntFromUserexptCASHOUTorEXIT(String question, int min, int max) {
		String input;
		int result = 0;
		boolean isNotValid = true;
		while (isNotValid) {
			try {
				System.out.print(question + " ");
				input = scanner.nextLine();
				if (input.equalsIgnoreCase("Cash Out") || input.equalsIgnoreCase("Exit")) {
					return -1;
				} else {
					result = Integer.parseInt(input);
					if (min != 0 && max != 0) {
						if (result <= max && result >= min) {
							isNotValid = false;
						} else {
							throw new NumberNotInRangeException();
						}
					}
				}
				isNotValid = false;
			} catch (NumberFormatException e) {
				System.out.println("You have not entered a correct number value.");
			} catch (NumberNotInRangeException e) {
				System.out.println("You have not entered a number within the range of " + min + " and " + max + ".");
			}
		}
		return result;
	}

	public static String requestUserInfo(String prompt) {
		System.out.print(prompt + " ");
		String response = scanner.nextLine();
		return response;
	}

	public static boolean requestYesorNo(String prompt) {
		String strYes = "y";
		String response = AppBasics.requestUserInfo(prompt + " (y/n): ");
		return response.equalsIgnoreCase(strYes);
	}

	public static String returnIntArrayAsString(int[] anArray) {
		String arrayInAString = Integer.toString(anArray[0]);
		for (int i = 1; i < anArray.length; i++) {
			{
				arrayInAString = arrayInAString + ", ";
				arrayInAString = arrayInAString + Integer.toString(anArray[i]);
			}
		}
		return arrayInAString;
		/*
		 * IF i wanted to user foreach.. I don't because my [0] is diff from all
		 * else for (int i : anArray) { arrayInAString += ", "; arrayInAString
		 * += Integer.toString(anArray[i]); }
		 */
	}
}
