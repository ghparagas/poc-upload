package com.example.pocupload.resource;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.StreamingOutput;
import org.apache.tomcat.util.http.fileupload.IOUtils;

import java.io.InputStream;

@Path("/pdf")
public class PdfResource {

    @GET
    public Response downloadPdfFile() {
        StreamingOutput fileStream =  new StreamingOutput() {
            @Override
            public void write(java.io.OutputStream output) throws WebApplicationException
            {
                try
                {
                    ClassLoader classLoader = getClass().getClassLoader();
                    InputStream inputStream = classLoader.getResourceAsStream("test.pdf");
                    IOUtils.copy(inputStream, output);
                    inputStream.close();
                }
                catch (Exception e)
                {
                    throw new WebApplicationException("Something went wrong. Check server logs.");
                }
            }
        };

        return Response
                .ok(fileStream, MediaType.APPLICATION_OCTET_STREAM)
                .header("content-disposition","attachment; filename = merged-file.pdf")
                .build();
    }
}
