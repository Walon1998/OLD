package assignment11;

import java.util.concurrent.atomic.AtomicReference;

// think how this class can become useful
class SensorData {
    final double[] data;
    final long timestamp;
    AtomicReference<Integer> top = new AtomicReference<Integer>();


    SensorData(long t, double[] d) {
        timestamp = t;
        data = new double[d.length];
        for (int i = 0; i < d.length; ++i) {
            data[i] = d[i];
        }
    }

    double[] getValues() {
        return data;
    }

    long getTimestamp() {
        return timestamp;
    }
}
