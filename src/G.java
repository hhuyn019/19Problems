import java.util.ArrayList;
import java.util.Scanner;

public class G {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //program1(sc);
        //program2(sc);
        //program3(sc);
        //program4(sc);
        //program5(sc);
        //program6(sc);
        //program7();
        //program8();
        //program9();
        //program10();
        //program11();
        //program12(sc);
        //program13(sc);
    }

    //Write a Java program to find the factorial of a given number.
    static void program1(Scanner sc) {
        System.out.println("Enter the number you want the factorial of: ");
        int value = sc.nextInt();
        int result = value;
        for(int i = value-1; i >= 2; --i) {
            result *= i;
        }
        System.out.println(result);
    }

    //Write a Java program to check whether a number is prime or not.
    static void program2(Scanner sc) {
        System.out.println("Enter a number to check if it is prime or not: ");
        int value = sc.nextInt();
        if(value == 0 || value == 1) {
            System.out.println("Not prime");
            return;
        }
        for(int i = 2; i <= value/2; ++i) {
            if(value%2==0) {
                System.out.println("Not prime");
                return;
            }
        }
        System.out.println("Prime");
    }

    //Write a Java program to print the Fibonacci series up to a given number.
    static void program3(Scanner sc) {
        System.out.println("Enter a number you want to print the Fibonacci series up to: ");
        int value = sc.nextInt();
        int num1 = 0;
        int num2 = 1;
        for(int i = 0; i < value; ++i) {
            if(num1 <= value) {
                System.out.println(num1 + " ");
                int num3 = num1+num2;
                num1 = num2;
                num2 = num3;
            }
        }
    }

    //Write a Java program to check if a string is a palindrome.
    static void program4(Scanner sc) {
        System.out.println("Enter a string to check if it is a palindrome: ");
        String input = sc.nextLine();
        String lower = input.toLowerCase();
        for(int i = 0; i < lower.length()/2; ++i) {
            if(lower.charAt(i) != lower.charAt(lower.length()-1-i)) {
                System.out.println("Not a palindrome");
                return;
            }
        }
        System.out.println("Palindrome");
    }

    //Write a Java program to reverse a string.
    static void program5(Scanner sc) {
        System.out.println("Enter a string to reverse: ");
        String input = sc.nextLine();
        String result = "";
        for(int i = input.length()-1; i >= 0; --i) {
            result += input.charAt(i);
        }
        System.out.println(result);
    }

    //Write a Java program to check whether a year is a leap year or not.
    static void program6(Scanner sc) {
        System.out.println("Enter a year to check if it is a leap year or not: ");
        int input = sc.nextInt();
        if(input%4==0) {
            if(input%100==0) {
                System.out.println("not a leap year");
                return;
            }
            System.out.println("leap year");
            return;
        }
        if(input%400==0) {
            System.out.println("leap year");
            return;
        }
        System.out.println("not a leap year");
    }

    //Write a Java program to sort an array of integers using bubble sort.
    static void program7() {
        int[] myArray = {12,4,52,34,1,345,62,21,5};
        for(int i = 0; i < myArray.length-1; ++i) {
            for(int j = 0; j < myArray.length-1-i; ++j) {
                if(myArray[j] > myArray[j+1]) {
                    int temp = myArray[j];
                    myArray[j] = myArray[j+1];
                    myArray[j+1] = temp;
                }
            }
        }
        for(int i:myArray) System.out.println(i);
    }

    //Write a Java program to calculate the average grade of students and determine the highest and lowest grades.
    static void program8() {
        int[] grades = {90,87,75,86,97,74,88,85,68};
        for(int i = 0; i < grades.length-1; ++i) {
            for(int j = 0; j < grades.length-1-i; ++j) {
                if(grades[j] > grades[j+1]) {
                    int temp = grades[j];
                    grades[j] = grades[j+1];
                    grades[j+1] = temp;
                }
            }
        }
        int sum = 0;
        for(int i:grades) sum += i;
        double average = (double)sum/grades.length;
        int highest = grades[grades.length-1];
        int lowest = grades[0];
        System.out.println("Average: " + average + " highest: " + highest + " lowest: " + lowest);
    }

    //Write a Java program to multiply two matrices.
    static void program9() {
        int[][] matrix1 = {{2,4},{4,7}};
        int[][] matrix2 = {{5,3},{3,7}};
        int row_matrix1 = matrix1.length;
        int col_matrix1 = matrix1[0].length;
        int row_matrix2 = matrix2.length;
        int col_matrix2 = matrix2[0].length;
        if(col_matrix1 != row_matrix2) {
            System.out.println("Matrices cannot be multiplied.");
            return;
        }
        int[][] results = new int[row_matrix1][col_matrix2];
        for(int i = 0; i < row_matrix1; ++i) {
            for(int j = 0; j < col_matrix2; ++j) {
                for(int k = 0; k < row_matrix2; ++k) {
                    results[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        for(int i = 0; i < results.length; ++i) {
            for(int j = 0; j < results[0].length; ++j) {
                System.out.print(results[i][j] + " ");
            }
            System.out.println();
        }
    }

    //Create a Java class to manage a bank account with functionalities to deposit, withdraw, and check balance.
    static void program10() {
        BankAccount bankAccount = new BankAccount(5555);
        bankAccount.deposit(1000);
        System.out.println(bankAccount.getBalance());
        bankAccount.withdraw(555);
        System.out.println(bankAccount.getBalance());
    }

    //Create a Java program to manage employees with functionalities to add, remove, and display employee details.
    static void program11() {
        Employee emp1 = new Employee("Bob",25);
        Employee emp2 = new Employee("Tim", 42);
        Employee emp3 = new Employee("Trent", 32);

        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(emp1);
        employees.add(emp2);
        employees.add(emp3);

        for(Employee emp:employees) System.out.println(emp);

        employees.remove(0);
        for(Employee emp:employees) System.out.println(emp);
    }

    //Write a Java program to create a simple calculator using switch case statements.
    static void program12(Scanner sc) {
        System.out.println("Enter the first value: ");
        double input1 = sc.nextDouble();
        System.out.println("Enter the second value: ");
        double input2 = sc.nextDouble();
        System.out.println("Enter an operation: (add, subtract, multiply, divide");
        String function = sc.next();

        switch (function) {
            case "add":
                System.out.println(input1 + input2);
                break;
            case "subtract":
                System.out.println(input1 - input2);
                break;
            case "multiply":
                System.out.println(input1 * input2);
                break;
            case "divide":
                System.out.println(input1 / input2);
                break;
            default:
                System.out.println("Enter a valid function");
        }

    }

    //Write a Java program to implement the binary search algorithm for a sorted array.
    static void program13(Scanner sc) {
        int[] sortedArray = {2,5,7,9,13,23,36,39,45,59,71,88,100};
        System.out.println("Enter the number you want to locate: ");
        int target = sc.nextInt();
        int start = 0;
        int end = sortedArray.length-1;
        while(start <= end) {
            int mid = start + (end-start)/2;
            if(sortedArray[mid] == target) {
                System.out.println(target + " is found at index " + mid);
                return;
            }
            if(sortedArray[mid] < target) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        System.out.println("Target not found");
    }
}
