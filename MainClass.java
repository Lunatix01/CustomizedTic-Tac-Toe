import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;

public class MainClass {
	static String  player1 = "X";
	static String player2 ="O";
	static boolean playing = true;
	static boolean first_turn;
	static int player1_points=0;
	static int player2_points=0;
	public static void Board_() {
		Scanner Board1 = new Scanner(System.in);
		int count = 1;
		int _board = Board1.nextInt(); // SIZE BOARD
		String Board[][] = new String[_board][_board];
		String  copyB[][] = null;
		for (int i = 0; i < Board.length; i++) {
			System.out.print("|");

			for (int j = 0; j < Board.length; j++) {
				Board[i][j] = "" + count++;

				System.out.printf("%2s|", Board[i][j]);
             copyB=Board;
            
			}
			System.out.println();

		}
		
		for (int i = 0; i <copyB.length; i++) {
			for (int j = 0; j < copyB.length; j++) {
		      if(first_turn==false) {
			first_turn=true;
			updatedBoardX(copyB);
		}
		      else if(first_turn==true) {
			first_turn=false;
			updatedBoardX(copyB);
		}
			}
		
		}
		//horizontal 
		for (int i = 0; i < copyB.length; i++) {
			for (int j = 0; j < copyB.length; j++) {
				if(j+2!=copyB.length &&j+1!=copyB.length && copyB[i][j]=="X" && copyB[i][j+1]=="X" &&copyB[i][j+2]=="X") {	
					player1_points++;
					copyB[i][j]="D";
					copyB[i][j+1]="D";
					copyB[i][j+2]="D";	
					
				}
                if(j+2!=copyB.length &&j+1!=copyB.length && copyB[i][j]=="O" && copyB[i][j+1]=="O" &&copyB[i][j+2]=="O") {
                	copyB[i][j]="l";
					copyB[i][j+1]="l";
					copyB[i][j+2]="l";
					player2_points++;
				}
			}
		}
		for (int i = 0; i < copyB.length; i++) {
			for (int j = 0; j < copyB.length; j++) {
				if(copyB[i][j]=="D") {copyB[i][j]="X";copyB[i][j+1]="X";copyB[i][j+2]="X";}
                if(copyB[i][j]=="l") {copyB[i][j]="O";copyB[i][j+1]="O";copyB[i][j+2]="O";}
			}
		}
		//vertical
		for (int i = 0; i < copyB.length; i++) {
			for (int j = 0; j < copyB.length; j++) {
		 if(i+2!=copyB.length &&i+1!=copyB.length && copyB[i][j]=="X" && copyB[i+1][j]=="X" &&copyB[i+2][j]=="X") {	
				player1_points++;
				copyB[i][j]="N";
				copyB[i+1][j]="N";
				copyB[i+2][j]="N";	
				
			}
         if(i+2!=copyB.length &&i+1!=copyB.length && copyB[i][j]=="O" && copyB[i+1][j]=="O" &&copyB[i+2][j]=="O") {
         	copyB[i][j]="P";
				copyB[i+1][j]="P";
				copyB[i+2][j]="P";
				player2_points++;
			}
         }
			}
		for (int i = 0; i < copyB.length; i++) {
			for (int j = 0; j < copyB.length; j++) {
				if(copyB[i][j]=="N") {copyB[i][j]="X";copyB[i+1][j]="X";copyB[i+2][j]="X";}
                if(copyB[i][j]=="P") {copyB[i][j]="O";copyB[i+1][j]="O";copyB[i+2][j]="O";}
			}
		}
		//diagonal
		for (int i = 0; i < copyB.length; i++) {
			for (int j = 0; j < copyB.length; j++) {
		 if(j+2!=copyB.length && j+1!=copyB.length &&i+2!=copyB.length && i+1!=copyB.length && copyB[i][j]=="X" && copyB[i+1][j+1]=="X" &&copyB[i+2][j+2]=="X") {	
				player1_points++;
				copyB[i][j]="N";
				copyB[i+1][j+1]="N";
				copyB[i+2][j+2]="N";	
				
			}
         if(j+2!=copyB.length &&j+1!=copyB.length &&i+2!=copyB.length &&i+1!=copyB.length  && copyB[i][j]=="O" && copyB[i+1][j+1]=="O" &&copyB[i+2][j+2]=="O") {
         	    copyB[i][j]="P";
				copyB[i+1][j+1]="P";
				copyB[i+2][j+2]="P";
				player2_points++;
			}
         }
			}
		for (int i = 0; i < copyB.length; i++) {
			for (int j = 0; j < copyB.length; j++) {
				if(copyB[i][j]=="N") {copyB[i][j]="X";copyB[i+1][j+1]="X";copyB[i+2][j+2]="X";}
                if(copyB[i][j]=="P") {copyB[i][j]="O";copyB[i+1][j+1]="O";copyB[i+2][j+2]="O";}
			}
		}
		//reversed diagonal 
		for (int i = 0; i < copyB.length; i++) {
			for (int j = 0; j < copyB.length; j++) {
		 if(j-2>=0 && j-1>=0 && i+2!=copyB.length &&i+1!=copyB.length && copyB[i][j]=="X" && copyB[i+1][j-1]=="X" &&copyB[i+2][j-2]=="X") {	
				player1_points++;
				copyB[i][j]="N";
				copyB[i+1][j-1]="N";
				copyB[i+2][j-2]="N";	
				
			}
         if(j-2>=0 && j-1>=0 &&i+2!=copyB.length &&i+1!=copyB.length && copyB[i][j]=="O" && copyB[i+1][j-1]=="O" &&copyB[i+2][j-2]=="O") {
         	    player2_points++;
         	    copyB[i][j]="P";
				copyB[i+1][j-1]="P";
				copyB[i+2][j-2]="P";
				
			}
         }
			}
		
		
		System.out.println(player1_points);
		System.out.println(player2_points);	
	}

	public static int roll1() {

		int roll1 = (int) (Math.random() * 6 + 1); // random1

		return roll1;
	}

	public static int roll2() {

		int roll2 = (int) (Math.random() * 6 + 1); // random2
		return roll2;
	}

	public static void compareDice() throws InterruptedException {
		Scan();
		int x = roll1();
		System.out.println(x);
		Scan();
		int z = roll2();
		System.out.println(z);
		if (x > z) {
			System.out.println("its first player's turn");
			first_turn = true;
		} else if (x < z) {
			System.out.println("its second player's turn ");
			first_turn = false;
		} else if (x == z) {
			System.out.println("DRAW!!\n" + "roll again" + "\n3");
			TimeUnit.SECONDS.sleep(1);
			System.out.println("2");
			TimeUnit.SECONDS.sleep(1);
			System.out.println("1");
			TimeUnit.SECONDS.sleep(1);
			compareDice();

		}
	}

	public static String Scan() {
		System.out.println("type 'ROLL'");
		Scanner give = new Scanner(System.in);
		String Scanned = give.nextLine();
		if (!(Scanned.equalsIgnoreCase("roll"))) {
			Scan();
		}
		return Scanned;
	}

	public static void main(String[] args) throws InterruptedException {
		Scanner name = new Scanner(System.in);
		System.out.print("Enter Your name :");// first name
		String first_player = name.nextLine();
		if (first_player.equals("")) { // default A

			System.out.println("player1 ");
		}
		System.out.print("Enter Your name: "); // second name
		String second_player = name.nextLine();
		if (second_player.equals("")) { // default B

			System.out.println("player2 ");
		}
		System.out.println("first player is "+first_player);
		System.out.println("second player is "+second_player);

		compareDice();
		System.out.print("Enter the size of your Board: ");
		Board_();
		if(player1_points>player2_points) {
			System.out.println("the winner is: " + first_player);
		}
		else if(player1_points<player2_points) {
			System.out.println("the winner is: " + second_player);
		}
		else if(player1_points==player2_points) {
			System.out.println("TIE");
		}
		
	}
	public static void updatedBoardX(String copyB[][]) {
		 Scanner Xz = new Scanner(System.in);
		 String chooseNum =Xz.next();
		for (int i = 0; i < copyB.length; i++) {
			System.out.print("|");
			for (int j = 0; j < copyB[i].length; j++) {
			 if(chooseNum.equals(copyB[i][j])) {
				if(first_turn == true) {
				 copyB[i][j]=player1;
				}
				else {
				 copyB[i][j]=player2;
				}
			 }
			 System.out.printf("%2s|", copyB[i][j]);
			
			}
			System.out.println();
			
		}
		
	}
}
