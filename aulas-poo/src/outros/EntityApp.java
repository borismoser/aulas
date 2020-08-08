package outros;

public class EntityApp {

	public static void main(String[] args) {
		Entity ent = new Entity(Entity.Status.PROCESSING);
		ent.setStatusProcessed();
		ent.setStatusProcessing();
		Entity.EntityPrivateData epd = new Entity.EntityPrivateData(Entity.Status.PROCESSING);
		epd.status = Entity.Status.PROCESSING;
		epd.setStatus(Entity.Status.PROCESSED);
	}

}
