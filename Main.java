import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Board board = new Board();

        board.placeBoats();
        board.displayIBoard();

        while (board.move())
        {
            board.displayBoard();
        }
    }
}