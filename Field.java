public class Field {
    static int FIELD_SIZE = 3;
    private static final char DEFAULT_VALUE = ' ';

    public static char MARK_PLAYER = 'x';
    public static char MARK_COMP = 'o';
    public char [][] gameField;

    public Field() {
        gameField = new char[FIELD_SIZE][FIELD_SIZE];
        for(int i = 0; i < FIELD_SIZE; i++) {
            for(int j = 0; j < FIELD_SIZE; j++) {
                gameField[i][j] = DEFAULT_VALUE;
            }
        }
    }

    public void printField() {
        for(int i = 0; i < FIELD_SIZE; i++) {
            for(int j = 0; j < FIELD_SIZE; j++) {
                System.out.print("[" + gameField[i][j] + "]");
            }
            System.out.println();
        }
    }

    public void setPoint(int x, int y, char point) {

    }

	public int checkForEmptyCells() {
		int emptyCells = 0;
		for(int i = 0; i < FIELD_SIZE; i++) {
			for(int j = 0; j < FIELD_SIZE; j++) {
				if (gameField[i][j] == ' ') {
					emptyCells++;
				}
			}
		}

		return emptyCells;
	}

    public boolean emptyCell(int x, int y) {
        boolean empty = false;
        int emptyCells = 0;
        for(int i = 0; i < y; i++) {
            if(gameField[x][i] == ' ') {
                emptyCells++;
            }
        }

        if(emptyCells != 0) {
            empty = true;
        }
        return  empty;
    }
}
