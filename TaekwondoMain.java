package src;

/**
 *
 * @author pfn3947
 */
public class TaekwondoMain {

    public static void main(String[] args) {
        TaekwondoModel model = new TaekwondoModel();
        TaekwondoView view = new TaekwondoView();
        TaekwondoController controller = new TaekwondoController(view, model);
        model.addObserver(view);
    }
}
