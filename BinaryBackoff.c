// test commit froom new machine
#include<stdio.h>
#include<stdlib.h>
#include<time.h>
#include<string.h>
int main()
{
int C = 12, D = 4, E = 8;
int counter = 0 ;
double slot_time = 0.00000166, CW ;
int CWmax = 1024, CWmin = 32;
double BT, G, Total_Backoff_time = 0;
// C => successful sending times
// D => Quickly decrease the the CW
// E => linearly inc the CW
// G => Threshold quantity
// CW => Minimun Contention Window Size
// BT => Backoff time
printf("Enter the Curr_BW (CW) by user  :  ");
	scanf("%lf" , &CW) ;

//printf("Enter the CWmax  :  ");
//	scanf("%d" , &CWmax);
FILE *fp;
   char *f_name = "aaa.txt";
   char ch;
   
   fp = fopen(f_name, "r+");
   if (fp == NULL) {
      printf("%s does not exists \n", f_name);
      return;
   } else {
      printf("%s: opened in read mode.\n\n", f_name);
   
   }
   
	while ((ch = fgetc(fp) )!= EOF) {		
	// end-of-file
    
	if(ch == '0' || ch == '1'){
	   printf("frame %c \n ", ch);	
	
	}    
if(ch == '1' || ch =='0')
{
	

if(counter < C){
	
	counter = counter + 1;
	printf("counter value is : %d\n " , counter);
	CW = CW / D;
	printf(" The CW is : %0.8f\n" , CW);
	
	G = 0.125*CWmin ;
	printf("Value of G [Threshold Quantity] is : %0.8f\n" , G);
	
	if(CW < G){
	CW = G;
		BT = CW * slot_time;
		printf(" => The Backoff Time is : %0.8f\n" , BT);
		
	}else{
		BT = CW * slot_time;
		printf(" => The Backoff Time is : %0.8f\n" , BT);
	}
}
else{
	counter = 1;
	CW = CW + (E * CWmin) ;
		
		printf(" The CW is : %lf\n" , CW );
	
	if(CW > CWmax){
		CW = CWmax;
		
		BT = CW *slot_time ;
		printf(" => The Backoff Time is : %0.8f\n" , BT);
		
	}else{
		
		BT = CW *slot_time ;
		printf(" => The Backoff Time is : %0.8f\n" , BT);	
	}	
}
	
}
if(ch == '1' || ch =='0'){
Total_Backoff_time = Total_Backoff_time + BT;		
printf("\n");
printf("=>  Total Back_off time for frame is :  %0.8f \n " ,Total_Backoff_time);
printf("\n\n");	
}	
}
}
