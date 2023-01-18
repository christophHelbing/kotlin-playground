package delegation

import delegation.dao.ApplicationDao
import delegation.delegate.ApplicationDelegate
import delegation.model.ApplicationReadModel
import java.time.LocalDateTime

fun main() {
    val dao = ApplicationDao(
        id = "urn:application:1",
        state = 1,
        admissionDate = LocalDateTime.now(),
        companyName = "Helbing Enterprises",
        companyStreet = "This-Street",
        companyZipCode = "08151",
        companyCity = "TownTown"
    )

    val application = ApplicationReadModel(delegate = ApplicationDelegate(applicationDao = dao))

    assert(application.id == dao.id, { "Field id is not equal" })
    assert(application.state == dao.state, { "Field state is not equal" })
    assert(application.admissionDate == dao.admissionDate, { "Field admissionDate is not equal" })
    assert(application.companyInformation?.name == dao.companyName, { "Field companyInformation.name is not equal" })
    assert(application.companyInformation?.legalForm == null, { "Field companyInformation.legalForm is not equal" })
    assert(application.companyInformation?.companyAddress?.id == "urn:address:1", { "Field companyInformation.companyAddress.id is not equal" })
    assert(application.companyInformation?.companyAddress?.street == dao.companyStreet, { "Field companyInformation.companyAddress.street is not equal" })
    assert(application.companyInformation?.companyAddress?.zipCode == dao.companyZipCode, { "Field companyInformation.companyAddress.zipCode is not equal" })
    assert(application.companyInformation?.companyAddress?.city == dao.companyCity, { "Field companyInformation.companyAddress.city is not equal" })

    println(application.toString())
}