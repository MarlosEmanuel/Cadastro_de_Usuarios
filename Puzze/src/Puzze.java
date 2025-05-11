public class Puzze {
    private int[][] board;
    private int emptyX, emptyY;

    // A solução esperada para o jogo
    private static final int[][] SOLUTION = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 0}  // O 0 representa o "null"
    };

    public Puzze() {
        // Inicialização do tabuleiro com o estado inicial
        this.board = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 0}
        };
        // Localizando o índice do "null" (0)
        this.emptyX = 2;
        this.emptyY = 2;
    }

    public boolean isSolved() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] != SOLUTION[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean move(int x, int y) {
        // Verifique se a posição está ao lado do "null"
        if (Math.abs(x - emptyX) + Math.abs(y - emptyY) == 1) {
            // Troca as posições
            board[emptyX][emptyY] = board[x][y];
            board[x][y] = 0;
            emptyX = x;
            emptyY = y;
            return true;
        }
        return false;
    }

    public void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Puzze puzzle = new Puzze();
        puzzle.printBoard();
        System.out.println("Is solved: " + puzzle.isSolved());

        // Exemplo de movimento
        if (puzzle.move(2, 1)) {
            System.out.println("Moveu com sucesso!");
        }

        puzzle.printBoard();
        System.out.println("Is solved: " + puzzle.isSolved());
    }
}
