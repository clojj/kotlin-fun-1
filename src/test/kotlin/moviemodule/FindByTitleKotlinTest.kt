package moviemodule

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

class FindByTitleKotlinTest {

    val MATRIX = Movie("Matrix", "1999")
    val A_BEAUTIFUL_MIND = Movie("A beautiful mind", "2001")
    val INTOUCHABLE = Movie("Intouchable", "2011")
    val FORREST_GUMP = Movie("Forrest Gump", "1994")

    val FILM_COLLECTION = mutableListOf(MATRIX, A_BEAUTIFUL_MIND, INTOUCHABLE, FORREST_GUMP)

    @Test
    fun `should return empty when non found`() {
        val result = findByTitle("Other film", FILM_COLLECTION)
        assertTrue(result.isEmpty())
    }

    @Test
    fun `should return a matching movie`() {
        val result = findByTitle("Matrix", FILM_COLLECTION)
        assertNotNull(result)
    }

    @Test
    fun `should return all matching movies`(){
        val expectedResult = listOf(INTOUCHABLE, FORREST_GUMP)

        val result = findByTitle("o", FILM_COLLECTION)

        assertEquals(expectedResult, result)
    }

}