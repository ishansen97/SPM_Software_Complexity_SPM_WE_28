package controllers;

import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

/**
 * Servlet implementation class FileUploadHandler
 */
@WebServlet("/upload")
public class FileUploadHandler extends HttpServlet {
    private final String UPLOAD_DIRECTORY = "C:/uploads";
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        //process only if its multipart content
        if(ServletFileUpload.isMultipartContent(request)){
            try {
                List<FileItem> multiparts = new ServletFileUpload(
                                         new DiskFileItemFactory()).parseRequest(request);
               
                for(FileItem item : multiparts){
                    if(!item.isFormField()){
                    	File file = new File(item.getName());
                        String name = new File(item.getName()).getName();
                        String extension = FilenameUtils.getExtension(item.getName());
                        
                        if (!extension.equals("java")) {
                        	request.setAttribute("error", "You must upload a .java file");
                        	request.getRequestDispatcher("/index.jsp").forward(request, response);
                        }
                        else {
                            item.write( new File(UPLOAD_DIRECTORY + File.separator + name));
                        	request.setAttribute("message", "File Uploaded Successfully");
                        	request.setAttribute("filePath", "C:\\uploads\\" + name);
                        	request.setAttribute("fileName", item.getName());
                        	request.getRequestDispatcher("/CalculateComplexity.jsp").forward(request, response);
                        }
                        System.out.println("C:\\uploads\\" + name);
                    }
                }
            
               //File uploaded successfully
               
            } catch (Exception ex) {
               request.setAttribute("message", "File Upload Failed due to " + ex);
            }          
          
        }else{
            request.setAttribute("message",
                                 "Sorry this Servlet only handles file upload request");
        }
     
//        request.getRequestDispatcher("/CalculateComplexity.jsp").forward(request, response);
//        response.sendRedirect("/CalculateComplexity.jsp");
      
    }
   
}	