package ua.konstantynov.hw9.task1;

public class Mercury implements Planet {
    final double GRAVITY_ACCEL = 3.7;
    final boolean ATMOSPHERE = false;
    final boolean SATELLITE = false;

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

