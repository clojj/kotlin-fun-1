package delivery

class DeliveryStatusKotlinNullable(val stage: Stage, val trackingInfo: TrackingInfo) {

    enum class Stage {
        PREPARING,
        DISPATCHED,
        WAITING_FOR_YOU_TO_LEAVE_HOME_SO_YOU_WILL_MISS_IT
    }

    inner class TrackingInfo(val trackingNumber: String)

}
