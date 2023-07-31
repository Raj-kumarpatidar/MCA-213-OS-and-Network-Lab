import java.util.Scanner;

public class FCFS {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of Processes");
        int n = sc.nextInt();

        int AT[] = new int[n];
        int BT[] = new int[n];

        System.out.println("Enter AT of all processes");
        for (int i = 0; i < n; i++) {
            AT[i] = sc.nextInt();
        }

        System.out.println("Enter BT of all processes");
        for (int i = 0; i < n; i++) {
            BT[i] = sc.nextInt();
        }
        int CT[] = new int[n];
        int comp=0;
        
        for (int i = 0; i < n; i++) {
           comp = comp+BT[i];
           CT[i]=comp;
           
        }

      System.out.println("  CT   ");
        for (int i = 0; i < n; i++) {
        
         System.out.println(CT[i]);
           
        }
        int sumTAT=0;
        int TAT[]=new int[n];
        for(int i=0;i<n;i++)
        {
           TAT[i]=CT[i]-AT[i];
           sumTAT=sumTAT+TAT[i];
        }
        System.out.println(" TAT    ");
        for (int i = 0; i < n; i++) {
        
         System.out.println(TAT[i]);
           
        }
        int WT[]=new int[n];
        int sumWT=0;
        for(int i=0;i<n;i++)
        {
           WT[i]=TAT[i]-BT[i];
           sumWT=sumWT+WT[i];
        }
        System.out.println(" WT    ");
        for (int i = 0; i < n; i++) {
        
         System.out.println(WT[i]);
           
        }
        
        System.out.println("Avegare of TAT  "+(double)sumTAT/n);
        System.out.println("Avegare of WT   "+(double)sumWT/n);
           
                  




    }
}
