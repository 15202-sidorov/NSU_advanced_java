package lab1;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.file.Paths;
import java.nio.file.Files;

import org.apache.commons.compress.compressors.bzip2.BZip2CompressorInputStream;

public class OSMXmlStAXbz2Reader {

    public static InputStream getInputStreamFromBz2(URI uri) throws IOException {
        InputStream inputStream = Files.newInputStream(Paths.get(uri));
        return new BZip2CompressorInputStream(inputStream);
    }
}
