package assignment11;

import java.util.concurrent.atomic.AtomicReference;

class LockFreeSensors implements Sensors {
	AtomicReference<SensorData> SenData = new AtomicReference<SensorData>();

	LockFreeSensors()

	{

	}

	// store data and timestamp
	// if and only if data stored previously is older (lower timestamp)
	@Override
	public void update(long timestamp, double[] data)
	{


		SensorData old;
		SensorData newer = new SensorData(timestamp, data);
		do {
			old = SenData.get();
			if (old != null && old.getTimestamp() >= newer.getTimestamp()) {
				return;
			}

		} while (!SenData.compareAndSet(old, newer));
	}
	// make this lock-free
	// don't try (a variant) double compare and swap
	// hint: make use of the SensorData class (why?)


	// pre: val != null
	// pre: val.length matches length of data written via update
	// if no data has been written previously, return 0
	// otherwise return current timestamp and fill current data to array passed as val
	@Override
	public long get(double val[])
	{
		SensorData personal = SenData.get();
		if (personal != null) {
			if (personal.getTimestamp() == 0) {
				return 0;
			} else {
				for (int i = 0; i < personal.getValues().length; ++i) {
					val[i] = personal.getValues()[i];
				}
			}


			return personal.getTimestamp();
		}
		return 0;


	}

}
