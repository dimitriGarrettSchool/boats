import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Board board = new Board();

        board.placeBoats();
        board.displayIBoard();

        while (true)
        {
            if (board.move())
                board.displayBoard();
            else {
                if (SafeInput.getYN(new Scanner(System.in), "Do you want to play again? "))
                {
                    board.placeBoats();
                }

                else {
                    break;
                }
            }
        }
    }
}