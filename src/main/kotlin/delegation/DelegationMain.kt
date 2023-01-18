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
    println(application.toString())
}