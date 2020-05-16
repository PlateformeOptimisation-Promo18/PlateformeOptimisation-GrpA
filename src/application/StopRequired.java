package application;

import java.util.Observable;

public class StopRequired extends Observable {

		private boolean stop;
		
		public void setStopRequired(){
			setStop(true);
			notifyObservers();
		}
		public boolean isStop() {
			return stop;
		}
		public void setStop(boolean stop) {
			this.stop = stop;
		}		
}
