import java.util.Random;

public class Calc {
    public static double[] partition(double a, double b, int n) {

        if (n <= 0) {
            System.err.println("Разбиение на отрицательное количество отрезков невозможно");
            return null;
        }
        double[] divisions = new double[n];
        double step = (b - a) / n;

        for (int i = 0; i < n; i++) {
            divisions[i] = a + i * step;
        }
        divisions[n - 1] = b;

        return divisions;
    }

    public static double rectangle(double[] points, int choice){
        int n = points.length;
        double intrgalSum = 0;
        double s;
        double e;
        double deltaX;
        for (int i=1; i<n;i++){
            deltaX = points[i] - points[i-1];
            switch (choice){
                case 1 -> {
                    e = points[i]; //правая точка
                    s = 1/e;
                }
                case 2 -> {
                    e = points[i-1]; //левая точка
                    s = 1/e;
                }
                case 3 ->{
                    e = getRandomPoint(points[i-1], points[i]); //случайная точка
                    s = 1/e;
                }
                default -> {
                    System.err.println("Неверный выбор точки для интегральной суммы!");
                    s = 0;
                }
            }
            intrgalSum += s*deltaX;
        }
        return intrgalSum;
    }

    public static double trapezoid(double[] points) {
        int n = points.length;
        double intrgalSum = 0;
        double f1;
        double f2;
        double s;
        double deltaX;
        for (int i=1; i<n;i++){
            deltaX = points[i] - points[i-1];
            f1 = 1/points[i-1];
            f2 = 1/points[i];
            s = (f1+f2)*(deltaX/2);
            intrgalSum += s;
        }
        return intrgalSum;
    }

    public static double simpson(double[] points){
        int n = points.length;
        double integralSum = 0;
        double s;
        double f1;
        double f2;
        double f3;
        double deltaX;
        for(int i=1; i<n; i++){
            deltaX = points[i] - points[i-1];
            f1 = 1/points[i-1];
            f2 = 1/((points[i]+points[i-1])/2);
            f3 = 1/points[i];
            s = (f1 + 4*f2+f3)*(deltaX/6);
            integralSum +=s;
        }
        return integralSum;
    }


    public static double getRandomPoint(double a, double b) {
        // Инициализация объекта для генерации случайных чисел
        Random rand = new Random();

        // Генерация случайной точки на отрезке [a, b]
        double randomPoint = a + (b - a) * rand.nextDouble();

        return randomPoint;
    }
}
