package com.project.myapp.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.project.myapp.VO.WritingVO;
import com.project.myapp.service.ImageService;
import com.project.myapp.service.WritingDAOService;

import net.coobird.thumbnailator.Thumbnails;

/**
 * Handles requests for the application home page.
 */
@Controller
public class WritingController {

	@Autowired
	private FileSystemResource fileSystemResource; // fileupload metadata wiring
	// FileSystemResource

	@Autowired
	private WritingDAOService writingDaoService;

	@Autowired
	private ImageService imageService;
	

	// 글쓰기 페이지로 가기 위해서
	@RequestMapping("/writing.do") // 글쓰기 서블릿 앱핑
	public String writingDo(Model model) {
		System.out.println("이 것은 WritingController에서 쓴 것");
		model.addAttribute("wirtingVO", new WritingVO());
		return "writing";
	}

	/**
	 * * 게시물 INSERT
	 * 
	 * @return
	 */
	@RequestMapping("/writingAction.do")
	public ModelAndView writingActionDo(@RequestParam Map<String, Object> paramMap,
			@RequestParam("imageFile") MultipartFile file, Model model) {
		/* @ModelAttribute("uploadForm") ImageUploadVO imageUploadForm, */
		System.out.println("  ~~~~~~~~~~~~~~~~~   homeController   writingActionDo() ~~~~~~~~~  ");
		System.out.println(" 파일 비어있는 지 check  " + file.isEmpty());
		System.out.println(" 파일 사이즈  " + file.getSize());
		WritingVO writingVO = new WritingVO();

		Set<Entry<String, Object>> entryMap = paramMap.entrySet();

		for (Entry<String, Object> entry : entryMap) {
			System.out.println(entry.getKey() + " = " + entry.getValue());
		}

		// System.out.println(" 파일 이름 : " +
		// ((MultipartFile)paramMap.get("imageFile")).getOriginalFilename());

		System.out.println("  글쓰기 인자 값    :  " + writingVO); // 콘솔창에서 VO 집어 넣었는지
																// 확인

		System.out.println("  파일 이름   :    " + file.getOriginalFilename());

		/// 이미지 업로드 부분 /////////////////////////////////
		int pk = imageService.getWritingPrimaryKey();
		/*
		 * String check_pk =String.valueOf(pk); if (check_pk==null
		 * ||check_pk.isEmpty() ) { pk = 0; }
		 */
		System.out.println("            primarykey 가져오기            " + pk);

		// 썸네일 파일 이름을 전송하기 위해

		// 오류(에러) 처리 메소드에서 , BindingResult result 파라미터 해줘야 함
		/*
		 * if (result.hasErrors()) { for (ObjectError error :
		 * result.getAllErrors()) { System.err.println("Error: " +
		 * error.getCode() + " - " + error.getDefaultMessage()); } // return
		 * "/show"; }
		 */

		if (!file.isEmpty()) { // 파일(들) 유효성 점검

			// 받아온 파일 이름 가공
			String tmpFileName = pk + "~" + file.getOriginalFilename();
			// 파일의 확장자 추출, .이 마지막으로 찍힌 부분에서 +1 한 자리부터 마지막 인덱스까지 문자열을 자름
			String tmpFileExt = tmpFileName.substring(tmpFileName.lastIndexOf(".") + 1, tmpFileName.length());

			System.out.println("파일명  :  " + tmpFileName + "  확장자  :  " + tmpFileExt);

			// 업로드 파일 확장자 제한 : 그림 파일 업로드 게시판용
			if (tmpFileExt.equalsIgnoreCase("JPG") || tmpFileExt.equalsIgnoreCase("JPEG")
					|| tmpFileExt.equalsIgnoreCase("PNG") || tmpFileExt.equalsIgnoreCase("GIF")) {

				//
				FileOutputStream fos = null;
				String fileName = pk + "~" + file.getOriginalFilename();

				// 위에서 선언해준 filename에 메소드로 파일이름 따와서 집어넣기
				System.out.println(" 여기서도 파일이름 확인해보자   :  " + file.getOriginalFilename());

		/*		 파일 저장소(C:/Users/fany3/Dropbox/image_path/) 에 저장 <=
				 rootContext에서 정의함*/

				try {
					// byte[] bytes = uploadForm.getFiles().get(i).getBytes();
					byte[] bytes = file.getBytes();

					File outFileName = new File(fileSystemResource.getPath() + fileName);
					// File 객체의 용도, fileSystemResource.getPath() : 파일 경로 가져오기(xml에서 경로 등록해야 사용가능

					// 썸네일 경로 설정
					String thumbPath = fileSystemResource.getPath() + "thumbnail/";
					// 썸네일 파일 이름 설정, fileName.split("\\.")[0] : \\를 기준으로 앞에께 인덱스
					// 0, 뒤에께 인덱스 1
					String thumbPathFileName = "thumb_" + fileName.split("\\.")[0] + ".png";

					fos = new FileOutputStream(outFileName);
					fos.write(bytes);

					File thumbnail = new File(thumbPathFileName);
					Thumbnails.of(outFileName).size(200, 100).outputFormat("png").toFile(thumbPath + thumbnail);

					System.out.println("  썸네일 이름     " + thumbPathFileName);
					
					
					writingVO.setId(paramMap.get("id").toString());
					writingVO.setModel_name(paramMap.get("model_name").toString());
					writingVO.setImage_name(fileName); // vo에 파일이름 집어넣기
					writingVO.setTitle(paramMap.get("title").toString());
					writingVO.setContent(paramMap.get("content").toString());
					// vo에 썸네일 파일이름 집어넣기
					writingVO.setThumbnail_name(thumbPathFileName);
					
				} catch (IOException e) {
					System.out.println("FileUploadController save File writing error ! ");
					e.printStackTrace();
				} finally {
					try {
						if (fos != null)
							fos.close();
					} catch (IOException e) {
						System.out.println("FileUploadController save IOE : ");
						e.printStackTrace();
					}
					System.out.println("File upload success! ");
				} // finally
			} // if
		} // 파일 유효성점검 끝
		else {
			System.err.println("  파일 내용이 비어 있습니다...!   ");
		}
		System.out.println("insert 하기전 찍어보는 writingVO :  " + writingVO);
		writingDaoService.inserWriting(writingVO); // insert관련 부분
		System.out.println("게시물 등록");
		ModelAndView mv = new ModelAndView("writing");
		// ModelAndView :
		return mv;
	}
}
