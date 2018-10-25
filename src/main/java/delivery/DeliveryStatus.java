package delivery;

public class DeliveryStatus {

	private final Stage stage;
	private final TrackingInfo trackingInfo;

	public DeliveryStatus(final Stage stage, final TrackingInfo trackingInfo) {
		this.stage = stage;
		this.trackingInfo = trackingInfo;
	}

	enum Stage {
		PREPARING,
		DISPATCHED,
		WAITING_FOR_YOU_TO_LEAVE_HOME_SO_YOU_WILL_MISS_IT
	}

	public Stage getStage() {
		return stage;
	}

	public TrackingInfo getTrackingInfo() {
		return trackingInfo;
	}

	class TrackingInfo {
		private String trackingNumber;

		TrackingInfo(final String trackingNumber) {
			this.trackingNumber = trackingNumber;
		}

		public String getTrackingNumber() {
			return trackingNumber;
		}
	}

}
