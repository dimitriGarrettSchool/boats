import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Random;
import java.util.Scanner;

public class Board
{
    private char[][] board = new char[10][10];
    private char[][] gboard = new char[10][10];

    // the board holds chars, this displays them as strings
    private static String to_string(char boardPos)
    {
        if (boardPos == 'm') return "\uD83D\uDCA6";
        if (boardPos == 'h') return "\uD83D\uDCA5";
        if (boardPos == 's') return "\uD83D\uDD25";
        else return "\uD83C\uDF0A";
    }

    // clears the board
    public void clearBoard()
    {
        for (int y = 0; y < 10; ++y)
        {
            for (int x = 0; x < 10; ++x)
            {
                board[y][x] = '-';
                gboard[y][x] = '-';
            }
        }

        // this is needed to display utf stuff
        createPrintStream();
    }

    private static Random random = new Random();

    // places a ship of size 2
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
    // places a ship of size 3
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
    // places a ship of size 4
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
    // places a ship of size 5
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

    // places all the boats
    public void placeBoats()
    {
        clearBoard();

        place2();
        place3();
        place3();
        place4();
        place5();
    }

    // this is the debug display thingy
    public void displayIBoard()
    {
        System.out.println("  0123456789");

        for (int y = 0; y < 10; ++y)
        {
            stream.printf("\uFF21" + y);

            for (int x = 0; x < 10; ++x)
            {
                System.out.printf(String.valueOf(board[y][x]));
            }

            System.out.println("");
        }
    }

    // needed for utf to display properly
    private PrintStream stream;
    // needed for utf to display properly
    private void createPrintStream()
    {
        Charset utf8 = Charset.forName("UTF-8");

        try
        {
            stream = new PrintStream(System.out, true, utf8.name());
        }

        catch (UnsupportedEncodingException e)
        {

        }
    }

    // prints the board
    public void displayBoard()
    {
        stream.printf("  " + String.valueOf('\uFF21') + " ");
        stream.printf(String.valueOf('\uFF22') + " ");
        stream.printf(String.valueOf('\uFF23') + " ");
        stream.printf(String.valueOf('\uFF24') + " ");
        stream.printf(String.valueOf('\uFF25') + " ");
        stream.printf(String.valueOf('\uFF26') + " ");
        stream.printf(String.valueOf('\uFF27') + " ");
        stream.printf(String.valueOf('\uFF28') + " ");
        stream.printf(String.valueOf('\uFF29') + " ");
        stream.printf(String.valueOf('\uFF2A') + " ");
        stream.println("");

        for (int y = 0; y < 10; ++y)
        {
            stream.printf(String.valueOf(y) + " ");

            for (int x = 0; x < 10; ++x)
            {
                stream.printf(to_string(gboard[y][x]) + " ");
                //writer.printf(gboard[y][x] != '-' ? String.valueOf(gboard[y][x]) : "\uD83C\uDF0A");
            }

            System.out.println("");
        }
    }

    private int misscount = 0;
    private int strikes = 0;
    private int hits = 0;

    // checks to see if the boat is a hit or a sink, this is purely visual
    private boolean hitcount(char v)
    {
        int cv = 0;

        int[] idx = new int[10];

        for (int y = 0; y < gboard.length; ++y)
        {
            for (int x = 0; x < gboard[y].length; ++x)
            {
                if (board[y][x] == v && gboard[y][x] == 'h')
                {
                    idx[cv * 2] = y;
                    idx[cv * 2 + 1] = x;

                    ++cv;
                }
            }
        }

        if (cv == Integer.parseInt(String.valueOf(v)))
        {
            for (int i = 0; i < cv; ++i)
            {
                gboard[idx[i * 2]][idx[i * 2 + 1]] = 's';
            }

            return true;
        }

        return false;
    }

    // move logic
    public boolean move()
    {
        System.out.println("Total misses: " + misscount);
        System.out.println("Total strikes: " + strikes);

        // all below gets the x value
        String xx = "";
        while (xx.length() != 1 || (xx.charAt(0) < 'A' && xx.charAt(0) > 'J'))
        {
            if (xx != "")
                System.out.println("Incorrect input, needs to be a letter from 'A' to 'J'!");

            xx = SafeInput.getNonZeroLenString(new Scanner(System.in), "x: ");
        }

        int x = xx.charAt(0) - 'A';

        // below is the y coordinate
        int y = SafeInput.getRangedInt(new Scanner(System.in), "y: ", 0, 10);

        // already guessed here
        if (gboard[y][x] != '-')
        {
            System.out.println("You already guessed there!");

            move();
        }

        // its a hit
        else if (board[y][x] != '-')
        {
            gboard[y][x] = 'h';

            if (hitcount(board[y][x]))
            {
                System.out.println("You sunk a boat!");
            }

            else {
                System.out.println("You hit a boat!");
            }

            misscount = 0;
            ++hits;
        }

        // miss, does the strike logic
        else {
            System.out.println("You missed!");
            gboard[y][x] = 'm';

            ++misscount;

            if (misscount == 5)
            {
                misscount = 0;

                ++strikes;

                if (strikes == 3)
                {
                    strikes = 0;

                    System.out.println("You got 3 strikes!");
                    System.out.println("You lost!");

                    return false;
                }
            }
        }

        // if you win
        if (hits == 17)
        {
            hits = 0;
            misscount = 0;
            strikes = 0;

            System.out.println("You won the game, you sunk all the boats!");

            return false;
        }

        return true;
    }
}
