package concurrency.codewars_kata;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


/** https://www.codewars.com/kata/concurrent-task-execution/train/java */
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

		Map<Runnable, Thread> runnableThreadMap = new LinkedHashMap<>();

		for (Runnable runnable : actions)
		{
			Thread thread = new Thread(runnable);
			runnableThreadMap.put(runnable, thread);
			thread.start();
		}

		Thread.sleep(timeoutMillis);

		// result.failed = runnableThreadMap.keySet().stream().filter( () Thread::isAlive).collect(Collectors.toList());

        return result;
	}
}
