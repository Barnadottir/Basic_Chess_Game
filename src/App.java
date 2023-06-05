public class App {
    public static void main(String[] args) throws Exception {
        BoardFrame frame = new BoardFrame();
        for (Boolean[] i : Square.board) {
            for (Boolean j : i) {
                System.out.println(j);
            }
        }
    }
}
