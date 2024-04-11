#include<stdio.h>
#include<stdlib.h>
#include<string.h>

	int main()
	{
		char wrd[] = "C A R R E G A N D O. . .";
		int length = strlen(wrd);
		
		for(int i = 0;i < length;i++)
		{
			_sleep(250);
			printf("%c", wrd[i]);
		}
	}