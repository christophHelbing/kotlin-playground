package delegation.model

import delegation.delegate.CompanyInformationDelegate

interface CompanyInformation {
    val name: String?
    val legalForm: String?
    val companyAddress: Address?
}

class CompanyInformationModel (
    private val delegate: CompanyInformationDelegate
) : CompanyInformation by delegate