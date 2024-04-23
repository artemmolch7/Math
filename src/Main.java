public class Main {
    public static void main(String[] args) {

        double a = 1; // начало отрезка
        double b = Math.E; // конец отрезка
        int n = 10; // количество частей

        double[] points = Calc.partition(a, b, n);

        /*
        System.out.println(Calc.rectangle(points,1));
        System.out.println(Calc.trapezoid(points));
        System.out.println(Calc.simpson(points));
         */

        MAEGraphic chart1 = new MAEGraphic("MAE",1);
        chart1.pack();
        chart1.setVisible(true);


        MSEGraphic chart2 = new MSEGraphic("MSE",1);
        chart2.pack();
        chart2.setVisible(true);
    }
}