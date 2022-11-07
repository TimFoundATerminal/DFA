import java.util.Objects;

public class DFA extends FA {
    final private boolean valid;

    DFA(String[] states, String[] alphabet, String initialState, String[] acceptedStates) {
        super(states, alphabet, initialState, acceptedStates);
        this.valid = false;
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

    public boolean isWord(String word) {
        // checks that this is a valid DFA before running
        if (!this.checkFAValid()) {
            System.out.println("Error: this is not a valid DFA");
            return false;
        }

        // runs through each letter in the word and transitions accordingly
        String currentState = this.initialState;
        String nextState;
        for (int i = 0; i < word.length(); i++) {
            String letter = "" + word.charAt(i);
            if (!checkLetterValid(letter)) {
                System.out.println("Error: word contains letters not in the alphabet");
                return false;
            }
            nextState = this.getTransition(currentState, letter);
            if (nextState != null) {
                currentState = nextState;
            } else {
                System.out.println("Error: not a valid DFA");
            }
        }

        return checkAcceptingState(currentState);
    }
}
