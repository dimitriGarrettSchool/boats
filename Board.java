import java.util.Random;

public class Board
{
    private char[][] board = new char[10][10];

    private static String to_string(char boardPos)
    {
        if (boardPos == '-') return "\uD83C\uDF0A";
        if (boardPos != '-') return "\u26F4";
        return "X";
    }

    public void clearBoard()
    {
        for (int y = 0; y < 10; ++y)
        {
            for (int x = 0; x < 10; ++x)
            {
                board[y][x] = '-';
            }
        }
    }

    private static Random random = new Random();

    private void place2()
    {
        int x = random.nextInt(9);
        int y = random.nextInt(10);

        // goes up and down
        if (random.nextBoolean())
        {
            int t = y;
            y = x;
            x = t;

            if (board[y][x] != '-' || board[y + 1][x] != '-')
            {
                place2(); return;
            }

            board[y][x] = '2';
            board[y + 1][x] = '2';
        }

        else
        {
            if (board[y][x] != '-' || board[y][x + 1] != '-')
            {
                place2(); return;
            }

            board[y][x] = '2';
            board[y][x + 1] = '2';
        }
    }
    private void place3()
    {
        int x = random.nextInt(8);
        int y = random.nextInt(10);

        // goes up and down
        if (random.nextBoolean())
        {
            int t = y;
            y = x;
            x = t;

            if (board[y][x] != '-' || board[y + 1][x] != '-' || board[y + 2][x] != '-')
            {
                place3(); return;
            }

            board[y][x] = '3';
            board[y + 1][x] = '3';
            board[y + 2][x] = '3';
        }

        else
        {
            if (board[y][x] != '-' || board[y][x + 1] != '-' || board[y][x + 2] != '-')
            {
                place3(); return;
            }

            board[y][x] = '3';
            board[y][x + 1] = '3';
            board[y][x + 2] = '3';
        }
    }

    private void place4()
    {
        int x = random.nextInt(7);
        int y = random.nextInt(10);

        // goes up and down
        if (random.nextBoolean())
        {
            int t = y;
            y = x;
            x = t;

            if (board[y][x] != '-' || board[y + 1][x] != '-' || board[y + 2][x] != '-' || board[y + 3][x] != '-')
            {
                place4(); return;
            }

            board[y][x] = '4';
            board[y + 1][x] = '4';
            board[y + 2][x] = '4';
            board[y + 3][x] = '4';
        }

        else
        {
            if (board[y][x] != '-' || board[y][x + 1] != '-' || board[y][x + 2] != '-' || board[y][x + 3] != '-')
            {
                place4(); return;
            }

            board[y][x] = '4';
            board[y][x + 1] = '4';
            board[y][x + 2] = '4';
            board[y][x + 3] = '4';
        }
    }

    private void place5()
    {
        int x = random.nextInt(6);
        int y = random.nextInt(10);

        // goes up and down
        if (random.nextBoolean())
        {
            int t = y;
            y = x;
            x = t;

            if (board[y][x] != '-' || board[y + 1][x] != '-' || board[y + 2][x] != '-' || board[y + 3][x] != '-' || board[y + 4][x] != '-')
            {
                place5(); return;
            }

            board[y][x] = '5';
            board[y + 1][x] = '5';
            board[y + 2][x] = '5';
            board[y + 3][x] = '5';
            board[y + 4][x] = '5';
        }

        else
        {
            if (board[y][x] != '-' || board[y][x + 1] != '-' || board[y][x + 2] != '-' || board[y][x + 3] != '-' || board[y][x + 4] != '-')
            {
                place5(); return;
            }

            board[y][x] = '5';
            board[y][x + 1] = '5';
            board[y][x + 2] = '5';
            board[y][x + 3] = '5';
            board[y][x + 4] = '5';
        }
    }

    public void placeBoats()
    {
        clearBoard();

        place2();
        place3();
        place3();
        place4();
        place5();
    }

    private static char[] side = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J' };

    public void displayBoard()
    {
        System.out.println("  0123456789");
        for (int y = 0; y < 10; ++y)
        {
            System.out.printf(side[y] + " ");

            for (int x = 0; x < 10; ++x)
            {
                System.out.printf(String.valueOf(board[y][x]));
            }

            System.out.println("");
        }
    }
}
