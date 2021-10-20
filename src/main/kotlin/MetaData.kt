import androidx.compose.ui.res.painterResource
import org.w3c.dom.Element
import org.w3c.dom.Node
import org.xml.sax.SAXException
import java.io.File
import java.io.IOException
import javax.xml.parsers.DocumentBuilderFactory
import javax.xml.parsers.ParserConfigurationException
import kotlin.reflect.KMutableProperty
import kotlin.reflect.full.companionObject
import kotlin.reflect.full.memberProperties

class MetaData {
    private val metaDataFileName = javaClass.classLoader.getResource("MetaData.xml")?.toURI()
    private fun readMetaData() {
        try {
            val xmlFile = File(metaDataFileName)
            val dbFactory = DocumentBuilderFactory.newInstance()
            val dBuilder = dbFactory.newDocumentBuilder()
            val doc = dBuilder.parse(xmlFile)
            doc.documentElement.normalize()
            val nodeList = doc.getElementsByTagName("field")
            for (i in 0 until nodeList.length) {
                val nNode = nodeList.item(i)
                if (nNode.nodeType == Node.ELEMENT_NODE) {
                    val element = nNode as Element
                    val type = element.getElementsByTagName("type").item(0).textContent
                    val varName = element.getAttribute("id")
                    var value: Any? = null
                    var unparsedString: String? = ""
                    try {
                        unparsedString = element.getElementsByTagName("value").item(0).textContent
                    } catch (e: NullPointerException) {
                    }
                    when (type) {
                        "String" -> {
                            value = unparsedString
                        }
                        "Integer" -> {
                            value = Integer.valueOf(unparsedString)
                        }
                        "Boolean" -> {
                            value = unparsedString.toBoolean()
                        }
                    }

                    val property = this::class.companionObject?.memberProperties?.first { it.name == varName }
                    if (property is KMutableProperty<*>) {
                        property.setter.call(Companion, value)
                    }
                }
            }
        } catch (e: ParserConfigurationException) {
            e.printStackTrace()
        } catch (e: SAXException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        } catch (e: NoSuchFieldException) {
            e.printStackTrace()
        } catch (e: IllegalAccessException) {
            e.printStackTrace()
        }
    }

     companion object {
         // Strings
         var windowTitle = "windowTitle"
         var menuButtonTextPvp = "menuButtonTextPvp"
         var menuHeadlineText = "menuHeadlineText"
         var menuButtonTextPvb = "menuButtonTextPvb"
         // Image names
         var menuButtonImagePvp = "menuButtonImagePvp"
         var appKnightImage = "appKnightImage"
         var menuButtonImagePvb = "menuButtonImagePvb"

        // Ints
        var windowWidth = 800
        var windowHeight = 800

        // Booleans
    }

    init {
        readMetaData()
    }
}