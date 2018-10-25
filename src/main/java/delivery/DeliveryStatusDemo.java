package delivery;

public class DeliveryStatusDemo {
	public static void main(String[] args) {

		final DeliveryStatus deliveryStatus = new DeliveryStatus(DeliveryStatus.Stage.PREPARING, null);

		final String trackingNumber = deliveryStatus.getTrackingInfo().getTrackingNumber();
		System.out.println("trackingNumber = " + trackingNumber);
	}
}