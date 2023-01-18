package jackson.write


import jackson.domain.CompanyInformation
import java.time.LocalDateTime

data class ApplicationWrite(
    val id: String,
    val state: Int = 0,
    val admissionDate: LocalDateTime,
    val companyInformation: CompanyInformation,
)
