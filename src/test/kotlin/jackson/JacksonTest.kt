package jackson

import jackson.domain.Address
import jackson.domain.Application
import jackson.domain.CompanyInformation
import org.junit.jupiter.api.Test
import java.time.LocalDateTime
import kotlin.test.assertEquals

class JacksonTest {

    @Test
    fun `serialize dataclass structure and deserialize to another data class structure`() {
        val application = Application(
            id = "urn:application:1",
            admissionDate = LocalDateTime.now(),
            companyInformation = CompanyInformation(
                name = "Helbing Enterprises",
                legalForm = null,
                companyAddress = Address(
                    street = "The-Street",
                    zipCode = "08151",
                    city = "TownTown"
                )
            )
        )

        val jsonString = serialize(application = application)
        val applicationWrite = deserialize(jsonString = jsonString)

        assertEquals(application.id, applicationWrite.id, "Field id not equal")
        assertEquals(application.admissionDate, applicationWrite.admissionDate, "Field admissionDate not equal")
        assertEquals(application.companyInformation.name, applicationWrite.companyInformation.name, "Field companyInformation.name not equal")
        assertEquals(application.companyInformation.legalForm, applicationWrite.companyInformation.legalForm, "Field companyInformation.legalForm not equal")
        assertEquals(application.companyInformation.companyAddress?.street, applicationWrite.companyInformation.companyAddress?.street, "Field companyAddress.street not equal")
        assertEquals(application.companyInformation.companyAddress?.zipCode, applicationWrite.companyInformation.companyAddress?.zipCode, "Field companyAddress.zipCode not equal")
        assertEquals(application.companyInformation.companyAddress?.city, applicationWrite.companyInformation.companyAddress?.city, "Field companyAddress.city not equal")
    }
}