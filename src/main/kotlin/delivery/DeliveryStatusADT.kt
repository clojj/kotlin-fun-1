package delivery

sealed class DeliveryStatusADT {

    object Preparing : DeliveryStatusADT()

    data class Dispatching(
            val trackingNumber: String
    ) : DeliveryStatusADT()

    object Delivered : DeliveryStatusADT()

}
