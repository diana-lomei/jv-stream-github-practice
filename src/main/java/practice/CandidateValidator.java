package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static int ZERO_INDEX = 0;
    private static int FIRST_INDEX = 1;
    private static final int MIN_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int LIVE_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && livesInUkraine(candidate)
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY);
    }

    private boolean livesInUkraine(Candidate candidate) {
        String[] value = candidate.getPeriodsInUkr().split("-");
        return Integer.parseInt(value[FIRST_INDEX])
                - Integer.parseInt(value[ZERO_INDEX]) >= LIVE_IN_UKRAINE;
    }
}
