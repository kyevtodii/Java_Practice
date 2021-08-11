import java.text.DecimalFormat;
import java.util.Arrays;
import java.io.*;

public class HospitalArray {
    public static void main(String[] args) {

        PrintWriter pw = new PrintWriter(System.out, true);
        DecimalFormat df = new DecimalFormat("##.#");

        float[] patients = new float[30];
        final float MIN = 32.0f;
        final float MAX = 40.0f;
        final float NORM_MIN = 36.2f;
        final float NORM_MAX = 36.9f;

        for (int i = 0; i < patients.length; ++i) {
            float value = (float) (MIN + (Math.random() * (MAX - MIN)));
            patients[i] = Float.parseFloat(df.format(value));
        }

        float averageTemp = 0f;
        for (float i : patients) {
            averageTemp += i;
        }
        averageTemp /= patients.length;

        int healthyPatients = 0;
        for (float j : patients) {
            if (j >= NORM_MIN && j <= NORM_MAX) {
                ++healthyPatients;
            }
        }

        pw.println("Температуры пациентов: " + Arrays.toString(patients).replaceAll("[\\[\\]]", ""));
        pw.println("Средняя температура: " + df.format(averageTemp));
        pw.println("Количество здоровых пациентов: " + healthyPatients);
    }
}
