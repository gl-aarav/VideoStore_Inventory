/*
 * Aarav Goyal
 * December 4, 2023
 * Mr. Kulla's paint store
 */
public class Main {
  public static void main(String[] args) {

    String[] customerNames = {"John", "Alice", "Bob", "Emma", "Mike", "Sara", "David", "Olivia", "Sophia", "Daniel"};
    int[] customerIDs = {101, 102, 103, 104, 105, 106, 107, 108, 109, 110};
    int[] movieIDs = {201, 202, 203, 204, 205, 206, 207, 208, 209, 210};
    int[] rentalCodes = {1, 5, 1, 5, 1, 5, 1, 5, 1, 5};
    int[] daysRented = {3, 6, 2, 4, 5, 3, 6, 2, 2, 5};
    double[] lateFees = new double[10];
    String[] status = new String[10];

    for (int i = 0; i < 10; i++) {
      if (daysRented[i] > rentalCodes[i]) {
        status[i] = "Late";
        if (rentalCodes[i] == 1) {
          lateFees[i] = (daysRented[i] - rentalCodes[i]) * 1.49;
        } else {
          lateFees[i] = (daysRented[i] - rentalCodes[i]) * 0.69;
        }
      } else {
        status[i] = "Not Late";
        lateFees[i] = 0.0;
      }
    }

    sortCustomerIDs(customerIDs, customerNames, lateFees, status);

    System.out.println("List of people who owe late fees:");
    for (int j = 0; j < 10; j++) {
      if (lateFees[j] > 0) {
        System.out.println(customerNames[j] + " - Late Fee: $" + lateFees[j] + " - Status: " + status[j]);
      }
    }

    System.out.println("\nList of people who do not owe late fees:");
    for (int k = 0; k < 10; k++) {
      if (lateFees[k] == 0) {
        System.out.println(customerNames[k] + " - Status: " + status[k]);
      }
    }
  }

  public static void sortCustomerIDs(int[] IDs, String[] names, double[] fees, String[] status) {
    for (int i = 0; i < IDs.length - 1; i++) {
      for (int j = 0; j < IDs.length - i - 1; j++) {
        if (IDs[j] > IDs[j + 1]) {
          swap1(IDs, names, j);
          swap2(IDs, fees, j);
          swap3(IDs, status, j);
        }
      }
    }
  }

  public static void swap1(int[] arr, String[] names, int index) {
    int temp = arr[index];
    arr[index] = arr[index + 1];
    arr[index + 1] = temp;

    String tempName = names[index];
    names[index] = names[index + 1];
    names[index + 1] = tempName;
  }

  public static void swap2(int[] arr, double[] fees, int index) {
    int temp = arr[index];
    arr[index] = arr[index + 1];
    arr[index + 1] = temp;

    double tempFee = fees[index];
    fees[index] = fees[index + 1];
    fees[index + 1] = tempFee;
  }

  public static void swap3(int[] arr, String[] status, int index) {
    int temp = arr[index];
    arr[index] = arr[index + 1];
    arr[index + 1] = temp;

    String tempStatus = status[index];
    status[index] = status[index + 1];
    status[index + 1] = tempStatus;
  }
}
