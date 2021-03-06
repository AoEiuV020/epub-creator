package coza.opencollab.epub.creator;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;

import coza.opencollab.epub.creator.model.EpubBook;

/**
 * @author OpenCollab
 */
public class EpubCreatorTest {

    @Test
    public void testEpubCreate() throws Exception {
        FileOutputStream file = new FileOutputStream(new File("test.epub"));
        EpubBook book = new EpubBook("en", "Samuel .-__Id1", "Samuel Test Book", "Samuel Holtzkampf");

        book.addContent(this.getClass().getResourceAsStream("/epub30-overview.xhtml"),
                "application/xhtml+xml", "xhtml/epub30-overview.xhtml", true, true).setId("Overview");
        book.addContent(this.getClass().getResourceAsStream("/idpflogo_web_125.jpg"),
                "image/jpeg", "img/idpflogo_web_125.jpg", false, false);
        book.addContent(this.getClass().getResourceAsStream("/epub-spec.css"),
                "text/css", "css/epub-spec.css", false, false);
        book.addTextContent("TestHtml", "xhtml/samuelTest2.xhtml", "Samuel test one two four!!!!!\nTesting two").setToc(true);
        book.addTextContent("TestHtml", "xhtml/samuelTest.xhtml", "Samuel test one two three\nTesting two").setToc(true);
        book.addCoverImage(IOUtils.toByteArray(this.getClass().getResourceAsStream("/P1010832.jpg")),
                "image/jpeg", "images/P1010832.jpg");


        book.writeToStream(file);
        // TODO : real tests to see if document correct, this is just to test that creation is succesfull
    }
}
