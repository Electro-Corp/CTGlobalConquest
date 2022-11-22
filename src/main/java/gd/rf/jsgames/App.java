package gd.rf.jsgames;

public final class App {
    private App() {
    }

    /**
     * @param args The arguments
     */
    public static void main(String[] args) {
        Board gb = new Board(16, 16);

        // render
        Frame game = new Frame(480, 360, "Global Conquest I");
        game.add(gb);
    }
}
