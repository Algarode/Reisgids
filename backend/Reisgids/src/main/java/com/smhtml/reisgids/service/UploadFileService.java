/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smhtml.reisgids.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;


/**
 *
 * @author Stefan Bogaard
 */
@Path("com.smhtml.reisgids.file")
public class UploadFileService {

//    @POST
//	@Path("/uploadme/{email}")
//	@Consumes(MediaType.MULTIPART_FORM_DATA)
//	public Response uploadFile2(@PathParam("email") String email,
//		@FormDataParam("file") InputStream uploadedInputStream) {
//                System.out.println("uploadme called!");
//            
//                String uploadDir = "uploadFiles" + File.separator + email;
//		String uploadedFileLocation = uploadDir + File.separator + "mwhaha.png";
//
//                File fileSaveDir = new File(uploadDir);
//                if (!fileSaveDir.exists()) {
//                    fileSaveDir.mkdir();
//                }
//		// save it
//		writeToFile(uploadedInputStream, uploadedFileLocation);
//
//		String output = "File uploaded to : " + uploadedFileLocation;
//
//		return Response.status(200).entity(output).build();
//
//	}
    
    
    /**
     * This method dont work, use multipartform instead!!!
     * @param email the email id of the user 
     * @param blob the file as string
     * @return Response
     */
//    @Deprecated
//    @POST
//    @Path("/upload/blob/{email}/{blob}")
//    @Consumes(MediaType.TEXT_PLAIN)
//    public Response uploadBlob(@PathParam("email") String email, @PathParam("blob") String blob){
//        
//        System.out.println(blob);
//        
//        return Response.status(200).build();
//    }
    
    
    /**
     * Uploads a file to the server. Email is used to determine where to store the file.
     * @param email the email id of the user
     * @param uploadedInputStream the file as inputstream
     * @param fileDetail details of the file
     * @return a response
     */
	@POST
	@Path("/upload/{email}")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response uploadFile(@PathParam("email") String email,
		@FormDataParam("file") InputStream uploadedInputStream,
		@FormDataParam("file") FormDataContentDisposition fileDetail) {

                System.out.println("upload called!");
                
                String uploadDir = "uploadFiles" + File.separator + email;
		String uploadedFileLocation = uploadDir + File.separator + fileDetail.getFileName();

                File fileSaveDir = new File(uploadDir);
                if (!fileSaveDir.exists()) {
                    fileSaveDir.mkdir();
                }
		// save it
		writeToFile(uploadedInputStream, uploadedFileLocation);
		String output = "File uploaded to : " + uploadedFileLocation;
		return Response.status(200).entity(output).build();
	}
        
        
        @GET
        @Path("/download/{email}/{filename}")
        @Produces("image/png")
        public Response getImage(@PathParam("email") String email, @PathParam("filename") String filename){
            File file = new File("uploadFiles" + File.separator + email + File.separator + filename);
            ResponseBuilder response = Response.ok((Object) file);  
            response.header("Content-Disposition", "attachment; filename=" + filename);
            //response.header("Content-Disposition", "attachment; filename=\"foto.jpg\"");  
            return response.build();  
        }
        
	/**
         * This method stores files on the specified location on the server.
         * @param uploadedInputStream the file inputstream
         * @param uploadedFileLocation location where the file should be stored
         */
	private void writeToFile(InputStream uploadedInputStream,
		String uploadedFileLocation) {

		try {
			OutputStream out = new FileOutputStream(new File(
					uploadedFileLocation));
			int read = 0;
			byte[] bytes = new byte[1024];

			out = new FileOutputStream(new File(uploadedFileLocation));
			while ((read = uploadedInputStream.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
			out.flush();
			out.close();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}
        /**
         * Do
         * @return
         * @deprecated
         
        @Deprecated
        @GET
        @Path("/download")
        @Produces("image/png")
        public Response getImage(){
            File file = new File("uploadFiles" + File.separator + "stefan@bogaard.nl" + File.separator + "AAAA.jpg");
            ResponseBuilder response = Response.ok((Object) file);  
            response.header("Content-Disposition", "attachment; filename=\"foto.jpg\"");  
            return response.build();  
        }
        
	// save uploaded file to new location
	private void writeToFile(InputStream uploadedInputStream,
		String uploadedFileLocation) {

		try {
			OutputStream out = new FileOutputStream(new File(
					uploadedFileLocation));
			int read = 0;
			byte[] bytes = new byte[1024];

			out = new FileOutputStream(new File(uploadedFileLocation));
			while ((read = uploadedInputStream.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
			out.flush();
			out.close();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}*/

}