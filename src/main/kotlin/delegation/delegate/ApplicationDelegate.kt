package delegation.delegate

import delegation.dao.ApplicationDao
import delegation.model.ApplicationModel
import delegation.model.CompanyInformation
import java.time.LocalDateTime

class ApplicationDelegate(
    applicationDao: ApplicationDao,
) : ApplicationModel {
    override val id: String = applicationDao.id
    override val state: Int = applicationDao.state
    override val admissionDate: LocalDateTime = applicationDao.admissionDate
    override val companyInformation: CompanyInformation? by CompanyInformationDelegate(applicationDao = applicationDao)
}