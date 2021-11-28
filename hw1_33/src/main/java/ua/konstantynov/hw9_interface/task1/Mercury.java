package ua.konstantynov.hw9_interface.task1;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mercury mercury = (Mercury) o;
        return Double.compare(mercury.GRAVITY_ACCEL, GRAVITY_ACCEL) == 0 && ATMOSPHERE == mercury.ATMOSPHERE && SATELLITE == mercury.SATELLITE;
    }

    @Override
    public int hashCode() {
        return Objects.hash(GRAVITY_ACCEL, ATMOSPHERE, SATELLITE);
    }

}

