import java.util.Objects;

public class DFA extends FA {
    final private boolean valid;

    DFA(String[] states, String[] alphabet, String initialState, String[] acceptedStates, String[][] transitions) {
        super(states, alphabet, initialState, acceptedStates, transitions);
        this.valid = checkFAValid();
    }

    protected boolean checkFAValid() {
        for (String state : this.states) {
            for (String letter : alphabet) {
                if (getTransition(state, letter) == null) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValid() {
        return valid;
    }

    private String getTransition(String currentState, String input) {
        for (String[] transition : transitions) {
            if (transition[0].equals(currentState) && transition[1].equals(input)) {
                return transition[2];
            }
        }
        return null;
    }

    public boolean isWord(String word) {
        // checks that this is a valid DFA before running
        if (!this.valid) {
            System.out.println("Error: this is not a valid DFA");
            return false;
        }

        // runs through each letter in the word and transitions accordingly
        String currentState = this.initialState;
        for (int i = 0; i < word.length(); i++) {
            String letter = "" + word.charAt(i);
            if (!checkLetterValid(letter)) {
                System.out.println("Error: word contains letters not in the alphabet");
                return false;
            }
            currentState = this.getTransition(currentState, letter);
        }

        return checkAcceptingState(currentState);
    }
}
