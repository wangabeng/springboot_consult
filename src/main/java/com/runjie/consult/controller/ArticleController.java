package com.runjie.consult.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
// import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.runjie.consult.utils.MD5Util;



//跨域请求
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("/article")
public class ArticleController {
	// 注入配置
	@Value("${system.filepath}")
    private String filepath;
	@Value("${system.urlpath}")
    private String urlpath;
	
	// 普通图片文件上传
	@PostMapping("/upload")
	public String uploadpic(@RequestParam("file") MultipartFile file) {
		System.out.println("haha");
		System.out.println(file);


		
		String fileName = "";
		if (!file.isEmpty()) {
			if (file.getSize() > 1024 * 1024 * 5) {
				System.out.println("文件太大了 超过5M");
			}
			String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
			if (StringUtils.isBlank(suffix)) {
				System.out.println("上传文件没有后缀，无法识别");
			}

			// 文件名
			fileName = System.currentTimeMillis() + suffix;
			// 上传的文件完整路径 包含文件名 D:/upload/ 在配置文件中配置  一般不要放在项目文件夹下
			String saveFileName = filepath + fileName;
			
			// 创建文件对象
			File dest = new File(saveFileName);
			if (!dest.getParentFile().exists()) { // 判断文件父目录是否存在
				dest.getParentFile().mkdir();
			}
			try {
				file.transferTo(dest); // 保存文件
			} catch (Exception e) {
				e.printStackTrace();
				// return 返回错误信息
				System.out.println("上传失败" + e.getMessage());
				return "上传失败";
			}
		} else {
			// return 返回上传错误
			System.out.println("上传出错");
			return "上传出错";
		}
		
		// 上传成功后返回 此处应该返回url路径  例如 http://localhost:8080/article/1567494335032.png
        String imgUrl= urlpath +  fileName; // 坑 一定要加 http://
        // System.out.println(imgUrl);
        // 返回后 图片在前端不能回显
        return imgUrl;
		
	}
	
	// @RequestParam("content") String content
	// wangeditor文档上传
	@PostMapping("/editorsubmit")
	public void editorsubmit(@RequestBody Map<String, Object> map) {
		// System.out.println(map);
		Map paramMap = (Map) map.get("params");
		
		String author = paramMap.get("author").toString(); 
		String type = paramMap.get("type").toString(); 
		String mainPic = paramMap.get("mainPic").toString();
		String content = paramMap.get("content").toString();
		
		System.out.println(author + type + mainPic + content);
	}
	
	// wangeditor图片上传
	@PostMapping("/editorupload")
	public WangEditorResponse editorupload(@RequestParam("file") MultipartFile file) {

		
		String fileName = "";
		if (!file.isEmpty()) {
			if (file.getSize() > 1024 * 1024 * 5) {
				System.out.println("文件太大了 超过5M");
			}
			String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
			if (StringUtils.isBlank(suffix)) {
				System.out.println("上传文件没有后缀，无法识别");
			}

			// 文件名
			fileName = System.currentTimeMillis() + suffix;
			// 上传的文件完整路径 包含文件名 D:/upload/ 在配置文件中配置  一般不要放在项目文件夹下
			String saveFileName = filepath + fileName;
			
			// 创建文件对象
			File dest = new File(saveFileName);
			if (!dest.getParentFile().exists()) { // 判断文件父目录是否存在
				dest.getParentFile().mkdir();
			}
			try {
				file.transferTo(dest); // 保存文件
			} catch (Exception e) {
				e.printStackTrace();
				// return 返回错误信息
				System.out.println("上传失败" + e.getMessage());
				return new WangEditorResponse("1", "上传失败" + e.getMessage());
			}
		} else {
			// return 返回上传错误
			System.out.println("上传出错");
			return new WangEditorResponse("1", "上传出错");
		}
		
		// 上传成功后返回 此处应该返回url路径  例如 http://localhost:8080/article/1567494335032.png
        String imgUrl= urlpath +  fileName; // 坑 一定要加 http://
        System.out.println(imgUrl);
        // 返回后 图片在前端不能回显
        return new WangEditorResponse("0", imgUrl );
	}
	
	// 返回的WangEditorResponse
	public class WangEditorResponse {
		
		String errno;
		List<String> data;

		public String getErrno() {
			return errno;
		}

		public void setErrno(String errno) {
			this.errno = errno;
		}

		public List<String> getData() {
			return data;
		}

		public void setData(List<String> data) {
			this.data = data;
		}

		
		public WangEditorResponse(String errno, List<String> data) {
			this.errno = errno;
			this.data = data;
		}

		public WangEditorResponse(String errno, String data) {
			this.errno = errno;
			this.data = new ArrayList<>();
			this.data.add(data);
		}
	}
}
