public class DFA {


    private boolean valid = false;
    final private String[] states;
    final private String[] alphabet;
    final private String initialState;
    final private String[] acceptedStates;
    final private String[][] transitions; // ["currentState", "arrow", "afterState"]


    public DFA(String[] states, String[] alphabet, String initialState, String[] acceptedStates, String[][] transitions) {
        this.states = states;
        this.alphabet = alphabet;
        this.initialState = initialState;
        this.acceptedStates = acceptedStates;
        this.transitions = transitions;
        if (this.checkDFAValid()) {
            this.valid = true;
        }
    }

    private boolean checkDFAValid() {
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
        String currentState = this.initialState;
        for (int i = 0; i < word.length(); i++) {
            currentState = this.getTransition(currentState, "" + word.charAt(i));
        }

        for (String acceptedState : acceptedStates) {
            if (currentState.equals(acceptedState)) {
                return true;
            }
        }
        return false;
    }
}
