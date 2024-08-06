import java.time.LocalDate;
import java.util.ArrayList;

public class EinUndAuszahlungen {
    public static void zahlungen() {
        ArrayList<LocalDate> date = new ArrayList<>();
        date.add(LocalDate.of(2024, 01, 23));
        date.add(LocalDate.of(2024, 02, 02));
        date.add(LocalDate.of(2024, 02, 12));
        date.add(LocalDate.of(2024, 02, 14));
        date.add(LocalDate.of(2024, 04, 8));
        date.add(LocalDate.of(2024, 05, 12));
        date.add(LocalDate.of(2024, 06, 2));
        date.add(LocalDate.of(2024, 06, 12));
        date.add(LocalDate.of(2024, 07, 23));
        date.add(LocalDate.of(2024, 03, 23));

        date.sort(LocalDate::compareTo);
       /* for (LocalDate d : date) {
            System.out.println(d);
        }*/

        ArrayList<Double> summe = new ArrayList<>();
        summe.add(2550.0);
        summe.add(-137.0);
        summe.add(233.0);
        summe.add(-20.0);
        summe.add(-259.0);
        summe.add(1798.0);
        summe.add(-599.0);
        summe.add(-233.0);
        summe.add(-52.0);
        summe.add(23.0);


    int datumIndex = 0;
    double summeMitIndexOfDatum = 0;

    for(LocalDate d:date){
        datumIndex= date.indexOf(d);
        summeMitIndexOfDatum=summe.get(datumIndex);
    }


}
}
