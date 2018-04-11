package servlet;

import java.io.*;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

@WebServlet(name="UploadServlet",urlPatterns= {"/uploadServlet"})
public class UploadServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		HttpSession session = req.getSession();
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(8*1024);//设置缓冲区大小
		//定义upload组件
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			List<FileItem> items = upload.parseRequest(req);
			String realPath = "";
			String fileName = "";
			for(FileItem item : items) {
				if(!item.isFormField()) {
					realPath = session.getServletContext().getRealPath("");
					FileOutputStream os = new FileOutputStream(realPath + File.separator + item.getName());
					fileName = item.getName();
					if(fileName.endsWith(".jsp")) {
						req.setAttribute("msg","不能上传该类型文件！");
						req.getRequestDispatcher("fail.jsp").forward(req,resp);
					}else {
						req.getSession().setAttribute("realpath",realPath);
						req.getSession().setAttribute("filename",fileName);
						req.getRequestDispatcher("upload.jsp").forward(req,resp);
						IOUtils.copy(item.getInputStream(),os);
						os.flush();
						os.close();
					}
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
	}
}
