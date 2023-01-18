package delegation.delegate

import delegation.dao.ApplicationDao
import delegation.model.Address
import delegation.model.CompanyInformation
import delegation.model.CompanyInformationModel
import kotlin.reflect.KProperty

class CompanyInformationDelegate(
    applicationDao: ApplicationDao,
) : CompanyInformation {
    override val name: String? = applicationDao.companyName
    override val legalForm: String? = null
    override val companyAddress: Address? by AddressDelegate(applicationDao = applicationDao)

    operator fun getValue(applicationDelegate: ApplicationDelegate, property: KProperty<*>): CompanyInformation =
        CompanyInformationModel(
            this
        )
}