package jackson.domain

data class CompanyInformation(
    val name: String,
    val legalForm: String? = null,
    val companyAddress: Address? = null,
)
