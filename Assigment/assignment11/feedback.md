LockedSensors
=============

You are taking the write-lock in your `get`-implementation, so you will not be any faster than a normal lock :-)
The idea of a ReaderWriterLock is that the readers can read concurrency, so they only have to take the read-lock.
You should us a try-finally block in your `update`-method.

LockFreeSensors
===============

Good.

You can avoid checking for null in your methods if you just initialize the `SenData`-field to some dummy value with timestamp 0.

Why do you need an extra `return 0` in the bottom? ;-)

The preferred method for copying arrays in Java is `System.arraycopy`.

Linearizability
===============

You should show _how_ you found this.
Otherwise good!
