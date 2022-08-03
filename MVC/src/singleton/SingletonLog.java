package singleton;

public class SingletonLog {
	
	private static SingletonLog instance=null;
	
	private SingletonLog() {
		
	}
	
	public static SingletonLog getInstance() {
		if (instance==null) 
			instance = new SingletonLog();
		return instance;
	}
	
	public void doLog (String... msgs) {
		String s="";
		for (String string : msgs) {
			s += (string+" ");
		}
		System.out.println(s);
	}
	
	public static void main(String[] args) {
		SingletonLog.getInstance().doLog();
		SingletonLog.getInstance().doLog("1","2");
		SingletonLog.getInstance().doLog("11","12","13");
	}

}
