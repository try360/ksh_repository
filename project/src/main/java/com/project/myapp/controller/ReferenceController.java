package com.project.myapp.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.project.myapp.VO.WritingVO;
import com.project.myapp.service.WritingDAOService;

import net.coobird.thumbnailator.Thumbnails;

@Controller
public class ReferenceController {

	@Autowired
	private FileSystemResource fileSystemResource;

	@Autowired
	private WritingDAOService writingDAOService;

	@RequestMapping("/writingDetail.do")
	// @ResponseBody
	public String read(@RequestParam("w_no") int w_no, Model model) {

		System.out.println("   ReferenceContoller   read() ");

		System.out.println("참조할 글 번호   :  " + w_no);

		// 조회수 증가시키기
		writingDAOService.viewCount(w_no);

		/// 상세글 조회하기
		System.out.println("writingDAOService.referWriting(W_no) 값  :  " + writingDAOService.referWriting(w_no));
		WritingVO writingVO = writingDAOService.referWriting(w_no);

		writingVO.setImage_name(writingVO.getImage_name());
		System.out.println("image_name 값    :  " + writingVO.getImage_name());
		model.addAttribute("writing", writingVO);

		return "referWriting";
	}

	@RequestMapping(value = "/deleteWriting.do", produces = "text/plain; charset=UTF-8")
	@ResponseBody
	public String deleteWriting(@RequestParam("w_no") int w_no) {
		System.out.println("  ################ deleteWriting#" + w_no);

		WritingVO writingVO = writingDAOService.getWriting(w_no);
		System.out.println(writingVO);

		String msg = "";
		try {
			if (writingDAOService.getWriting(w_no) == null)
				throw new Exception();
			writingDAOService.deleteWriting(w_no);
			msg = "삭제에 성공했습니다";
		} catch (Exception e) {
			// e.printStackTrace();
			msg = "삭제 실패";
		}
		System.out.println("###############################get Path");
		System.out.println("fileSystemResource.getPath() :" + fileSystemResource.getPath());
		System.out.println("path :  C:/Users/fany3/Desktop/image_path/");
		System.out.println("지울 파일 이름 :   " + writingVO.getW_no() + "~" + writingVO.getImage_name());

		File file = new File(
				"C:/Users/fany3/Desktop/image_path/" + writingVO.getW_no() + "~" + writingVO.getImage_name());
		File file_thumbnail = new File("C:/Users/fany3/Desktop/image_path/thumbnail/" + writingVO.getThumbnail_name());

		System.out.println(file_thumbnail.getName());
		if (file.exists() && file_thumbnail.exists()) {
			if (file.delete() && file_thumbnail.delete()) {
				System.out.println("파일삭제 성공");
			} else {
				System.out.println("파일삭제 실패");
			}
		} else {
			System.out.println("파일이 존재하지 않습니다.");
		}

		System.out.println("  삭제 결과   : " + msg);

		return msg;
	}

	// 수정창 부르기
	@RequestMapping("/to.updateWriting")
	public String updateWriting(@RequestParam("w_no") int w_no, Model model, HttpServletRequest req) {

		System.out.println("ReferenceController     updateWriting()");

		System.out.println("  w_no 값   :   " + w_no);

		// Set<Entry<String, Object>> entryMap = paramMap.entrySet();

		WritingVO writingVO = writingDAOService.getWriting(w_no);
		/*
		 * WritingVO writingVO = new WritingVO();
		 * writingVO.setW_no(Integer.parseInt(paramMap.get("w_no").toString()));
		 * writingVO.setId(paramMap.get("id").toString());
		 * writingVO.setTitle(paramMap.get("title").toString());
		 * writingVO.setModel_name(paramMap.get("model_name").toString());
		 * writingVO.setContent(paramMap.get("content").toString());
		 */
		model.addAttribute("writingVO", writingVO);

		System.out.println(" 수정 창으로 보내기 전에  writingVO " + writingVO);
		// return "updateWriting/"+w_no;
		return "updateWriting";

	}

	// 수정하여 update하기
	@RequestMapping("/updateWritingAction.do")
	public ModelAndView updateWritingActionDo(@RequestParam Map<String, Object> paramMap,
			@RequestParam("r_imageFile") MultipartFile file, Model model) {

		System.out.println("  ~~~~~~~~~~~~~   ReferenceControllerS  updateWritingActionDo() ~~~~~~  ");
		System.out.println(" 첨부 파일 비었냐???   " + file.isEmpty() + "    넘어온 파일이름 출력   :  " + file.getOriginalFilename());

		// vo에 집어넣기 전에 이미지이름과 섬네일 이름 가공하기
		WritingVO writingVO = new WritingVO();

		Set<Entry<String, Object>> entryMap = paramMap.entrySet();
		// Set : Map.entrySet() :

		// 맵으로 받아온 것 출력해보자
		System.out.println("아래는 맵으로 받아온 것 출력한 것이다");
		for (Entry<String, Object> entry : entryMap) {
			System.out.println(entry.getKey() + " = " + entry.getValue());
		}

		String w_no = paramMap.get("w_no").toString();
		// Map으로 받아 온것 중에서 글 번호 가져옴, 파일 ㄴ

		if (!file.isEmpty()) {

			// 받아온 파일 이름 DB에 넣는 용도로 가공
			String imageName = w_no + "~" + file.getOriginalFilename();
			// 가져온 filname에서 확장차추출
			String tmpFileExt = imageName.substring(imageName.lastIndexOf(".") + 1, imageName.length());

			// fileName을 이용해 섬네일 이름 가공하기
			String thunmbNail_Name = "thumb_" + imageName;

			// 업로드 파일 확장자 제한 : 그림 파일 업로드 게시판용
			if (tmpFileExt.equalsIgnoreCase("JPG") || tmpFileExt.equalsIgnoreCase("JPEG")
					|| tmpFileExt.equalsIgnoreCase("PNG") || tmpFileExt.equalsIgnoreCase("GIF")) {

				//
				FileOutputStream fileOutputStream = null;

				// 위에서 선언해준 filename에 메소드로 파일이름 따와서 집어넣기
				System.out.println(" 여기서도 파일이름 확인해보자   :  " + file.getOriginalFilename());

				/*
				 * 파일 저장소(C:/Users/fany3/Dropbox/image_path/) 에 저장 <=
				 * rootContext에서 정의함
				 */
				try {

					// 여기서부터 수정전 이미지 삭제
					// 수정전 이미지를 삭제하기 위해서 삭제할 이미지의 글 번호를 가져옴
					WritingVO toDeleteVO = writingDAOService
							.getWriting(Integer.parseInt(paramMap.get("w_no").toString()));

					File file_image = new File(
							"C:/Users/fany3/Desktop/image_path/" + toDeleteVO.getImage_name());

					File file_thumbnail = new File(
							"C:/Users/fany3/Desktop/image_path/thumbnail/" + toDeleteVO.getThumbnail_name());

					if (file_image.delete()) {
						System.out.println("이미지 파일이 삭제되었습니다. ");
					} else {
						System.out.println("이미지 파일 삭제에 실패하엿습니다");
					}
					if (file_thumbnail.delete()) {
						System.out.println("섬네일 파일이 삭제되었습니다. ");
					} else {
						System.out.println("섬네일 파일 삭제에 실패하였습니다.");
					}

					// jsp 에서 넘어온 첨부파일의 용량ㅇ
					byte bytes[] = file.getBytes();

					File outFileName = new File(fileSystemResource.getPath() + imageName);
					// File 객체의 용도, fileSystemResource.getPath() : 파일 경로
					// 가져오기(xml에서 경로 등록해야 사용가능

					// 썸네일 경로 설정
					String thumbPath = fileSystemResource.getPath() + "thumbnail/";

					// 섬네일 파일 이름 설정,
					// fileName.split("\\.")[0] : \\를 기준으로 앞에께 인덱스0, 뒤에 것이 인덱스 1
					String thumbPathFileName = "thumb_" + imageName.split("\\.")[0] + ".png";

					fileOutputStream = new FileOutputStream(outFileName);
					fileOutputStream.write(bytes);

					// thumbnail 이란 파일을 만드는 과정, ()안에 파일 이름을 집어넣는다
					File thumbnail = new File(thumbPathFileName);
					Thumbnails.of(outFileName).size(200, 100).outputFormat("png").toFile(thumbPath + thumbnail);

					System.out.println(" 썸네일 이름    :     " + thumbPathFileName);

					writingVO.setImage_name(imageName);
					writingVO.setThumbnail_name(thumbPathFileName);
				} catch (IOException e) {
					System.out.println(" 오류메시지 : 수정 하는 중인데 이미지 갱신이 안됨...");
					e.printStackTrace();
				} finally {
					try {
						if (fileOutputStream != null) {
							fileOutputStream.close();
						}

					} catch (IOException e) {
						System.out.println("FileUploadController save IOE 발생은 다음과 같다    ");
						e.printStackTrace();
					}
					System.out.println("File upload success!   ");
				} // finally
			} // if
		} // 파일 유효성 점검 끝

		writingVO.setW_no(Integer.parseInt(paramMap.get("w_no").toString()));
		writingVO.setId(paramMap.get("id").toString());
		writingVO.setModel_name(paramMap.get("model_name").toString());

		writingVO.setTitle(paramMap.get("title").toString());
		writingVO.setContent(paramMap.get("content").toString());

		System.out.println(" 수정완료 전에 writingVO 값을 확인하자   :  " + writingVO);
		// 콘솔창에서 VO 집어 넣었는지 확인

		writingDAOService.updateWriting(writingVO);

		System.out.println("게시물 수정완료");
		ModelAndView mv = new ModelAndView("writing");
		// ModelAndView :
		return mv;
	}

}
