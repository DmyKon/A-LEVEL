package ua.konstantynov.hw9.task1;

public class Earth implements Planet {
    final double GRAVITY_ACCEL = 9.8;
    final boolean ATMOSPHERE = true;
    final boolean SATELLITE = true;

    public boolean isAtmosphere() {
        return ATMOSPHERE;
    }

    public boolean isSatellite() {
        return SATELLITE;
    }

    @Override
    public double getGravityAccel() {
        return GRAVITY_ACCEL;
    }

}
