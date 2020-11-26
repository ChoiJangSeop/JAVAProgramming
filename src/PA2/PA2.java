package PA2;

//2019310036 √÷¿Âº∑

import java.util.Scanner;
import java.io.*;

class PushShipException extends Exception { PushShipException() {} }
class BombInputException extends Exception { BombInputException() {} }
class ModeInputException extends Exception { ModeInputException() {} }
class HitException extends Exception { HitException() {} }

class Ship {
	int size;
	int[] position;
	char type;

	Ship() {
		this.position = new int[2];
	}
	
}

class Carrier extends Ship {
	
	Carrier() {
		size = 6;
		type = 'A';
	}
}

class Battleship extends Ship {
		
	Battleship() {
		size = 4;
		type = 'B';
	}	
}


class Submarine extends Ship {
	
	Submarine() {
		size = 3;
		type = 'S';
	}	
}

class Destroyer extends Ship {
	
	Destroyer() {
		size = 3;
		type = 'D';
	}	
}

class Boat extends Ship {
	
	Boat() {
		size = 2;
		type = 'P';
	}	
}

class Sea {
	
	Carrier ShipC;
	Battleship ShipB1;
	Battleship ShipB2;
	Submarine ShipS1;
	Submarine ShipS2;
	Destroyer ShipD;
	Boat ShipP1;
	Boat ShipP2;
	Boat ShipP3;
	Boat ShipP4;
	
	char[] SeaBoard;
	
	Sea() {
		
		ShipC = new Carrier();
		ShipB1 = new Battleship();
		ShipB2 = new Battleship();
		ShipS1 = new Submarine();
		ShipS2 = new Submarine();
		ShipD = new Destroyer();
		ShipP1 = new Boat();
		ShipP2 = new Boat();
		ShipP3 = new Boat();
		ShipP4 = new Boat();
		
		SeaBoard = new char[100];				
		
		for(int i=0; i<100; ++i) {
			SeaBoard[i] = '-';
		}
	}
	
	void PushShip(Ship x) throws PushShipException {
		
		
		int idx=0;
		int[][] possiblePosition = new int[201][2]; 
		
		for(int i=0; i<100; ++i) {
			
			if((i%10) > (10-x.size) || (i/10) > (10-x.size))
				continue;
			
			for(int j=0; j<x.size; ++j) {
				
				if (this.SeaBoard[i + j] != '-')
					break;
				
				if (j == x.size-1) {
					possiblePosition[idx][0] = i;
					possiblePosition[idx++][1] = 0;
				}
			}
			
			for(int k=0; k<x.size; ++k) {
				
				if (this.SeaBoard[i + 10*k] != '-')
					break;
				
				if (k == x.size-1) {
					possiblePosition[idx][0] = i;
					possiblePosition[idx++][1] = 1;
				}
			}
		}
		
		if (idx == 0) { throw new PushShipException(); }
		x.position = possiblePosition[(int)(Math.random()*idx)];
		
		if (x.position[1] == 0) {
			
			for(int j=0; j<x.size; ++j)
				this.SeaBoard[x.position[0] + j] = x.type;
			
			if(x.position[0] - 10 >= 0) {
				
				for(int j=0; j<x.size; ++j)
					this.SeaBoard[x.position[0] - 10 + j] = 'X';
				
			}
			
			if(x.position[0] + 10 < 100) {
				
				for(int j=0; j<x.size; ++j)
					this.SeaBoard[x.position[0] + 10 + j] = 'X';
				
			}
			
			if(x.position[0]/10 - 1 >= 0) { this.SeaBoard[x.position[0] - 1] = 'X'; }
			if(x.position[0]/10 + x.size < 10) { this.SeaBoard[x.position[0] + x.size] = 'X'; }
			
		}
		
		if (x.position[1] == 1) {
			
			for(int j=0; j<x.size; ++j)
				this.SeaBoard[x.position[0] + j*10] = x.type;
			
			if(x.position[0]/10 - 1 >= 0) {
				
				for(int j=0; j<x.size; ++j)
					this.SeaBoard[x.position[0] - 1 + j*10] = 'X';
				
			}
			
			if(x.position[0]/10 + 1 < 10) {
				
				for(int j=0; j<x.size; ++j)
					this.SeaBoard[x.position[0] + 1 + j*10] = 'X';
				
			}
			
			if(x.position[0] - 10 >= 0) { this.SeaBoard[x.position[0] - 10] = 'X'; }
			if(x.position[0] + 10*x.size < 100) { this.SeaBoard[x.position[0] + 10*x.size ] = 'X'; }
			
		}
	}
	
	
	void MakeBoard()  {
		
		try {
			this.PushShip(ShipC);
			this.PushShip(ShipB1);
			this.PushShip(ShipB2);
			this.PushShip(ShipS1);
			this.PushShip(ShipS2);
			this.PushShip(ShipD);
			this.PushShip(ShipP1);
			this.PushShip(ShipP2);
			this.PushShip(ShipP3);
			this.PushShip(ShipP4);
		} 
		catch(PushShipException e) { 
			for(int i=0; i<100; ++i)
				this.SeaBoard[i] = '-';
			this.MakeBoard(); 
		}	
	}
	
	boolean isFind(Ship x) {
		
		int pos = x.position[0];
		boolean result = true;
		
		if (x.position[1] == 0) {
			for (int i=0; i<x.size; ++i) {
				if (SeaBoard[pos+i] != 'F') { 
					result = false;
					break;
				}
			}
		}
		else {
			for (int i=0; i<x.size; ++i) {
				if (SeaBoard[pos+10*i] != 'F') { 
					result = false;
					break;
				}
			}
		}
		return result;
	}
	
	
}

public class PA2 {
	
	static void printBoard(char[][] board) {
		for (int i=0; i<12; i++) {
			for (int j=0; j<35; ++j) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}
	
	static void playSet(char mode, int bombNum) throws ModeInputException, BombInputException {
		
		if (bombNum <= 0) { throw new BombInputException(); }
		if (mode != 'D' && mode != 'd' && mode != 'r' && mode != 'R') { throw new ModeInputException(); }
	}
	
	static void posInput(int pX, int pY, char[][] Board) throws HitException {
		if (Board[pY+2][3*pX+5] == 'X') { throw new HitException(); }
	}
	
	
	public static void main(String[] args) throws IOException, FileNotFoundException {
		
		char[][] Board = new char[12][35];
		Sea MySea = new Sea();
		int score = 0;
		
		Scanner sc1 = new Scanner(System.in);
		String input = sc1.nextLine();
		String[] inList = new String[3];
		
		
		int bombNum = Integer.parseInt(input.split(" ")[0]);
		char mode = input.split(" ")[1].charAt(0);
		
		try { playSet(mode, bombNum); }
		catch (BombInputException e1) { 
			System.out.println("Number of Bomb should be positive."); 
			e1.printStackTrace(); System.exit(0); 
		}
		catch (ModeInputException e2) { 
			System.out.println("It is incorrect mode."); 
			e2.printStackTrace(); System.exit(0); 
		}
		
		if (input.split(" ").length == 2) { MySea.MakeBoard(); }
		else {
			try {
				BufferedReader br = new BufferedReader(new FileReader("C:/Users/√÷¿Âº∑/Desktop/" + input.split(" ")[2]));
				
				for (int j=0; j<10; ++j) {
					
					String line = br.readLine();
					
					for (int i=0; i<10; ++i) {
						MySea.SeaBoard[i+10*j] = line.charAt(i);
						System.out.print(line.charAt(i));
					}
					
					System.out.println();
				}
				br.close();
			} catch (FileNotFoundException e4) { 
				System.out.println("File is not Found! Board will made randomly.");
				MySea.MakeBoard(); 
			}
		}
		
		for (int i=0; i<5; ++i) {
			Board[0][i] = ' ';
			Board[1][i] = ' ';
		}
		
		char tmp = 'A';
		
		for (int i=5; i<35; i++) {
			Board[0][i] = tmp++;
			Board[1][i++] = '-';
			Board[0][i] = ' ';
			Board[1][i++] = ' ';
		}
		
		tmp = '1';
		
		for (int i=2; i<12; i++) {
			
			if (i != 11) { Board[i][0] = tmp++; Board[i][1] = ' '; }
			else { Board[i][0] = '1'; Board[i][1] = '0'; }
			Board[i][2] = ' ';
			Board[i][3] = '|';

			for (int j=4; j<35; j++) {
				Board[i][j] = ' ';
			}
		}
		
		/*
		Board[0] = "     A  B  C  D  E  F  G  H  I  J  ";
		Board[1] = "     -  -  -  -  -  -  -  -  -  -  ";
		Board[2] = "1  |                               ";
		Board[3] = "2  |                               ";
		Board[4] = "3  |                               ";
		Board[5] = "4  |                               ";
		Board[6] = "5  |                               ";
		Board[7] = "6  |                               ";
		Board[8] = "7  |                               ";
		Board[9] = "8  |                               ";
		Board[10] = "9  |                               ";
		Board[11] = "10 |                               ";
		*/
		
		for (int i=0; i<10; ++i) {
			for (int j=0; j<10; ++j) {
				if (MySea.SeaBoard[10*i+j] != 'X' && MySea.SeaBoard[10*i+j] != '-') {
					Board[i+2][3*j+5] = MySea.SeaBoard[10*i+j];
				}
			}
		}
		
		int cur=0;

		if (mode == 'd' || mode == 'D') {
			
			while (cur < bombNum) {
				
				Scanner sc3 = new Scanner(System.in);
				String pos = sc3.nextLine();
				int pX = pos.charAt(0) - 'A';
				int pY = pos.charAt(1) - '1';
				if (pos.length() == 3) { pY = 9; }
				
				while (true) {
					try { posInput(pX, pY, Board); break; }
					catch (HitException e3) {
						System.out.println("Try again");
						
						Scanner sc4 = new Scanner(System.in);
						pos = sc4.nextLine();
						pX = pos.charAt(0) - 'A';
						pY = pos.charAt(1) - '1';
						if (pos.length() == 3) { pY = 9; }
					}
				}
				
				if (Board[pY+2][3*pX+5] != ' ') {
					
					MySea.SeaBoard[10*pY+pX] = 'F';
					
					char tmp2 = Board[pY+2][3*pX+5];
					Board[pY+2][3*pX+5] = 'X';
					Board[pY+2][3*pX+6] = (char)(tmp2 - 'A' + 'a');
					
					System.out.println("Hit " + tmp2);
				}
				
				else {
					Board[pY+2][3*pX+5] = 'X';
					System.out.println("Miss");
				}
					
				printBoard(Board);
				++cur;
			}
			
		}
		
		else {
			while (cur < bombNum) {
				
				Scanner sc3 = new Scanner(System.in);
				String pos = sc3.nextLine();
				int pX = pos.charAt(0) - 'A';
				int pY = pos.charAt(1) - '1';
				if (pos.length() == 3) { pY = 9; }
				 
				
				if (Board[pY+2][3*pX+5] != ' ') {
					
					MySea.SeaBoard[10*pY+pX] = 'F';
					
					char tmp2 = Board[pY+2][3*pX+5];
					Board[pY+2][3*pX+5] = 'X';
					Board[pY+2][3*pX+6] = (char)(tmp2 - 'A' + 'a');
					
					System.out.println("Hit " + tmp2);
				}
				
				else {
					Board[pY+2][3*pX+5] = 'X';
					System.out.println("Miss");
				}
					
				++cur;
			}
			
			printBoard(Board);
		}
		
		if (MySea.isFind(MySea.ShipC)) { score += 6; }
		if (MySea.isFind(MySea.ShipB1)) { score += 4; }
		if (MySea.isFind(MySea.ShipB2)) { score += 4; }
		if (MySea.isFind(MySea.ShipS1)) { score += 3; }
		if (MySea.isFind(MySea.ShipS2)) { score += 3; }
		if (MySea.isFind(MySea.ShipD)) { score += 3; }
		if (MySea.isFind(MySea.ShipP1)) { score += 2; }
		if (MySea.isFind(MySea.ShipP2)) { score += 2; }
		if (MySea.isFind(MySea.ShipP3)) { score += 2; }
		if (MySea.isFind(MySea.ShipP4)) { score += 2; }
		
		System.out.println("Score " + score);

	}
}
