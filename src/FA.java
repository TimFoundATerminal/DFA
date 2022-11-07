import java.util.Objects;

abstract class FA {
    final protected String[] states;
    final protected String[] alphabet;
    final protected String initialState;
    final protected String[] acceptedStates;
    final protected String[][] transitions; // ["currentState", "arrow", "afterState"]

    public FA(String[] states, String[] alphabet, String initialState, String[] acceptedStates, String[][] transitions) {
        this.states = states;
        this.alphabet = alphabet;
        this.initialState = initialState;
        this.acceptedStates = acceptedStates;
        this.transitions = transitions;
    }

    protected boolean checkLetterValid(String letter) {
        for (String character : this.alphabet) {
            if (Objects.equals(character, letter)) {
                return true;
            }
        }
        return false;
    }

    protected boolean checkAcceptingState(String state) {
        for (String acceptedState : acceptedStates) {
            if (Objects.equals(state, acceptedState)) {
                return true;
            }
        }
        return false;
    }

    protected abstract boolean checkFAValid();
    protected abstract boolean isWord(String word);


}
