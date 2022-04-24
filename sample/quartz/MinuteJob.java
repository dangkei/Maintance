package quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class MinuteJob extends QuartzJobBean{

	private Task1 task = null;
	
	@Override
	protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
		// TODO Auto-generated method stub
		task.run();
	}

	/**
	 * @return the task1
	 */
	public Task1 getTask() {
		return task;
	}

	/**
	 * @param task1 the task1 to set
	 */
	public void setTask(Task1 task) {
		this.task = task;
	}

}
