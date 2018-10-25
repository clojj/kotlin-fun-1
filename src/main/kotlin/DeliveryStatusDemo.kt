
fun main(args: Array<String>) {

    val deliveryStatus = DeliveryStatus(DeliveryStatus.Stage.PREPARING, null);
    val trackingNumberUnsafe = deliveryStatus.trackingInfo.trackingNumber;

    val trackingNumberSafe = deliveryStatus.trackingInfo?.trackingNumber;
    println("$trackingNumberSafe")
}
