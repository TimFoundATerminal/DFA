public class init {
    public static void main(String[] args) {
        String[] states = {"1", "2", "3"}; // all the possible states in the DFA
        String[] alphabet = {"a", "b"}; // all letters accepted by the DFA
        String initialState = "1"; // the state the DFA initialises in
        String[] acceptedStates = {"1", "2"}; // subset of states that result in the word being accepted
        String[][] transitions = {  // ways to move between states
                {"1", "a", "1"},
                {"1", "b", "2"},
                {"2", "a", "3"},
                {"2", "b", "2"},
                {"3", "a", "3"},
                {"3", "b", "3"}, // ["currentState", "letter", "afterState"]
        };
        DFA dfa = new DFA(states, alphabet, initialState, acceptedStates, transitions);
        // This DFA makes sure the word is in lexicographical order
        System.out.println(dfa.isWord("aabb"));
        System.out.println(dfa.isWord("aabba"));
    }
}
