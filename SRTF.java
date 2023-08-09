import java.util.*;

public class SRTF{
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of processes:");
        int n = sc.nextInt();
        int pid[] = new int[n];
        int at[] = new int[n];
        int bt[] = new int[n];
        int ct[] = new int[n];
        int ta[] = new int[n];
        int wt[] = new int[n];
        int remainingTime[] = new int[n]; // To keep track of remaining burst time
        int completed = 0;
        int currentTime = 0;
        float avgwt = 0;
        float avgta = 0;

        // Input: Arrival time and Burst time for each process
        for (int i = 0; i < n; i++) {
            System.out.println("Enter process " + (i + 1) + " arrival time: ");
            at[i] = sc.nextInt();
            System.out.println("Enter process " + (i + 1) + " burst time: ");
            bt[i] = sc.nextInt();
            pid[i] = i + 1;
            remainingTime[i] = bt[i]; // Initialize remainingTime with burst time
        }

        while (completed < n) {
            int shortestProcess = -1;
            int minRemainingTime = Integer.MAX_VALUE;

            // Find the process with the shortest remaining time
            for (int i = 0; i < n; i++) {
                if (at[i] <= currentTime && remainingTime[i] > 0 && remainingTime[i] < minRemainingTime) {
                    shortestProcess = i;
                    minRemainingTime = remainingTime[i];
                }
            }

            if (shortestProcess == -1) {
                currentTime++;
            } else {
                remainingTime[shortestProcess]--;
                currentTime++;

                // If process completes, calculate turnaround time and waiting time
                if (remainingTime[shortestProcess] == 0) {
                    completed++;
                    ct[shortestProcess] = currentTime;
                    ta[shortestProcess] = ct[shortestProcess] - at[shortestProcess];
                    wt[shortestProcess] = ta[shortestProcess] - bt[shortestProcess];
                    avgta += ta[shortestProcess];
                    avgwt += wt[shortestProcess];
                }
            }
        }

        // Display results
        System.out.println("\nPID\tArrival\tBurst\tComplete\tTurnaround\tWaiting");
        for (int i = 0; i < n; i++) {
            System.out.println(pid[i] + "\t" + at[i] + "\t" + bt[i] + "\t" + ct[i] + "\t\t" + ta[i] + "\t\t" + wt[i]);
        }
        System.out.println("\nAverage Turnaround Time: " + (avgta / n));
        System.out.println("Average Waiting Time: " + (avgwt / n));

        sc.close();
    }
}
