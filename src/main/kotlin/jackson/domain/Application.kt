package jackson.domain

import java.time.LocalDateTime

data class Application(
    val id: String,
    val admissionDate: LocalDateTime,
    val companyInformation: CompanyInformation,
)