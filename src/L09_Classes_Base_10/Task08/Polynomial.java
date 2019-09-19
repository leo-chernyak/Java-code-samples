package L09_Classes_Base_10.Task08;
/*
Создать класс “Polynomial” с шестью вещественными показателями для коэффициентов при каждом
        члене в формуле x5+ x4+x3+x2+x+c. Добавить в класс функции для расчета значения полинома в
        указанной точке x, а также значения производной, также в указанной точке x.
        */
public class Polynomial {
    double[] coefficients;
    int[] degrees;
    double c;
    Polynomial(double[] coefficients, int[] degrees, double c) {
        this.coefficients = coefficients;
        this.c = c;
        this.degrees = degrees;
    }

    public double calculate(double x, int degree) {
        while (degree --> 0) {
            for (int i = 0; i < coefficients.length; ++i)
            {
                if (degrees[i] == 0)
                    coefficients[i] *= degrees[i];
                else
                    coefficients[i] *= degrees[i]--;
            }
        }
        double result = 0;
        for (int i = 0; i < coefficients.length; ++i)
        {
            result += coefficients[i] * Math.pow(x, degrees[i]);
        }
        return result + c;
    }
}
