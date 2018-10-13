
1.

a)
I realize it's just marked as a "HINT" in the exercise, but the idea here was to draw the state space diagram (we did this in the exercise session).
The point is that state space diagrams offer a systematic way of proving/disproving livelocks, deadlocks and mutual exclusion (even though they explode for more complicated systems).
You should practice this, as it's a common exam question ;-)

b)
Actually there's no deadlock, but rather a livelock.
The difference is that for a deadlock, all threads are stuck while waiting. Livelocks are when threads are running, but not making any useful progress, which is arguably worse, because we are burning CPU cycles in addition to not achieving anything :-)
Starvation is a bit weaker: it means that _someone_ is not making progress, but does not mean that nobody can make progress.

2.

a)
Ok. But why would it _not_ work with a single check?

b)
Ok. Additionally, all threads will be hammering the cache (contention), causing lots of cache invalidations, which are slow.

What do you mean make the whole operation atomic?
There is no single operation that does all the operations at the same time.

To make the atomic version fast, we need to use (exponential) backoff, so threads don't immediately retry after failing. That way we can achieve a reasonably fast atomic version (faster than the locked version) even for 16 threads.
