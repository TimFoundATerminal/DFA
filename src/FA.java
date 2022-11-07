import java.util.HashMap;
import java.util.Objects;

abstract class FA {
    final protected String[] states;
    final protected String[] alphabet;
    final protected String initialState;
    final protected String[] acceptedStates;
    final protected HashMap<String, String> transitions; // ["currentState", "arrow", "afterState"]

    public FA(String[] states, String[] alphabet, String initialState, String[] acceptedStates) {
        this.states = states;
        this.alphabet = alphabet;
        this.initialState = initialState;
        this.acceptedStates = acceptedStates;
        this.transitions = new HashMap<String, String>();
    }

    public void addTransition(String currentState, String input, String nextState) {
        this.transitions.put(this.catKey(currentState, input), nextState);
    }

    protected String catKey(String currentState, String input) {
        return currentState + "/!/" + input;
    }

    protected String getTransition(String currentState, String input) {
        return this.transitions.get(this.catKey(currentState, input));
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
