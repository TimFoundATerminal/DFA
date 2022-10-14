import java.util.Objects;

public class DFA {
    final private boolean valid;
    final private String[] states;
    final private String[] alphabet;
    final private String initialState;
    final private String[] acceptedStates;
    final private String[][] transitions; // ["currentState", "arrow", "afterState"]


    DFA(String[] states, String[] alphabet, String initialState, String[] acceptedStates, String[][] transitions) {
        this.states = states;
        this.alphabet = alphabet;
        this.initialState = initialState;
        this.acceptedStates = acceptedStates;
        this.transitions = transitions;
        this.valid = checkDFAValid();
    }

    private boolean checkDFAValid() {
        for (String state : this.states) {
            for (String letter : alphabet) {
                if (getTransition(state, letter) == null) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkLetter(String letter) {
        for (String character : this.alphabet) {
            if (Objects.equals(character, letter)) {
                return true;
            }
        }
        return false;
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
            if (!checkLetter(letter)) {
                System.out.println("Error: word contains letters not in the alphabet");
                return false;
            }
            currentState = this.getTransition(currentState, letter);
        }

        for (String acceptedState : acceptedStates) {
            if (Objects.equals(currentState, acceptedState)) {
                return true;
            }
        }
        return false;
    }
}
