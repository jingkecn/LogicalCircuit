package main.circuits;

import main.signals.Event;
import main.signals.Horloge;
import main.signals.Signal;

/**
 * Created by King on 2014-12-13.
 */
public class Or extends PorteADeuxEntrees {

    /**
     * Constructor
     * Initialize the inputs, output and delay of this OR gate
     * @param entree1 the first input
     * @param entree2 the second input
     * @param sortie the output
     * @param retard the delay
     */
    public Or(Signal entree1, Signal entree2, Signal sortie, int retard) {
        super(entree1, entree2, sortie, retard);
    }

    @Override
    public void activate() {
        if (sortie.getValue() != entree1.getValue() || entree2.getValue()) {
            sortie.addEvent(
                    new Event(
                            Horloge.top() + retard,
                            entree1.getValue() || entree2.getValue()
                    )
            );
        }
    }

}