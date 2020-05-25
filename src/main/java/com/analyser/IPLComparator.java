package com.analyser;
import java.util.*;

public class IPLComparator {
    static Map<IplAnalyser.CompareType, Comparator<IplRunsWktsDAO>> iplComparator = new HashMap<>();

    static  {
        Comparator<IplRunsWktsDAO> compareByBattingStrike = Comparator.comparing(IPL -> IPL.strikeRate);
        iplComparator.put(IplAnalyser.CompareType.BATSMAN_STRIKE,compareByBattingStrike);

        Comparator<IplRunsWktsDAO> compareByBattingAverage = Comparator.comparing(IPL -> IPL.average);
        iplComparator.put(IplAnalyser.CompareType.BATSMAN_AVERAGE,compareByBattingAverage);

        Comparator<IplRunsWktsDAO> compareByRuns = Comparator.comparing(IPL -> IPL.runs);
        iplComparator.put(IplAnalyser.CompareType.RUNS,compareByRuns);

        Comparator<IplRunsWktsDAO> compareBySixAndFour = Comparator.comparing(IPL -> (IPL.noOfSix + IPL.noOfFour));
        iplComparator.put(IplAnalyser.CompareType.SIX_AND_FOUR,compareBySixAndFour);

        Comparator<IplRunsWktsDAO> compareByBattingAverageWithStrike = compareByBattingAverage.thenComparing(compareByBattingStrike);
        iplComparator.put(IplAnalyser.CompareType.BATSMAN_AVERAGE_WITH_STRIKE,compareByBattingAverageWithStrike);

        Comparator<IplRunsWktsDAO> compareByStrikeWithSixsAndFour = compareBySixAndFour.thenComparing(compareByBattingStrike);
        iplComparator.put(IplAnalyser.CompareType.BATSMAN_STRIKE_WITH_SIX_AND_FOUR,compareByStrikeWithSixsAndFour);

        Comparator<IplRunsWktsDAO> compareByRunsWithAverage = compareByRuns.thenComparing(compareByBattingAverage);
        iplComparator.put(IplAnalyser.CompareType.BATSMAN_RUNS_WITH_AVERAGE,compareByRunsWithAverage);

        Comparator<IplRunsWktsDAO> compareByBowlerAverage = Comparator.comparing(IPL -> IPL.average);
        iplComparator.put(IplAnalyser.CompareType.BOWLER_AVERAGE,compareByBowlerAverage);

        Comparator<IplRunsWktsDAO> compareByBowlerStrikeRate = Comparator.comparing(IPL -> IPL.strikeRate);
        iplComparator.put(IplAnalyser.CompareType.BOWLER_STRIKE,compareByBowlerStrikeRate);

        Comparator<IplRunsWktsDAO> compareByEconomy = Comparator.comparing(IPL -> IPL.economicsRate);
        iplComparator.put(IplAnalyser.CompareType.ECONOMY,compareByEconomy);

        Comparator<IplRunsWktsDAO> compareByFiveAndFourWickets = Comparator.comparing(IPL -> (IPL.fiveWikets + IPL.fourWikets));
        iplComparator.put(IplAnalyser.CompareType.FOUR_AND_FIVE_WICKETS,compareByFiveAndFourWickets);

        Comparator<IplRunsWktsDAO> compareByStrikeWithFiveAndFourWickets = compareByFiveAndFourWickets.thenComparing(compareByBowlerStrikeRate);
        iplComparator.put(IplAnalyser.CompareType.BOWLER_STRIKE_WITH_FOUR_AND_FIVE_WICKETS,compareByStrikeWithFiveAndFourWickets);

        Comparator<IplRunsWktsDAO> compareByAverageWithStrike = compareByBowlerAverage.thenComparing(compareByBowlerStrikeRate);
        iplComparator.put(IplAnalyser.CompareType.BOWLER_AVERAGE_WITH_STRIKE,compareByAverageWithStrike);

        Comparator<IplRunsWktsDAO> compareByWickets = Comparator.comparing(iplData -> iplData.wickets);
        iplComparator.put(IplAnalyser.CompareType.BOWLER_WICKETS,compareByWickets);

        Comparator<IplRunsWktsDAO> compareByWicketsWithAverage = compareByWickets.thenComparing(compareByBowlerAverage);
        iplComparator.put(IplAnalyser.CompareType.BOWLER_WICKETS_WITH_AVERAGE,compareByWicketsWithAverage);

        Comparator<IplRunsWktsDAO> compareByBattingAndBowlingAverage = compareByBattingAverage.thenComparing(compareByBowlerAverage);
        iplComparator.put(IplAnalyser.CompareType.BATSMAN_AVERAGE_WITH_BOWLER_AVERAGE,compareByBattingAndBowlingAverage);

        Comparator<IplRunsWktsDAO> compareByRunsAndWickets = compareByRuns.thenComparing(compareByWickets);
        iplComparator.put(IplAnalyser.CompareType.RUNS_WITH_WICKETS,compareByRunsAndWickets);
    }

    public Comparator<IplRunsWktsDAO> getIPLDataComparator(IplAnalyser.CompareType compareType) {
        return iplComparator.get(compareType);
    }
}
