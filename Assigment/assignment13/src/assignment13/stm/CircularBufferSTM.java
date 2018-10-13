package assignment13.stm;

import java.util.concurrent.Callable;

import scala.concurrent.stm.Ref;
import scala.concurrent.stm.TArray;
import scala.concurrent.stm.japi.STM;


/**
 * This class implements a {@link assignment13.stm.CircularBuffer} using software-transactional memory (more
 * specifically using ScalaSTM [http://nbronson.github.io/scala-stm/]).
 */
public class CircularBufferSTM<E> implements CircularBuffer<E> {

	TArray.View<E> items;
	Ref.View<Integer> in = STM.newRef(0);
	Ref.View<Integer> out = STM.newRef(0);
	Ref.View<Integer> size;


	CircularBufferSTM(int capacity) {
		items = STM.newTArray(capacity + 1);
		size = STM.newRef(capacity + 1);

	}

	@Override
	public void put(final E item) {
		STM.atomic(new Runnable() {
			@Override
			public void run() {
				if (isFull()) {
					STM.retry();
				}

				items.update(in.get(), item);
				in.set((in.get() + 1) % size.get());

			}
		});
	}


	@Override
	public E take() {
		return STM.atomic(new Callable<E>() {

			@Override
			public E call() {

				if (isEmpty()) {
					STM.retry();
				}
				E item = items.apply(out.get());
				out.set((out.get() + 1) % size.get());
				return item;


			}
		});
	}

	@Override
	public boolean isEmpty() {
		return STM.atomic(new Callable<Boolean>() {

			@Override
			public Boolean call() {
				return in.get() == out.get();
			}
		});
	}

	@Override
	public boolean isFull() {
		return STM.atomic(new Callable<Boolean>() {

			@Override
			public Boolean call() {
				return (in.get() + 1) % size.get() == out.get();
			}
		});

	}
}
