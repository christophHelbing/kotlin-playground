package delegation.dao

import java.time.LocalDateTime

class ApplicationDao (
    val id: String,
    val state: Int,
    val admissionDate: LocalDateTime,
    val companyName: String?,
    val companyStreet: String?,
    val companyZipCode: String?,
    val companyCity: String?,
)