package Session1;

import java.util.Scanner;

public class FirstComeFirstServe {
	
	//function to simulate First Come First Serve(FCFS).
	public int [][]getFCFS(int arrivalTime[], int jobSize[]) {
		int output[][]=new int[arrivalTime.length][5];
		/*
		 * output[][0] stores - Job detail
		 * output[][1] stores - Job Arrival Time detail
		 * output[][2] stores - Job Waiting Time detail
		 * output[][3] stores - Job Starts At detail
		 * output[][4] stores - Job Finish At detail
		 */
		int l=1, totalJobSize;
		output[0][2]=0; //Waiting Time of first job should be 0.
		totalJobSize=jobSize[0]; //Total job size is first initialiased with job size of first job.
		output[0][4]=jobSize[0];
		output[0][3]=arrivalTime[0];
		for (int i = 0; i < arrivalTime.length; i++) {
			output[i][0]=l++; //to initialise the Job column in output array.
			output[i][1]=arrivalTime[i]; //to initialize Job Arrival Time column in output array.
		}
		for (int i = 1; i < arrivalTime.length; i++) {
			output[i][2]=totalJobSize-arrivalTime[i]+1;
			totalJobSize+=jobSize[i];
			output[i][3]=output[i-1][4]+1;
			
			//if there is time gap between finishing of last job and arrival of present job, 
			//i.e. waiting time negative
			if (output[i][2]<0) {
				output[i][2]=0; //waiting time should be 0.
				output[i][3]=arrivalTime[i];
			}
			output[i][4]=output[i][3]+jobSize[i]-1;
		}
		
		return output;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner=new Scanner(System.in);
		int job; //for storing no. of jobs.
		System.out.print("Enter the no. of Jobs  :\t");
		job=scanner.nextInt();
		int[] arrivalTime=new int[job];
		//to input arrival time of the jobs.
		for (int i = 0; i < job; i++) {
			System.out.print("Enter the Arrival Time of Job "+(i+1)+"  :\t");
			arrivalTime[i]=scanner.nextInt();
		}
		
		int[] jobSize=new int[job];
		//to input jobs sizes of respective jobs.
		for (int i = 0; i < job; i++) {
			System.out.print("Enter the Job Size of Job "+(i+1)+"  :\t");
			jobSize[i]=scanner.nextInt();
		}
		
		int output[][]=new int[job][5]; //to hold the output table of FCFS.
		output=new FirstComeFirstServe().getFCFS(arrivalTime, jobSize);
		
		System.out.print("\nJob\tJAT\tJWT\tJSA\tJFA\n");
		for (int i = 0; i < job; i++) {
			for (int j = 0; j < output[i].length; j++) {
				System.out.print(output[i][j]+"\t");
			}
			System.out.print("\n");
		}
		
		System.out.print("\n(JAT-Job Arrival Time, JWT-Job Waiting Time, JSA-Job Start At, JFA-Job Finish At)");
		
		scanner.close();
	}

}
