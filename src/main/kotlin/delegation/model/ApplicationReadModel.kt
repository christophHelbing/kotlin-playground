package delegation.model

import delegation.delegate.ApplicationDelegate
import java.time.LocalDateTime

interface ApplicationModel {
    val id: String
    val state: Int
    val admissionDate: LocalDateTime
    val companyInformation: CompanyInformation?
}

class ApplicationReadModel (
    private val delegate: ApplicationDelegate
) : ApplicationModel by delegate {
    override fun toString(): String {
        return """
            ApplicationReadModel(
                id = $id
                state = $state
                admissionDate = $admissionDate
                companyInformation = CompanyInformation(
                    name = ${companyInformation?.name}
                    legalForm = ${companyInformation?.legalForm}
                    companyAddress = Address(
                        id = ${companyInformation?.companyAddress?.id}
                        street = ${companyInformation?.companyAddress?.street}
                        zipCode = ${companyInformation?.companyAddress?.zipCode}
                        city = ${companyInformation?.companyAddress?.city}
                    )
                )    
            )            
        """
    }
}