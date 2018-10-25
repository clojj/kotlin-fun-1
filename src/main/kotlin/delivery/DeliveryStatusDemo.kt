package delivery

fun main() {

    // -------------- Kotlin benutzt Java (DeliveryStatus)
    val deliveryStatus = DeliveryStatus(DeliveryStatus.Stage.PREPARING, null);
// TODO    val trackingNumberUnsafe = deliveryStatus.trackingInfo.trackingNumber;

    val trackingNumberSafe = deliveryStatus.trackingInfo?.trackingNumber;
    println("$trackingNumberSafe")





    // -------------- Kotlin mit DeliveryStatusKotlinNullable
// TODO    DeliveryStatusKotlinNullable(DeliveryStatusKotlinNullable.Stage.PREPARING, null)
// TODO    ?.----?.----- zeigen




    // -------------- Kotlin mit DeliveryStatusADT
    val preparing = DeliveryStatusADT.Preparing
// TODO    preparing.

    val dispatching = DeliveryStatusADT.Dispatching("42")
    println("dispatching.trackingNumber = ${dispatching.trackingNumber}")

    deliveryStatusAdtNachMeldung(DeliveryStatusADT.Dispatching("42"));

}

fun deliveryStatusAdtNachMeldung(status: DeliveryStatusADT): String {
    when (status) {
        is DeliveryStatusADT.Preparing -> return "preparing"
        is DeliveryStatusADT.Dispatching -> return "$status.trackingNumber" // ohne casting !
        is DeliveryStatusADT.Delivered -> return "delivered" // TODO, mal auskommentieren... der Compiler hilft !
    }
}
