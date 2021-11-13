package ua.konstantynov.hw9_interface.task1;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mars mars = (Mars) o;
        return Double.compare(mars.GRAVITY_ACCEL, GRAVITY_ACCEL) == 0 && ATMOSPHERE == mars.ATMOSPHERE && SATELLITE == mars.SATELLITE;
    }

    @Override
    public int hashCode() {
        return Objects.hash(GRAVITY_ACCEL, ATMOSPHERE, SATELLITE);
    }

}

