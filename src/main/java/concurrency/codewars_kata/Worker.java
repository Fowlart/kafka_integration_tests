package concurrency.codewars_kata;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;


/**
 * https://www.codewars.com/kata/concurrent-task-execution/train/java
 */
public class Worker
{

	public static class ExecutedTasks
	{

		public final List<Runnable> successful = new ArrayList<>();
		public final Set<Runnable> failed = new HashSet<>();
		public final Set<Runnable> timedOut = new HashSet<>();
	}

	public ExecutedTasks execute(Collection<Runnable> actions, long timeoutMillis) throws InterruptedException
	{

		ExecutedTasks result = new ExecutedTasks();

		Map<Runnable, Future> runnableFutureMap = new LinkedHashMap<>();
		ExecutorService executor = Executors.newFixedThreadPool(actions.size());

		for (Runnable runnable : actions)
		{
			runnableFutureMap.put(runnable, executor.submit(runnable));
			try
			{
				executor.execute(runnable);
			}
			catch (RuntimeException ex)
			{
				result.failed.add(runnable);
			}

		}

		executor.shutdown();

		executor.awaitTermination(timeoutMillis, TimeUnit.MILLISECONDS);

		for (Map.Entry<Runnable, Future> entry : runnableFutureMap.entrySet())
		{

			try
			{
				if (Objects.isNull(entry.getValue().get()))
					result.successful.add(entry.getKey());
			}
			catch (ExecutionException ex)
			{
				result.failed.add(entry.getKey());
			}
			catch (InterruptedException ex)
			{
				result.timedOut.add(entry.getKey());
			}
		}


		result.successful.sort(Comparator.comparing(Object::toString));

		return result;
	}
}
