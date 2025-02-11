package utilities.database;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class FileUtils {

    /**
     * Chuyển đổi đối tượng object về định dạng XML
     * Sau đo lưu vào fileName
     * 
     * @param fileName
     * @param object
     */
    public static void writeXMLtoFile(String fileName, Object object) {
        try {
            // tạo đối tượng JAXB Context
            JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());

            // Create đối tượng Marshaller
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // formating
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            // lưu nội dung XML vào file
            File xmlFile = new File(fileName);
            jaxbMarshaller.marshal(object, xmlFile);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    /**
     * Đọc nội dung fileName, sau đó chuyển đổi nội dung của file
     * thành đối tượng có kiểu là clazz.
     * 
     * @param fileName
     * @param clazz
     * @return
     * @throws IOException
     */
    public static Object readXMLFile(String fileName, Class<?> clazz) {
        try {
            CreateFile(fileName);

            File xmlFile = new File(fileName);
            if (xmlFile.length() == 0)
                return null;

            JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            return jaxbUnmarshaller.unmarshal(xmlFile);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void CreateFile(String path) {
        File yourFile = new File(path);
        try {
            Files.createDirectories(Paths.get("database/"));
            if (!yourFile.exists()) {
                yourFile.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } // if file already exists will do nothing
    }
}
