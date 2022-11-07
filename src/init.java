public class init {
    public static void main(String[] args) {
        String[] states = {"1", "2", "3"}; // all the possible states in the DFA
        String[] alphabet = {"a", "b"}; // all letters accepted by the DFA
        String initialState = "1"; // the state the DFA initialises in
        String[] acceptedStates = {"1", "2"}; // subset of states that result in the word being accepted

        DFA dfa = new DFA(states, alphabet, initialState, acceptedStates);
        // add transitions or 'arrows' to the finite automata
        dfa.addTransition("1", "a", "1");
        dfa.addTransition("1", "b", "2");
        dfa.addTransition("2", "a", "3");
        dfa.addTransition("2", "b", "2");
        dfa.addTransition("3", "a", "3");
        dfa.addTransition("3", "b", "3");

        // This DFA makes sure the word is in lexicographical order
        System.out.println(dfa.isWord("aabb"));
        System.out.println(dfa.isWord("aabba"));
    }
}
