package delegation

import delegation.dao.ApplicationDao
import delegation.delegate.ApplicationDelegate
import delegation.model.ApplicationReadModel
import org.junit.jupiter.api.Test
import java.time.LocalDateTime
import kotlin.test.assertEquals

class DelegationTest {

    @Test
    fun `property and class delegation for complex object`() {
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

        assertEquals(dao.id, application.id, "Field id is not equal")
        assertEquals( dao.state,application.state, "Field state is not equal" )
        assertEquals(dao.admissionDate,application.admissionDate,   "Field admissionDate is not equal" )
        assertEquals(dao.companyName, application.companyInformation?.name,  "Field companyInformation.name is not equal" )
        assertEquals(null, application.companyInformation?.legalForm, "Field companyInformation.legalForm is not equal")
        assertEquals("urn:address:1", application.companyInformation?.companyAddress?.id, "Field companyInformation.companyAddress.id is not equal")
        assertEquals(dao.companyStreet, application.companyInformation?.companyAddress?.street, "Field companyInformation.companyAddress.street is not equal")
        assertEquals(dao.companyZipCode, application.companyInformation?.companyAddress?.zipCode, "Field companyInformation.companyAddress.zipCode is not equal")
        assertEquals(dao.companyCity, application.companyInformation?.companyAddress?.city, "Field companyInformation.companyAddress.city is not equal")
    }
}