import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        /*System.out.println("Hello World!");*/
        System.out.println("\n**************************************\n");
        System.out.println("\tWelcome to TheDesk \n");
        System.out.println("**************************************");
        optionsSelection();
    }
    private static void optionsSelection() {
        String[] arr = {"1. I wish to review my expenditure",
                "2. I wish to add my expenditure",
                "3. I wish to delete my expenditure",
                "4. I wish to sort the expenditures",
                "5. I wish to search for a particular expenditure",
                "6. Close the application"
        };
        int[] arr1 = {1,2,3,4,5,6};
        int  slen = arr1.length;
        ArrayList<Integer> arrlist = new ArrayList<Integer>();
        ArrayList<Integer> expenses = new ArrayList<Integer>();
        expenses.add(1000);
        expenses.add(2300);
        expenses.add(45000);
        expenses.add(32000);
        expenses.add(110);
        expenses.addAll(arrlist);
        System.out.println("\nEnter your choice:\t");
        Scanner sc = new Scanner(System.in);
        boolean exit = false;
        while (!exit){
            for(int i=0; i<slen;i++){
                System.out.println(arr[i]);
                // display the all the Strings mentioned in the String array
            }
            int  options =  sc.nextInt();
                switch (options){
                    case 1:
                        System.out.println("Your saved expenses are listed below: \n");
                        System.out.println(expenses+"\n"); 
                        break;
                    case 2:
                        System.out.println("Enter the value to add your Expense: \n");
                        int value = sc.nextInt();
                        expenses.add(value);
                        System.out.println("Your value is updated\n");
                        expenses.addAll(arrlist);
                        System.out.println(expenses+"\n");
                        break;
                    case 3:
                        System.out.println("You are about the delete all your expenses! \nConfirm again by selecting the same option...\n");
                        int con_choice = sc.nextInt();
                        if(con_choice==options){
                               expenses.clear();
                            System.out.println(expenses+"\n");
                            System.out.println("All your expenses are erased!\n");
                        } else {
                            System.out.println("Oops... try again!");
                        }
                        break;
                    case 4:
                        if(expenses.isEmpty()){
                            System.out.println("Your expense list is empty. It cannot be sorted.");
                        }
                        else{
                        int [] sortedExpenses = sortExpenses(expenses);
                        expenses.clear();
                        for(int i = 0; i < sortedExpenses.length; i++){
                            expenses.add(sortedExpenses[i]);
                        }
                        expenses.addAll(arrlist);
                        System.out.println("\n"+"Your saved expenses are sorted below: \n");
                        System.out.println(expenses+"\n");
                    }
                        break;
                    case 5:
                    if(expenses.isEmpty()){
                        System.out.println("Your expense list is empty.");
                    }
                    else{
                        searchExpenses(expenses);
                    }
                        break;
                    case 6:
                        closeApp();
                        exit = true;
                        break;
                    default:
                        System.out.println("You have made an invalid choice!\n");
                        break;
                } 
        }
        sc.close();
        

    }
    private static void closeApp() {
        System.out.println("Closing your application... \nThank you!");
            }
    
    private static void searchExpenses(ArrayList<Integer> arrayList) {
        int leng = arrayList.size();
        System.out.println("Enter the expense you need to search:\t");
        Scanner sc = new Scanner(System.in);
        int response = sc.nextInt();
        for(int i = 0; i < leng; i++){
            if(response == arrayList.get(i)){
                String value = "";
                if(i == 0){
                    value = "st";
                }
                else if(i == 1){
                    value = "nd";
                }
                else if(i == 2){
                    value = "rd";
                }
                else{
                    value = "th";
                }
                System.out.println("\nExpenditure of " + arrayList.get(i) + " is your " + (i+1) + value + " Expenditure in the expense list.\n");
                break;
            }
            if(i == (arrayList.size() - 1) && response != arrayList.get(i)){
                System.out.println("\nNo such expenditure is seen. Please try again with a different value.\n");
            }   
        }
    }
   
    private static int[] sortExpenses(ArrayList<Integer> arrayList) {
        int arrlength =  arrayList.size();
       //Complete the method. The expenses should be sorted in ascending order.
       int[] arr = new int[arrayList.size()];
       for (int i = 0; i < arrlength; i++){
        arr[i] = arrayList.get(i);
       }
        quickSort(arr, 0, arrlength - 1);
        return arr;   
    }
    
    public static void quickSort(int[] arr, int left, int right) {
		if ( left < right) {
			int pivotIndex = partition(arr,left,right);
			quickSort(arr, left, pivotIndex-1);
			quickSort(arr, pivotIndex+1, right);
		}
	}
    private static int partition(int[] arr, int left, int right) {
		int pivot = arr[left];
		int storeIndex = left + 1;
		for ( int i = left + 1; i <= right ;i++) {
			if ( arr[i] < pivot || arr[i] == pivot && Math.random() < 0.5) {
				swap(arr,i,storeIndex);
				storeIndex++;
			}
		}
		swap ( arr, left, storeIndex -1 );
		return storeIndex -1;
	}
    private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
