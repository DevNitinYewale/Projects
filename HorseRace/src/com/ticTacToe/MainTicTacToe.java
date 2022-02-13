package com.ticTacToe;

import java.util.Scanner;

public class MainTicTacToe {

public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	TicTacToe t1=new TicTacToe();
	// Create a 17x17 array of characters and put ' ' in each element.
	char board[][]=new char[17][17];
	int i,j;
	for(i=0;i<17;i++){
		for(j=0;j<17;j++){
			board[i][j] = ' ';
		}
	}

	// a loop to make the first horizontal line
	for(j=0;j<17;j++){
		board[5][j] = '-';
	}	

	// 	a loop to make the second horizontal line
	for(j=0;j<17;j++){
		board[11][j] = '-';
	}

	// loop to make the first vertical line
	for(i=0;i<17;i++){
		board[i][5] = '|';
	}

	// 	loop to make the second vertical line
	for(i=0;i<17;i++){
		board[i][11] = '|';
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
				System.out.print("\tValue out of range!! Enter values within the range(1-N)!!\t");
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
