import java.util.Random;
import java.util.Scanner;

public class Game {
    private Scanner sc;
    private GameLogic gl;
    private Field fd;
	private int answer = 0;


    public Game() {
        sc = new Scanner(System.in);
        fd = new Field();
        gl = new GameLogic();
        playGame();
    }

    public void playGame() {
        do {
            fd.printField();
            moveOfPlayer();
	        if((answer = gl.checkForWin(fd, fd.MARK_PLAYER)) != 0 ) {
		        fd.printField();
		        System.out.println("Player is a winner");
		        break;
	        }
	        if(fd.checkForEmptyCells() == 0) {
		        System.out.println("\nDrawn game");
	        }

	        fd.printField();
	        moveOfComp();
	        if((answer = gl.checkForWin(fd, fd.MARK_COMP)) != 0 ) {
		        fd.printField();
		        System.out.println("Computer is a winner");
		        break;
	        }
        } while (answer == 0 || fd.checkForEmptyCells() != 0);
    }

    private void moveOfComp() {
        int randR, randC;
        boolean check = false;

        //Check and select empty cells in Random ROW for computer
        do {
            check = false;
            randR = new Random().nextInt(3);
            if(fd.emptyCell(randR, fd.FIELD_SIZE) == true) {
                check = true;
            }
        } while(check == false);

        //Randomize, while random cell will be empty for comp move
        do {
            check = false;
            randC = new Random().nextInt(3);
            if(fd.gameField[randR][randC] == ' ') {
                fd.gameField[randR][randC] = fd.MARK_COMP;
                check = true;
            }
        } while(check == false);
    }

    public void moveOfPlayer() {
        int x, y;
        boolean check = false;
        do {
            System.out.print("Enter row: ");
            x = sc.nextInt();
            System.out.print("Enter column: ");
            y = sc.nextInt();

            if(x > fd.FIELD_SIZE || y > fd.FIELD_SIZE || fd.gameField[x-1][y-1] != ' ') {
                System.out.println("Incorrect coordinates. Try again.");
            } else if(fd.gameField[x-1][y-1] == ' ') {
                fd.gameField[x-1][y-1] = fd.MARK_PLAYER;
                check = true;
            }
        } while(check == false);
    }
    
}


