package slowstart;

import java.util.Random;
import java.util.Scanner;


public class Main_Activity {
	public static void main(String[] args) {
		int Threshhold, initital_backoff_size, wi, max_backoff_size;
		initital_backoff_size = 32;
		max_backoff_size = 1024;
		
		int array_ACK[] = new int[5];

		System.out.println("Enter the Threshhold value");
		Threshhold = in.nextInt();
		System.out.println("Enter the currentbackoff");
		currentbackoff = in.nextInt();
		random_input(array_ACK);
		Slow_Start(Threshhold, max_backoff_size, currentbackoff, initital_backoff_size, array_ACK);
	}

	public static void Slow_Start(int Threshhold, int initial_backoff_size, int max_backoff_size, int currentbackoff,
			int[] array_ACK) {

	}

	public static void random_input(int[] array_ACK) {
		Random rand = new Random();
		for (int i = 0; i < array_ACK.length; i++) {
			array_ACK[i] = rand.nextInt(1);
		}
	}
}

