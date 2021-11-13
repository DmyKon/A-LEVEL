package ua.konstantynov.hw9_interface.task1;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Earth earth = (Earth) o;
        return Double.compare(earth.GRAVITY_ACCEL, GRAVITY_ACCEL) == 0 &&
                ATMOSPHERE == earth.ATMOSPHERE && SATELLITE == earth.SATELLITE;
    }

    @Override
    public int hashCode() {
        return Objects.hash(GRAVITY_ACCEL, ATMOSPHERE, SATELLITE);
    }

}
