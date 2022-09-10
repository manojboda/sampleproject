package com.howtodoinjava.demo.web;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.howtodoinjava.demo.model.RegistrationForm;
@RestController
public class UploadController {
//store uploaded file to this folder
private static String upload_dir = "C:/springfileupload/";
 
@GetMapping("/")
public String register() {
return "registration";
}
@PostMapping("/register")
public String doRegister(@ModelAttribute RegistrationForm form,ModelMap model,HttpSession session
) {
ArrayList<String> fileNames = null;
if(form.getAlbums().length>0) {
fileNames = new ArrayList<String>();
for(MultipartFile file:form.getAlbums()) {
if (file.isEmpty()) {
model.put("message", "Please select a file to upload");
}
try {
file.transferTo(new File(upload_dir + file.getOriginalFilename()));
fileNames.add(file.getOriginalFilename());
} catch (IOException e) {
e.printStackTrace();
}
}
}
model.put("message", "Please select a file to upload");
model.put("name", form.getName());
model.put("email", form.getEmail());
model.put("files",fileNames);
System.out.println("Email : "+form.getEmail());
return "success";
}
 
@RequestMapping(value = "/image/{imageName}")
@ResponseBody
public byte[] getImage(@PathVariable("imageName") String fileName) throws IOException{
File file = new File(upload_dir+fileName);
System.out.println(file.getAbsolutePath());
return Files.readAllBytes(file.toPath());
}
}