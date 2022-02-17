package epam.advanced.practice2.data;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.Arrays;
import java.util.Iterator;

import com.fasterxml.jackson.databind.ObjectMapper;

public class CityHelper {

    public static String getPathXmlFile(){
        return "src/epam/advanced/practice2/resourses/Array.xml";
    }
    public static String getPathJsonFile(){
        return "src/epam/advanced/practice2/resourses/StructureData.json";
    }

    public static void main(String[] args) throws IOException {
        String path = getPathXmlFile();
        writeToXML(getExampleCityArray(), path);
        System.out.println(Arrays.toString((City[])readToXml(path)));
    }
    public static City[] getExampleCityArray(){
        return new City[]{
                new City("Argentina",2_736_690,45_165_774),
                new City("Brazil",8_358_140,212_559_417),
                new City("Canada",9_093_510,37_742_154),
                new City("China",9_388_211,1_439_323_776),
                new City("Germany",348_560,83_783_942),
                new City("India",2_973_190,1_380_004_385),
                new City("Japan",364_555,126_476_461)
        };
    }
    public static void writeToXML(Object object, String path) throws IOException {
        try (XMLEncoder out = new XMLEncoder(
                new ObjectOutputStream(
                        new FileOutputStream(path)))) {
            out.writeObject(object);
        }
    }
    public static Object readToXml(String path) throws IOException{
        try(XMLDecoder in = new XMLDecoder(
                new ObjectInputStream(
                        new FileInputStream(path)
                )
        )){
            return in.readObject();
        }
    }
    public static void writeToJsonIterator(Iterator<Object> iterator, String path) throws IOException{
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path))){
            ObjectMapper mapper = new ObjectMapper();
            while (iterator.hasNext()) {
                out.writeObject(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(iterator.next()));
            }
        }
    }
}
