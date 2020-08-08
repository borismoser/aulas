package outros;

import java.util.ArrayList;

class Entity {
	enum Status {
		PROCESSING, PROCESSED
	};

	static class EntityPrivateData {
		public Status status;
		public ArrayList<Status> history;

		public EntityPrivateData(Status status) {
			this.status = status;
			this.history = new ArrayList<Status>();
		}

		public void setStatus(Status status) {
			this.status = status;
			this.history.add(status);
		}
	}

	private EntityPrivateData data;

	public Entity(Status status) {
		data = new EntityPrivateData(status);
	}

	public void setStatusProcessing() {
		data.setStatus(Status.PROCESSING);
	}

	public void setStatusProcessed() {
		data.setStatus(Status.PROCESSED);
	}
}