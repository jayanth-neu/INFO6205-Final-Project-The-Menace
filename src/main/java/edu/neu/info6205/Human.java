package edu.neu.info6205;

public class Human {

    //Next human move to counter the menace machine
    public int humanMove(String state, double p) {
        // TODO Auto-generated method stub
        /* Rank 1: win */
//		double p = 0.9;
        Operations op = new Operations();
        String[][] checkRowBoard = op.stringToArray(state);
//            {
//                    {"N", "O", "N"},
//                    {"N", "N", "N"},
//                    {"X", "N", "X"}
//            };
        OptimalStrategy checkRowBot = new OptimalStrategy(checkRowBoard);
//        System.out.println(checkRowBot.findBestMove());
//        int j = 0;
//        for(int i = 0; i<1000; i++) {
//        	int x = humanStrategy(checkRowBoard, checkRowBot.findBestMove(), p);
//        	if(x != 7) {System.out.println(x); j++;}
//        }
//        System.out.println("Count: " + j);
        return humanStrategy(checkRowBoard, checkRowBot.findBestMove(), p);
    }

    public int humanStrategy(String[][] state, int bestMove, double prob) {
        // Returns a random integer from 0 to 8:
        int randomMove = (int)(Math.random() * 9);

        while(true) {
            randomMove = randomMove%9;
            if(state[randomMove/3][randomMove%3].equals("N")) return finalMove(bestMove, randomMove, 100*prob);
            randomMove++;
        }
    }

    public static int finalMove(int x, int y, double p)
    {
        // Generate a number from 1 to 100
        int r = (int)(Math.random() * 100 + 1);

        if (r <= p)
            return x;

        return y;
    }
}
