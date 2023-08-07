//Program for shortest job first (SJF) CPU sheduling 
//Non - preemptive

// based on Burst time  (execution time)
// Minimum Burst time process execute first 
// In ready queue process with minimum burst time execute first 
//greedy approach

import java.util.*;

public class SJFSNonPreemptive {
    public static void main(String args[])

    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of process:");
        int n = sc.nextInt();
        int pid[] = new int[n]; //
        int at[]=new int[n];
        int bt[]=new int[n];
        int ct[]=new int[n];
        int ta[]=new int[n];
        int wt[]=new int[n];
        int f[]=new int[n];   //this to check that process is completed or not ,if completed not check other wise check it

        int st=0;
        int tot=0;
        float avgwt=0;
        float avgta=0;

        //loop to get the arrival time and burst time
        for(int i=0;i<n;i++)
        {
            System.out.println("Enter process" + (i+1)+ "arrival time: ");
            at[i]=sc.nextInt();
            System.out.println("Enter process" + (i+1)+ "brust time: ");
            bt[i]=sc.nextInt();
            pid[i]=i+1;
            f[i]=0;  //initialy all process incomplete '0'
        }
        
        while(true)
        {
            int c=n; // c take the count of all process
            int min=Integer.MAX_VALUE;

            if(tot==n)
            {
                break;
            }
            for(int i=0;i<n;i++)
            {
                if((at[i]<=st)&&(f[i]==0)&&(bt[i]<min))
                {
                    min=bt[i];
                    c=i;
                }

            }
            if(c==n)
               {
                st++;
               }
               else {
                ct[c]=st+bt[c];
                st +=bt[c];
                ta[c]=ct[c]-at[c];
                wt[c]=ta[c]-bt[c];
                f[c]=1;
                pid[tot]=c+1;
                tot++;
               }
        }
         System.out.println("\npid   arrival   brust   complete   turn  waiting");
        for(int i=0;i<n;i++)
        {
            avgwt+= wt[i];
            avgta+= ta[i];
            System.out.println(pid[i]+"\t\t"+at[i]+"\t\t"+bt[i]+"\t\t"+ct[i]+"\t\t"+ta[i]+"\t\t"+wt[i]);
        }
        System.out.println ("\naverage tat is "+ (float)(avgta/n));
        System.out.println ("average wt is "+ (float)(avgwt/n));
        sc.close();
        for(int i=0;i<n;i++)
        {
            System.out.print(pid[i] + " ");
        }

    }

}
