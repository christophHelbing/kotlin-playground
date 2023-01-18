package delegation.delegate

import delegation.dao.ApplicationDao
import delegation.model.Address
import delegation.model.AddressModel
import kotlin.reflect.KProperty

class AddressDelegate(
    applicationDao: ApplicationDao,
) : Address {
    override val id: String = "urn:address:1"
    override val street: String? = applicationDao.companyStreet
    override val zipCode: String? = applicationDao.companyZipCode
    override val city: String? = applicationDao.companyCity

    operator fun getValue(companyInformationDelegate: CompanyInformationDelegate, property: KProperty<*>): Address =
        AddressModel(
            this
        )
}