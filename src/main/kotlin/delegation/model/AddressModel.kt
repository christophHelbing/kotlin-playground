package delegation.model

import delegation.delegate.AddressDelegate

interface Address {
    val id: String?
    val street: String?
    val zipCode: String?
    val city: String?

    // If this will be added to the Model a compile error will be thrown -> so this model creation pattern forces devs
    // to actually consider to all layers of the application
    // val houseNr: String?
}

class AddressModel (
    private val delegate: AddressDelegate
) : Address by delegate