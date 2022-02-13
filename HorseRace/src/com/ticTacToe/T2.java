package com.ticTacToe;

import java.util.Scanner;

public class T2{

// inside the board array of size 11*17,
// the mapping of indexes 0,1,2 is given below
public static int mapping[] = {2, 6, 10};

// prints the board
void printBoard(char board[][]){
	int i, j;
	for (i=0; i<11; i++){
		for (j=0; j<17; j++) {
			System.out.print(board[i][j]);
		}
		System.out.print("\n");
	}
}


// check whether a player has won the match
public static boolean checkWin(char board[][], int r, int c, char player){

	int i=0;
	int j=0;
	boolean win = true;

	//1. check row
	while(j<3){
		int x = mapping[r];
		int y = mapping[j];
		if(board[x][y] == player){
			j++;
		}
		else{
			win = false;
			break;
		}
	}
	if(win){
		return true;
	}

	//2. check column
	win = true;
	while(i<3){
		int x = mapping[i];
		int y = mapping[c];
		if(board[x][y] == player){
			i++;
		}
		else{
			win = false;
			break;
		}
	}

	if(win){
		return true;
	}

	//3. check first diagonal
	win = true;
	i=0;j=0;
	while(i<3){
		int x = mapping[i];
		int y = mapping[j];
		if(board[x][y] == player){
			i++;
			j++;
		}
		else{
			win = false;
			break;
		}
	}

	if(win){
		return true;
	}

	//3. check second diagonal
	win = true;
	i=0;
	j=2;
	while(i<3){
		int x = mapping[i];
		int y = mapping[j];
		if(board[x][y] == player){
			i++;
			j--;
		}
		else{
			win = false;
			break;	
		}
	}	

	return win;
}
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	T2 t1=new T2();
	// Create a 17x17 array of characters and put ' ' in each element.
	char board[][]=new char[11][17];
	int i,j;
	for(i=0;i<11;i++){
		for(j=0;j<11;j++){
			board[i][j] = ' ';
		}
	}

	// a loop to make the first horizontal line
	for(j=0;j<14;j++){
		board[3][j] = '-';
	}	

	// 	a loop to make the second horizontal line
	for(j=0;j<11;j++){
		board[7][j] = '-';
	}

	// loop to make the first vertical line
	for(i=0;i<11;i++){
		board[i][4] = '|';
	}

	// 	loop to make the second vertical line
	for(i=0;i<11;i++){
		board[i][9] = '|';
	}

	t1.printBoard(board);

	int counter = 1;

	for(counter = 1; counter <= 9; counter++){
		char player = 'x';
		if(counter%2 == 1){
			System.out.print("\n**** Player 1\'s(X) turn ****\n");
		}
		else{
			System.out.print("\n**** Player 2\'s(O) turn ****\n");
			player = 'o';
		}


		int flag = 1;
		int r,c;
		do{
			System.out.print("\tEnter row and column where you want to place: ");

			r=sc.nextInt();
			c=sc.nextInt();
			if(r<1 || r>3 || c<1 || c>3){
				System.out.print("\tValue out of range!!\n Enter values within the range(1-N)!!\t");
			}
			else{
    
				int x = t1.mapping[r-1];
				int y = t1.mapping[c-1];
				if(board[x][y] != ' '){
					System.out.print("\tThat position is already filled!! TRY ANOTHER PLACE!!!\n\n");
				}
				else{	
					flag = 0;
				}
			}
		}while(flag == 1);


		int x = t1.mapping[r-1];
		int y = t1.mapping[c-1];
		//print 
		board[x][y] = player;
		t1.printBoard(board);

		boolean win = t1.checkWin(board, r-1, c-1, player);
		if(win){
			if(counter%2 == 1){
				System.out.print("\n\n**** Player 1 WON THE MATCH ****\n");
			}
			else{
				System.out.print("\n\n**** Player 2 WON THE MATCH ****\n");
			}	
			break;
		}
	}

	if(counter>9){
    System.out.print("\n**** THE MATCH WAS A DRAW ****\n");
	}
}

}