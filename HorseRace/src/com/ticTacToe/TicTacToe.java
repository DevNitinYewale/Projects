package com.ticTacToe;

public class TicTacToe{

// inside the board array of size 17*17,
// the mapping of indexes 0,1,2 is given below
public static int mapping[] = {2, 8, 14};

// prints the board
void printBoard(char board[][]){
	int i, j;
	for (i=0; i<17; i++){
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
			i++;j--;
		}
		else{
			win = false;
			break;	
		}
	}	

	return win;
}

}