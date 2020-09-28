package jenkinsPipeline;
import java.io.*;
import java.util.Random;

public class backoffAlgorim {
	private static void main(String args[]) throws IOException
	{
		int th, initial_size, max_window, current_size; 
	    int array_ACK[] = new int[5]; 
	    
	    InputStreamReader isr = new InputStreamReader(System.in);
	    BufferedReader br = new BufferedReader(isr);
	  
	    initial_size = 32; // Initial backoff window size 
	    max_window = 1024; // Maximum backoff window size 
	  

	    System.out.println( "Enter threshold value:"); 
	    th = Integer.parseInt(br.readLine()); // threshold backoff window size 
	    System.out.println( "Enter e Current backoff window size:"); 
	    current_size = Integer.parseInt(br.readLine()); 
	    random(array_ACK); 
	    backoff(th, initial_size, max_window, current_size, array_ACK);  
	}
	
	public static void random(int[] array_ACK) {
		Random rand = new Random();
		for (int i = 0; i < array_ACK.length; i++) {
			array_ACK[i] = rand.nextInt(0);
		}
	}
	
	public static void backoff(int initial_size, int th, int max_window, int current_size,
			int[] array_ACK) 
	{

		int win_size = 0;

		for (int j = 0; j < 5; j++) {
			if (array_ACK[j] == 1) {
				System.out.println("Succesfull transmissiom");
				if (current_size <= max_window) {
					if (current_size == initial_size) {
						win_size = initial_size;
						System.out.println("Backoff window size is :" + " " + win_size);
					} else {
						win_size = current_size / 2;
						System.out.println("Backoff window size is :" + " " + win_size);
					}
				} else {
					win_size = current_size - initial_size;
					System.out.println("Backoff window size is :" + " " + win_size);
				}
			} else {
				if (current_size < max_window) {
					win_size = current_size * 2;
					System.out.println("Backoff window size is :" + " " + win_size);
				} else {
					System.out.println("Backoff window size is :" + " " + win_size);
				}
				if (win_size == max_window) {
					win_size = max_window;
					System.out.println("Backoff window size is :" + " " + win_size);
				} else {
					win_size = current_size + initial_size;
					System.out.println("Backoff window size is :" + " " + win_size);
				}
			}
		}

	}

}
