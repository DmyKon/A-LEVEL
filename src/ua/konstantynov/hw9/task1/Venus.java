package ua.konstantynov.hw9.task1;

public class Venus implements Planet {
    final double GRAVITY_ACCEL = 8.87;
    final boolean ATMOSPHERE = true;
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

