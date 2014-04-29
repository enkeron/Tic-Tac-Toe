public class GameLogic {
	private char markForCheck;
	private int numberOfMark;
	private boolean answer;
	private Field field;

	public void setMarkForCheck(char markForCheck) {
		this.markForCheck = markForCheck;
	}

	public int checkForWin(Field fd, char mark) {
		setMarkForCheck(mark);
		field = fd;
		int answerForWin = 0;
		if(checkForWinCol() == true || checkForWinRow() == true || checkForWinDiag() == true) {
			answerForWin = 1;
		}
		return answerForWin;

	}

	boolean checkForWinDiag() {
		numberOfMark = 0;
		int i = 0, j;
		answer = false;
    
		//check for win main diagonal
		while(i < field.FIELD_SIZE) {
			if (field.gameField[i][i] == markForCheck) {
				numberOfMark++;
			}

			if(numberOfMark == 3) {
				answer = true;
				System.out.println("\nTrue\n");
			}

			i++;
		}

		//check for win not main diagonal
		numberOfMark = 0;
		i = 0; j = field.FIELD_SIZE - 1;
		while(i < field.FIELD_SIZE) {
			if (field.gameField[i][j] == markForCheck) {
				numberOfMark++;
			}

			if(numberOfMark == 3) {
				answer = true;

			}

			i++;
			j--;
		}
		return answer;
	}

	private boolean checkForWinRow() {
		numberOfMark = 0;
		answer = false;

		for(int i = 0; i < field.FIELD_SIZE; i++) {
			for (int j = 0; j < field.FIELD_SIZE; j++) {
				if (field.gameField[i][j] == markForCheck) {
					numberOfMark++;
				}
			}
			if(numberOfMark == 3) {
				answer = true;
				System.out.println("\nTrue\n");
				break;
			}
			numberOfMark = 0;
		}


		return answer;

	}


	private boolean checkForWinCol() {
		numberOfMark = 0;

		for(int i = 0; i < field.FIELD_SIZE; i++) {
			for (int j = 0; j < field.FIELD_SIZE; j++) {
				if (field.gameField[j][i] == markForCheck) {
							numberOfMark++;
				}
			}

			if(numberOfMark == 3) {
				answer = true;
				System.out.println("\nTrue\n");
			}
			numberOfMark = 0;
		}



		return answer;

	}
}
