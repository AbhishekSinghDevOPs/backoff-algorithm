package slowstart;

import java.util.Random;
import java.util.Scanner;


public class Main_Activity {
	public static void main(String[] args) {
		int Threshhold, initital_backoff_size, wi, max_backoff_size;
		initital_backoff_size = 32;// can be changed 
		max_backoff_size = 1024;// can be changed 
		
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

		int backoff_win_size = 0;

		for (int j = 0; j < 5; j++) {
			if (array_ACK[j] == 1) {
				System.out.println("Succesfull transmissiom");
				if (currentbackoff <= max_backoff_size) {
					if (currentbackoff == initial_backoff_size) {
						backoff_win_size = initial_backoff_size;
						System.out.println("Backoff window size is :-" + " " + backoff_win_size);
					} else {
						backoff_win_size = currentbackoff / 2;
						System.out.println("Backoff window size is :-" + " " + backoff_win_size);
					}
				} else {
					backoff_win_size = currentbackoff - initial_backoff_size;
					System.out.println("Backoff window size is :-" + " " + backoff_win_size);
				}
			} else {
				if (currentbackoff < max_backoff_size) {
					backoff_win_size = currentbackoff * 2;
					System.out.println("Backoff window size is :-" + " " + backoff_win_size);
				} else {
					System.out.println("Backoff window size is :-" + " " + backoff_win_size);
				}
				if (backoff_win_size == max_backoff_size) {
					backoff_win_size = max_backoff_size;
					System.out.println("Backoff window size is :-" + " " + backoff_win_size);
				} else {
					backoff_win_size = currentbackoff + initial_backoff_size;
					System.out.println("Backoff window size is :-" + " " + backoff_win_size);
				}
			}
		}

	}

	public static void random_input(int[] array_ACK) {
		Random rand = new Random();
		for (int i = 0; i < array_ACK.length; i++) {
			array_ACK[i] = rand.nextInt(0);
		}
	}
}

