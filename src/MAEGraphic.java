
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;


public class MAEGraphic extends ApplicationFrame {
    public MAEGraphic(String title, int methodNumber) {
        super(title);
        JFreeChart lineChart = ChartFactory.createLineChart(
                "MAE Graph",
                "Количество отрезков разбиения (n)","MAE",
                createDataset(methodNumber),
                PlotOrientation.VERTICAL,
                true,true,false);

        ChartPanel chartPanel = new ChartPanel(lineChart);
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));
        setContentPane(chartPanel);
    }

    private DefaultCategoryDataset createDataset(int methodNumber) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        double actualValue = 1;
        for (int n = 1; n <= 100; n++) {
            double a = 1;
            double b = Math.E;
            double integralSumValue = 0;
            switch(methodNumber){
                case 3 -> integralSumValue = Calc.simpson(Calc.partition(a,b,n));
                case 1 -> integralSumValue = Calc.rectangle(Calc.partition(a,b,n),1);
                case 2 -> integralSumValue = Calc.trapezoid(Calc.partition(a,b,n));
                default -> integralSumValue = 0;
            }
            double mae = Math.abs(actualValue - integralSumValue);
            dataset.addValue(mae, "MAE", Integer.toString(n));
        }
        return dataset;
    }

}
