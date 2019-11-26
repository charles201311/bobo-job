package com.bw.job.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.bw.job.domain.Position;
import com.bw.job.domain.Score;
import com.bw.job.domain.User;
import com.bw.job.service.UserService;
import com.bw.job.vo.UserVO;
import com.github.pagehelper.PageInfo;

@Controller
public class UserController {
	@Resource
	private UserService userService;

	@GetMapping("users")
	public String selects(Model model, UserVO userVO, @RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "3") Integer pageSize) {
		PageInfo<User> info = userService.selects(userVO, page, pageSize);
		model.addAttribute("info", info);
		return "users";

	}

	/**
	 * 
	 * @Title: add
	 * @Description: 去增加页面
	 * @return
	 * @return: String
	 */
	@GetMapping("add")
	public String add(Model model) {

		model.addAttribute("user", new User());

		return "add";

	}

	@PostMapping("add")
	public String add(HttpServletRequest request, User user, MultipartFile file, Integer[] scores, Integer[] pids,
			BindingResult result) {
		// if(result.hasErrors()) { return "add"; }

		if (!file.isEmpty()) {
			// 文件上传路径.把文件放入项目的 /resource/pic 下
			String path = request.getSession().getServletContext().getRealPath("/resource/pic/");
			// 为了防止文件重名.使用UUID 的方式重命名上传的文件
			String oldFilename = file.getOriginalFilename();
			// a.jpg
			String newFilename = UUID.randomUUID() + oldFilename.substring(oldFilename.lastIndexOf("."));
			File f = new File(path, newFilename);
			// 写入硬盘
			try {
				file.transferTo(f);

				user.setPicUrl(newFilename);// 用户照片
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		// 封装应聘者的信息
		ArrayList<Score> list = new ArrayList<Score>();

		for (int i = 0; i < pids.length; i++) {
			Score score = new Score();
			score.setPid(pids[i]);
			score.setScore(scores[i]);
			list.add(score);
		}

		userService.insert(user, list);
		return "redirect:/users";

	}
	
	/**
	 * 
	 * @Title: select 
	 * @Description: 个人详情
	 * @param model
	 * @param id
	 * @return
	 * @return: String
	 */
	@RequestMapping("select")
	public String select(Model model,Integer id) {
		User user = userService.select(id);
		model.addAttribute("user", user);
		return "user";
	}

	@ResponseBody
	@GetMapping("selectsPosition")
	public List<Position> selectsPoition() {

		return userService.selectsPosition();
	}
}
