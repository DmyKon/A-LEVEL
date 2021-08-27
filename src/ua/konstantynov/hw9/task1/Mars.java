package ua.konstantynov.hw9.task1;

public class Mars implements Planet {
    final double GRAVITY_ACCEL = 3.73;
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

