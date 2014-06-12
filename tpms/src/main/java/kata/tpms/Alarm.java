package kata.tpms;

/**
 * Created by benwu on 14-6-10.
 */
public class Alarm {
    public static final double LOW_PRESSURE_THRESHOLD = 17;
    public static final double HIGH_PRESSURE_THRESHOLD = 21;
    private Detector detector;

    // TODO-working-on: Depending on a concrete Sensor violates the Dependency Inversion Principle and Open-Closed Principle
    private Sensor sensor = new Sensor();

    private boolean alarmOn = false;

    public Alarm() {
        this.detector = new Sensor();
    }

    public Alarm(Detector detector) {
        this.detector = detector;
    }

    public void check()
    {
        double psiPressureValue = sensor.popNextPressurePsiValue();

        if (psiPressureValue < LOW_PRESSURE_THRESHOLD || HIGH_PRESSURE_THRESHOLD < psiPressureValue)
        {
            alarmOn = true;
        }
    }

    public boolean isAlarmOn()
    {
        return alarmOn;
    }
}
