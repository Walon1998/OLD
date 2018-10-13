Please write down all questions in your report, even if it's a coding question, so I know which tasks you solved, and preferably how you did it.

1.
==

a)
--
Yep.

b)
--
Yep.

c)
--
Exactly :-)

2.
==

a)
Looks good.

b)
Great.

3.
==

a)
Great.

b)
Works for single use, but your implementation would not work for multiple uses. Right after you call `notifyAll()` you set `start = 0`, meaning that when the threads wake up, `start < goal` still, and they will keep sleeping forever.
To solve this you need a separate case for draining the threads before the barrier can restart.
