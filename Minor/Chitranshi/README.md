#include <cstdlib> 
#include <iostream> 
#include <math.h> 
#include <random> 
#include <string> 
#include <time.h> 

using namespace std; 

void signal(int array_ACK[]) 
{ 
	srand(time_t(0)); 
	for (int i = 0; i < 5; i++) { 
		array_ACK[i] = rand() % 2; 
	} 
} 

void Slow_Start_Backoff(int Wm, int Wo, int Wn, 
						int Wi, int array_ACK[]) 
{ 
	// Taking ACK Binary values in 
	// array by user one by one 

	// backoff_win_size defines 
	// backoff window size 

	int backoff_win_size = 0; 

	// Printing of backoff window size takes place 

	for (int j = 0; j < 5; j++) { 
		if (array_ACK[j] == 1) { 
			cout << "Successful transmission" << endl; 
			if (Wi <= Wn) { 
				if (Wi == Wo) { 
					backoff_win_size = Wo; 
					cout << "Backoff Window Size is:-->"
							<< backoff_win_size << endl; 
				} 
				else { 
					backoff_win_size = Wi / 2; 
					cout << "Backoff Window Size is:-->"
							<< backoff_win_size << endl; 
				} 
			} 
			else { 
				backoff_win_size = Wi - Wo; 
				cout << "Backoff Window Size is:-->"
						<< backoff_win_size << endl; 
			} 
		} 
		else { 
			if (Wi < Wn) { 
				backoff_win_size = Wi * 2; 
				cout << "Backoff Window Size is:-->"
						<< backoff_win_size << endl; 
			} 
			else { 
				cout << "Frame lost due to collision"
						<<" or interference"; 
			} 
			if (backoff_win_size == Wn) { 
				backoff_win_size = Wn; 
				cout << "Backoff Window Size is:-->"
						<< backoff_win_size << endl 
							<< endl; 
			} 
			else { 
				backoff_win_size = Wi + Wo; 
				cout << "Backoff Window Size is:-->"
						<< backoff_win_size << endl; 
			} 
		} 
	} 
} 

// Driver Code 
int main() 
{ 
	int Wm, Wo, Wn, Wi; 
	int array_ACK[5]; 

	Wo = 32; // Initial backoff window size 
	Wn = 1024; // Maximum backoff window size 

	// Wi defines the current backoff window size 

	cout << "Enter the Threshold value:-->"; 
	cin >> Wm; // Threshold backoff window size 
	cout << "Enter the Current backoff window size:-->"; 
	cin >> Wi; 
	signal(array_ACK); 
	Slow_Start_Backoff(Wm, Wo, Wn, Wi, array_ACK); 

	return 0; 
} 

