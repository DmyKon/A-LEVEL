package ua.konstantynov.hw9.task1;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Venus venus = (Venus) o;
        return Double.compare(venus.GRAVITY_ACCEL, GRAVITY_ACCEL) == 0 && ATMOSPHERE == venus.ATMOSPHERE && SATELLITE == venus.SATELLITE;
    }

    @Override
    public int hashCode() {
        return Objects.hash(GRAVITY_ACCEL, ATMOSPHERE, SATELLITE);
    }

}

