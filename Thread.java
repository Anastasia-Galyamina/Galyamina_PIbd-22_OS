
public class Thread {
	private String description = "����� ";
	private int maxTime;
	private int currentTime = 0;
	private int requiredTime;

	public Thread(String description, int requiredTime, int maxTime) {
		this.description += description;
		this.maxTime = maxTime;
		this.requiredTime = requiredTime;
	}
	public int getRequiredTime() {
		return requiredTime;
	}

	public int getCurrentTime() {
		return currentTime;
	}

	public int getMaxTime() {
		return maxTime;
	}

	public String getDescription() {
		return description;
	}

	public void executeThread() {
		currentTime++;
		System.out.println(getInfo());
	}	

	public boolean needTime() {
		if (requiredTime > currentTime) {
			return true;
		} else {
			return false;
		}
	}

	public boolean haveTime() {
		if (maxTime > currentTime) {
			return true;
		} else {
			return false;
		}
	}
	public String getInfo() {
		return description + " maxTime:" + maxTime + " currentTime:" + currentTime + " requiredTime:" + requiredTime;
	}

}
