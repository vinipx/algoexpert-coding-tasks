package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TournamentWinnerTest {
    /*
     * Given a competition where teams named after its tech stack (HTML, C#, Python) compete against
     * each other (home vs away team). There is always one winner and a loser - there are no ties.
     * The winner team receives 3 points and the loser 0 of course.
     *
     * Given an array of pairs representing the teams and an array with the results of each match,
     * write a function that returns the winner of the tournament.
     *
     * Conditions:
     * 1. The competitions array has elements in form of [homeTeam, awayTeam]
     * 2. The results array contains information about the winner of each match.
     * 3. As for the results, 0 means the awayTeam wins while 1 means homeTeam wins.
     * 4. It is guaranteed that the tournament had a winner
     *
     * Sample:
     * competitions = [
     * ["HTML", "C#"],
     * ["C#", "Python"],
     * ["Python", "HTML"],
     * ]
     *
     * Results = [0, 0, 1]
     */

    private String findWinner(ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {
        Map<String, Integer> map = new HashMap<>();
        String finalWinningTeam = "";
        int winnerScore = 0;
        for (int i = 0; i < competitions.size(); i++) {
            int competitionResult = results.get(i);
            String winningTeam = competitions.get(i)
                .get(competitionResult == 0 ? 1 : 0);
            int previousScore = map.getOrDefault(winningTeam, 0);
            int newScore = previousScore + 3;
            if (newScore > winnerScore) {
                winnerScore = newScore;
                finalWinningTeam = winningTeam;
            }
            map.put(winningTeam, newScore);
        }
        return finalWinningTeam;
    }

    @Test
    public void findTournamentWinnerTest() {
        ArrayList<ArrayList<String>> competitions = new ArrayList<>();
        ArrayList<String> match1 = new ArrayList<>();
        match1.add("HTML");
        match1.add("C#");
        ArrayList<String> match2 = new ArrayList<>();
        match2.add("C#");
        match2.add("Python");
        ArrayList<String> match3 = new ArrayList<>();
        match3.add("Python");
        match3.add("HTML");
        competitions.add(match1);
        competitions.add(match2);
        competitions.add(match3);

        ArrayList<Integer> results = new ArrayList<>();
        results.add(0);
        results.add(0);
        results.add(1);

        Assert.assertEquals(findWinner(competitions, results), "Python");
    }
}
